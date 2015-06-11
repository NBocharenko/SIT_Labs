/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.order;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class DeleteOrderCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        OrderrJpaController dbconn = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());        
        String id = request.getParameter("id");
        if(id.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод номера");
            return "/jsp/error.jsp";
        } 
        Long n = new Long(id);
        try {
            dbconn.destroy(n);
        } catch (NonexistentEntityException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
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
