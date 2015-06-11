/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.order;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class SearchOrderCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        OrderrJpaController dbconn = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Orderr> list = dbconn.findOrderrEntities();
        List<Orderr> modifiedList = new ArrayList();
        Date minSignDate;
        Date maxSignDate;
        Date minExecDate;
        Date maxExecDate;
        try{
            minSignDate = DateParser.parseChromeDate(request, "minSignDate");
            maxSignDate = DateParser.parseChromeDate(request, "maxSignDate");
            minExecDate = DateParser.parseChromeDate(request, "minExecDate");
            maxExecDate = DateParser.parseChromeDate(request, "maxExecDate");
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        Integer minTotalVolume = new Integer(request.getParameter("minTotalVolume"));
        Integer maxTotalVolume = new Integer(request.getParameter("maxTotalVolume"));
        Integer minTotalCost = new Integer(request.getParameter("minTotalCost"));
        Integer maxTotalCost = new Integer(request.getParameter("maxTotalCost"));
        String isFinished = request.getParameter("isFinished");
        
        System.out.println(list.size());
        if(isFinished!=null){
            for(Orderr order : list){
                if(order.getIsCompleted().equals(isFinished))
                    modifiedList.add(order);  
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        System.out.println(list.size());
        for(Orderr order : list){
            if(minSignDate.compareTo(order.getSignDate()) <= 0 && maxSignDate.compareTo(order.getSignDate()) >= 0
                    && minExecDate.compareTo(order.getExecDate()) <= 0 && maxExecDate.compareTo(order.getExecDate()) >= 0
                    && minTotalVolume <= order.getTotalVolume() && maxTotalVolume >= order.getTotalVolume() 
                    && minTotalCost <= order.getTotalCost() && maxTotalCost >= order.getTotalCost())
                modifiedList.add(order); 
        }
        list.clear();
        list.addAll(modifiedList);
        modifiedList.clear();
        System.out.println(list.size());
        
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
