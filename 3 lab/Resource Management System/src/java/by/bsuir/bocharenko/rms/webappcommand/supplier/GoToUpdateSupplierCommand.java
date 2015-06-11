/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.supplier;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.MaterialJpaController;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.entity.Material;
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
public class GoToUpdateSupplierCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        SupplierJpaController dbconnSupplier = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Supplier> supplierList = dbconnSupplier.findSupplierEntities();
        request.setAttribute("supplierList", supplierList);
        MaterialJpaController dbconnMaterial = new MaterialJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Material> materialList = dbconnMaterial.findMaterialEntities();
        request.setAttribute("materialList", materialList);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        
        return "/jsp/supplier/UpdateSupplier.jsp";
    }
}
