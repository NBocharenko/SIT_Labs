/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.supplier;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.entity.Supplier;
import by.bsuir.bocharenko.rms.entity.suppliersort.*;
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
public class SortSupplierCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        SupplierJpaController dbconnSupplier = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Supplier> list = dbconnSupplier.findSupplierEntities();
        String type = request.getParameter("sort");
        if(type != null){
            if(type.equalsIgnoreCase("title"))
                Collections.sort(list,new SortSupplierByTitle());
            if(type.equalsIgnoreCase("titleMat"))
                Collections.sort(list,new SortSupplierByMaterialTitle());
            if(type.equalsIgnoreCase("resourceUnitPrice"))
                Collections.sort(list,new SortSupplierByCost());
            if(type.equalsIgnoreCase("deliveryPrice"))
                Collections.sort(list,new SortSupplierByDeliveryPrice());
        }
        request.setAttribute("List", list);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        return "/jsp/supplier/ReadSupplier.jsp";
    }
}
