/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.supplier;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.entity.Material;
import by.bsuir.bocharenko.rms.entity.Supplier;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class UpdateSupplierCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        String n_sup = request.getParameter("id_sup");
        if(n_sup.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод номера поставщика");
            return "/jsp/error.jsp";
        }  
        String p = request.getParameter("deliveryPrice");
        String up = request.getParameter("resourceUnitPrice");
        if(p.equals("") || up.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод формы");
            return "/jsp/error.jsp";
        }
        String n_mat = request.getParameter("id_mat");
        if(n_mat.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод номера материала");
            return "/jsp/error.jsp";
        }
        Long id_sup = new Long(n_sup);
        Long id_mat = new Long(n_mat);
        Integer deliveryPrice = new Integer(p);
        Integer resourceUnitPrice = new Integer(up);
        Supplier supplier = new Supplier();
        supplier.setId(id_sup);
        supplier.setTitle(request.getParameter("title"));
        supplier.setDeliveryPrice(deliveryPrice);
        supplier.setResourceUnitPrice(resourceUnitPrice);
        Material material = new Material();
        material.setId(id_mat);
        supplier.setMaterial(material);
        SupplierJpaController dbconn = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        try {
            dbconn.edit(supplier);
        } catch (Exception ex) {
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
