/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.supplier;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.entity.Supplier;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class SearchSupplierCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        String title = request.getParameter("title");
        String materialTitle = request.getParameter("materialTitle");
        Integer minDeliveryPrice = new Integer(request.getParameter("minDeliveryPrice"));
        Integer maxDeliveryPrice = new Integer(request.getParameter("maxDeliveryPrice"));
        Integer minResourceUnitPrice = new Integer(request.getParameter("minResourceUnitPrice"));
        Integer maxResourceUnitPrice = new Integer(request.getParameter("maxResourceUnitPrice"));
        SupplierJpaController dbconnSupplier = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Supplier> list = dbconnSupplier.findSupplierEntities();
        List<Supplier> modifiedList = new ArrayList();
        System.out.println(list.size());
        if(!title.equals("")){
            for(Supplier supplier : list){
                if(supplier.getTitle().equals(title))
                    modifiedList.add(supplier);  
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        if(!materialTitle.equals("")){
            for(Supplier supplier : list){
                if(supplier.getMaterial().getTitle().equals(materialTitle))
                    modifiedList.add(supplier);  
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        System.out.println(list.size());
        for(Supplier supplier : list){
            if(supplier.getDeliveryPrice() >= minDeliveryPrice && supplier.getDeliveryPrice() <= maxDeliveryPrice
                    && supplier.getResourceUnitPrice() >= minResourceUnitPrice && supplier.getResourceUnitPrice() <= maxResourceUnitPrice)
            modifiedList.add(supplier);
        }
        list.clear();
        list.addAll(modifiedList);
        modifiedList.clear();
        System.out.println(list.size());
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        
        request.setAttribute("List", list);
        return "/jsp/supplier/ReadSupplier.jsp";
    }
}
