/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.material;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.MaterialJpaController;
import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.entity.Material;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class UpdateMaterialCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        String n = request.getParameter("id");
        if(n.equals("")){
            request.setAttribute("errorMessage","Неверный ввод номера материала");
            return "/jsp/error.jsp";
        }
        String w = request.getParameter("weight");
        String v = request.getParameter("volume");
        String u = request.getParameter("unitStorageCost");
        if(w.equals("") ||  v.equals("") || u.equals("")){
            request.setAttribute("errorMessage", "Неверный ввод формы");
            return "jsp/error.jsp";
        }
        Float weight = new Float(w);
        Float volume = new Float(v);
        Integer unitStorageCost = new Integer(u);
        Long id = new Long(n);
        Material material = new Material();
        material.setId(id);
        material.setTitle(request.getParameter("title"));
        material.setSpecification(request.getParameter("specification"));
        material.setMeasure(request.getParameter("measure"));
        material.setWeight(weight);
        material.setVolume(volume);
        material.setUnitStorageCost(unitStorageCost);
        MaterialJpaController dbconn = new MaterialJpaController(EMFactory.getInstance().getEntityManagerFactory());
        try {
            dbconn.edit(material);
        } catch (NonexistentEntityException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return "jsp/error.jsp";
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
