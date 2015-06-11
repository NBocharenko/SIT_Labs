package by.bsuir.bocharenko.rms.webappcommand.supplier;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.SupplierJpaController;
import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.entity.Material;
import by.bsuir.bocharenko.rms.entity.Supplier;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateSupplierCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){      
        String title = request.getParameter("title");
        if(title.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод названия");
            return "/jsp/error.jsp";
        }  
        String p = request.getParameter("deliveryPrice");
        String up = request.getParameter("resourceUnitPrice");
        if(p.equals("") || up.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод формы");
            return "/jsp/error.jsp";
        }
        String n_mat = request.getParameter("materialId");
        if(n_mat.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод номера материала");
            return "/jsp/error.jsp";
        }
        Long id_mat = new Long(n_mat);
        Integer deliveryPrice = new Integer(p);
        Integer resourceUnitPrice = new Integer(up);
        Supplier supplier = new Supplier();
        supplier.setTitle(title);
        supplier.setDeliveryPrice(deliveryPrice);
        supplier.setResourceUnitPrice(resourceUnitPrice);
        Material material = new Material();
        material.setId(id_mat);
        supplier.setMaterial(material);
        SupplierJpaController dbconn = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        try {
            dbconn.create(supplier);
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
