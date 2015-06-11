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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class SearchMaterialCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        String title = request.getParameter("title");
        String specification = request.getParameter("specification");
        String measure = request.getParameter("measure");
        Integer minUnitStorageCost = new Integer(request.getParameter("minUnitStorageCost"));
        Integer maxUnitStorageCost = new Integer(request.getParameter("maxUnitStorageCost"));
        Float minWeight = new Float(request.getParameter("minWeight"));
        Float maxWeight = new Float(request.getParameter("maxWeight"));
        Float minVolume = new Float(request.getParameter("minVolume"));
        Float maxVolume = new Float(request.getParameter("maxVolume"));
        MaterialJpaController dbconn = new MaterialJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Material> list = dbconn.findMaterialEntities();
        List<Material> modifiedList = new ArrayList();
        System.out.println(list.size());
        if(!title.equals("")){
            for(Material material : list){
                if(material.getTitle().equals(title))
                    modifiedList.add(material);  
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        System.out.println(list.size());
        if(!specification.equals("")){
            for(Material material : list){
                if(material.getSpecification().equals(specification))
                    modifiedList.add(material);
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        System.out.println(list.size());
        if(!measure.equals("")){
            for(Material material : list){
                if(material.getMeasure().equals(measure))
                    modifiedList.add(material);
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        System.out.println(list.size());
        for(Material material : list){
            if(material.getWeight() >= minWeight && material.getWeight() <= maxWeight
                    && material.getVolume() >= minVolume && material.getVolume() <= maxVolume
                    && material.getUnitStorageCost() >= minUnitStorageCost && material.getUnitStorageCost() <= maxUnitStorageCost)
                modifiedList.add(material);
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
        return "/jsp/material/ReadMaterial.jsp";
    }
}
