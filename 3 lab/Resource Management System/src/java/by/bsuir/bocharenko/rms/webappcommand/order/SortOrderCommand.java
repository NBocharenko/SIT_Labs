/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.order;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.ordersort.*;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class SortOrderCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        OrderrJpaController dbconn = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Orderr> list = dbconn.findOrderrEntities();
        String type = request.getParameter("sort");
        if(type != null){
            if(type.equalsIgnoreCase("titleSup"))
                Collections.sort(list,new SortOrderBySupplierTitle());
            if(type.equalsIgnoreCase("titleMat"))
                Collections.sort(list,new SortOrderByMaterialTitle());
            if(type.equalsIgnoreCase("signDate"))
                Collections.sort(list,new SortOrderBySignDate());
            if(type.equalsIgnoreCase("execDate"))
                Collections.sort(list,new SortOrderByExecDate());
            if(type.equalsIgnoreCase("totalCost"))
                Collections.sort(list,new SortOrderByTotalCost());
            if(type.equalsIgnoreCase("totalVolume"))
                Collections.sort(list,new SortOrderByTotalVolume());
            if(type.equalsIgnoreCase("isCompleted"))
                Collections.sort(list,new SortOrderByCompleteness());
        }
        request.setAttribute("List", list);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        return "/jsp/order/ReadOrder.jsp";
    }
}
