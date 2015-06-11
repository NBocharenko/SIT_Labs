/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.storage;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.StorageJpaController;
import by.bsuir.bocharenko.rms.entity.Storage;
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
public class SearchStorageCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        StorageJpaController dbconnSupplier = new StorageJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Storage> list = dbconnSupplier.findStorageEntities();
        List<Storage> modifiedList = new ArrayList();
        if(list.size()>0){
        String materialTitle = request.getParameter("materialTitle");
        String materialSpecification = request.getParameter("materialSpecification");
        Integer minNumberOfMaterialUnits = new Integer(request.getParameter("minNumberOfMaterialUnits"));
        Integer maxNumberOfMaterialUnits = new Integer(request.getParameter("maxNumberOfMaterialUnits"));
        Float minTotalVolumeOfMaterial = new Float(request.getParameter("minTotalVolumeOfMaterial"));
        Float maxTotalVolumeOfMaterial = new Float(request.getParameter("maxTotalVolumeOfMaterial"));
        Date minReceiptDate;
        Date maxReceiptDate;
        try {
            minReceiptDate = DateParser.parseChromeDate(request, "minReceiptDate");
            maxReceiptDate = DateParser.parseChromeDate(request, "maxReceiptDate");
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        System.out.println(list.size());
        if(!materialTitle.equals("")){
            for(Storage storage : list){
                if(storage.getMaterial().getTitle().equals(materialTitle))
                    modifiedList.add(storage);  
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        System.out.println(list.size());
        if(!materialSpecification.equals("")){
            for(Storage storage : list){
                if(storage.getMaterial().getSpecification().equals(materialSpecification))
                    modifiedList.add(storage);  
            }
            list.clear();
            list.addAll(modifiedList);
            modifiedList.clear();
        }
        for(Storage storage : list){
            if(storage.getNumberOfMaterialUnits() >= minNumberOfMaterialUnits && storage.getNumberOfMaterialUnits() <= maxNumberOfMaterialUnits
                    && storage.getTotalVolumeOfMaterial() >= minTotalVolumeOfMaterial && storage.getTotalVolumeOfMaterial() <= maxTotalVolumeOfMaterial
                    && storage.getReceiptDate().compareTo(minReceiptDate) >=0 && storage.getReceiptDate().compareTo(maxReceiptDate) <= 0)
            modifiedList.add(storage);    
        }
        list.clear();
        list.addAll(modifiedList);
        modifiedList.clear();
        }
        request.setAttribute("List", list);
        
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        return "/jsp/storage/ReadStorage.jsp";
    }
}
