/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.order;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.Supplier;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class GoToUpdateOrderCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        OrderrJpaController orderDbconn = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Orderr> orderList = orderDbconn.findOrderrEntities();
        request.setAttribute("orderList", orderList);
        SupplierJpaController companyDbconn = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Supplier> supplierList = companyDbconn.findSupplierEntities();
        request.setAttribute("supplierList", supplierList);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        
        return "/jsp/order/UpdateOrder.jsp";
    }
}
