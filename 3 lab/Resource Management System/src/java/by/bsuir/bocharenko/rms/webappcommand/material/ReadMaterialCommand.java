/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.material;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.MaterialJpaController;
import by.bsuir.bocharenko.rms.entity.Material;
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
public class ReadMaterialCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        MaterialJpaController dbconn = new MaterialJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Material> list = dbconn.findMaterialEntities();
        request.setAttribute("List", list);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        return "/jsp/material/ReadMaterial.jsp";
    }
}
