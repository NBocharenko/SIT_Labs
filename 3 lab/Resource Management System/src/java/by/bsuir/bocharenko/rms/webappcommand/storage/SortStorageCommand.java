/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.storage;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.StorageJpaController;
import by.bsuir.bocharenko.rms.entity.Storage;
import by.bsuir.bocharenko.rms.entity.storagesort.*;
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
public class SortStorageCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        StorageJpaController dbconnSupplier = new StorageJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Storage> list = dbconnSupplier.findStorageEntities();
        String type = request.getParameter("sort");
        if(type != null){
            if(type.equalsIgnoreCase("titleMat"))
                Collections.sort(list,new SortStorageByMaterialTitle());
            if(type.equalsIgnoreCase("receiptDate"))
                Collections.sort(list,new SortStorageByReceiptDate());
            if(type.equalsIgnoreCase("numberOfMaterialUnits"))
                Collections.sort(list,new SortStorageByUnitNumbers());
            if(type.equalsIgnoreCase("totalVolumeOfMaterial"))
                Collections.sort(list,new SortStorageByUnitVolume());
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
