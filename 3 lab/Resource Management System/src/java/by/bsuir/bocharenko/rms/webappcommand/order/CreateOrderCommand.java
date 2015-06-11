/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.order;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.Supplier;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class CreateOrderCommand implements ICommand{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        Date currentDate;
        try {
            currentDate = DateParser.parseStandartDate(request, "dateForvarded");
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        Date execDate;
        try {
            execDate = DateParser.parseChromeDate(request, "execDate");
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        if(execDate.compareTo(currentDate) < 0){
            request.setAttribute("errorMessage", "Введена некорректная дата");
            return "/jsp/error.jsp";
        }
        String n = request.getParameter("id_sup");
        if(n.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод номера поставщика");
            return "/jsp/error.jsp";
        }
        String tv = request.getParameter("totalVolume");
        if(tv.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод объема заказа");
            return "/jsp/error.jsp";
        }
        Long id = new Long(n);
        SupplierJpaController dbconnSupplier = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        Supplier supplier =  dbconnSupplier.findSupplier(id);
        if(supplier==null){
            request.setAttribute("errorMessage", "Поставщик с таким номером " + id + " не зарегестрирован в БД");
            return "/jsp/error.jsp";
        }
        Integer totalVolume = new Integer(tv);
        Integer totalCost = (int)(totalVolume * supplier.getResourceUnitPrice() + supplier.getDeliveryPrice());
        OrderrJpaController dbconnOrder = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        Orderr order = new Orderr();
        order.setTotalVolume(totalVolume);
        order.setTotalCost(totalCost);
        order.setSupplier(supplier);
        order.setIsCompleted("не завершен");
        try {
            order.setSignDate(DateParser.parseChromeDate(request, "signDate"));
            order.setExecDate(execDate);
            dbconnOrder.create(order);
        } catch (NonexistentEntityException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return "/jsp/error.jsp";
        }
         catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        
        return "/jsp/main.jsp";
    }
}
