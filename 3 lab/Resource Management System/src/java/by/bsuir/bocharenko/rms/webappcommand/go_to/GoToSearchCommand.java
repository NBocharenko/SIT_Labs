/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.go_to;

import by.bsuir.bocharenko.rms.controller.*;
import by.bsuir.bocharenko.rms.entity.*;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import by.bsuir.bocharenko.rms.webappcommand.date.DateParser;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class GoToSearchCommand implements ICommand{
    @Override
   public String execute (HttpServletRequest request, HttpServletResponse response){
        try {
           request.setAttribute("date", DateParser.parseStandartDate(request, "dateForvarded"));
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        MaterialJpaController dbconnMaterial = new MaterialJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Material> materials = dbconnMaterial.findMaterialEntities();
        float minWeight = materials.get(0).getWeight();
        float maxWeight = 0;
        float minVolume = materials.get(0).getVolume();
        float maxVolume = 0;
        int minUnitStorageCost = materials.get(0).getUnitStorageCost();
        int maxUnitStorageCost = 0;
        for(Material material : materials){
            if(minWeight > material.getWeight())
                minWeight = material.getWeight();
            if(maxWeight < material.getWeight())
                maxWeight = material.getWeight();
            if(minVolume > material.getVolume())
                minVolume = material.getVolume();
            if(maxVolume < material.getVolume())
                maxVolume = material.getVolume();
            if(minUnitStorageCost > material.getUnitStorageCost())
                minUnitStorageCost = material.getUnitStorageCost();
            if(maxUnitStorageCost < material.getUnitStorageCost())
                maxUnitStorageCost = material.getUnitStorageCost();
        }
        request.setAttribute("minWeight", minWeight);
        request.setAttribute("maxWeight", maxWeight);
        request.setAttribute("minVolume", minVolume);
        request.setAttribute("maxVolume", maxVolume);
        request.setAttribute("minUnitStorageCost", minUnitStorageCost);
        request.setAttribute("maxUnitStorageCost", maxUnitStorageCost);
        
        SupplierJpaController dbconnSupplier = new SupplierJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Supplier> suppliers = dbconnSupplier.findSupplierEntities();
        Integer minDeliveryPrice = suppliers.get(0).getDeliveryPrice();
        Integer maxDeliveryPrice = 0;
        Integer minResourceUnitPrice = suppliers.get(0).getResourceUnitPrice();
        Integer maxResourceUnitPrice = 0;
        for(Supplier supplier : suppliers){
            if(minDeliveryPrice > supplier.getDeliveryPrice())
                minDeliveryPrice = supplier.getDeliveryPrice();
            if(maxDeliveryPrice < supplier.getDeliveryPrice())
                maxDeliveryPrice = supplier.getDeliveryPrice();
            if(minResourceUnitPrice > supplier.getResourceUnitPrice())
                minResourceUnitPrice = supplier.getResourceUnitPrice();
            if(maxResourceUnitPrice < supplier.getResourceUnitPrice())
                maxResourceUnitPrice = supplier.getResourceUnitPrice();
        }
        request.setAttribute("minDeliveryPrice", minDeliveryPrice);
        request.setAttribute("maxDeliveryPrice", maxDeliveryPrice);
        request.setAttribute("minResourceUnitPrice", minResourceUnitPrice);
        request.setAttribute("maxResourceUnitPrice", maxResourceUnitPrice);
        
        OrderrJpaController dbconn = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Orderr> orders = dbconn.findOrderrEntities();
        Date minSignDate = orders.get(0).getSignDate();
        Date maxSignDate = orders.get(0).getSignDate();
        Date minExecDate = orders.get(0).getExecDate();
        Date maxExecDate = orders.get(0).getExecDate();
        Integer minTotalVolume = orders.get(0).getTotalVolume();
        Integer maxTotalVolume = 0;
        Integer minTotalCost = orders.get(0).getTotalCost();
        Integer maxTotalCost = 0;
        for(Orderr order : orders){
            if(minSignDate.compareTo(order.getSignDate()) > 0)
                minSignDate = order.getSignDate();
            if(maxSignDate.compareTo(order.getSignDate()) < 0)
                maxSignDate = order.getSignDate();
            if(minExecDate.compareTo(order.getExecDate()) > 0)
                minExecDate = order.getExecDate();
            if(maxExecDate.compareTo(order.getExecDate()) < 0)
                maxExecDate = order.getExecDate();
            if(minTotalVolume > order.getTotalVolume())
                minTotalVolume = order.getTotalVolume();
            if(maxTotalVolume < order.getTotalVolume())
                maxTotalVolume = order.getTotalVolume();
            if(minTotalCost > order.getTotalCost())
                minTotalCost = order.getTotalCost();
            if(maxTotalCost < order.getTotalCost())
                maxTotalCost = order.getTotalCost();
        }
        request.setAttribute("minSignDate", minSignDate);
        request.setAttribute("maxSignDate", maxSignDate);
        request.setAttribute("minExecDate", minExecDate);
        request.setAttribute("maxExecDate", maxExecDate);
        request.setAttribute("minTotalVolume", minTotalVolume);
        request.setAttribute("maxTotalVolume", maxTotalVolume);
        request.setAttribute("minTotalCost", minTotalCost);
        request.setAttribute("maxTotalCost", maxTotalCost);
        
        StorageJpaController dbconnStorage = new StorageJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Storage> storages = dbconnStorage.findStorageEntities();
        if(storages.size()>0){
            Integer minNumberOfMaterialUnits = storages.get(0).getNumberOfMaterialUnits();
            Integer maxNumberOfMaterialUnits = 0;
            Float minTotalVolumeOfMaterial = storages.get(0).getTotalVolumeOfMaterial();
            Float maxTotalVolumeOfMaterial = (float) 0;
            Date minReceiptDate = storages.get(0).getReceiptDate();
            Date maxReceiptDate = new Date();
            for(Storage storage : storages){
                if(minNumberOfMaterialUnits > storage.getNumberOfMaterialUnits())
                    minNumberOfMaterialUnits = storage.getNumberOfMaterialUnits();
                if(maxNumberOfMaterialUnits < storage.getNumberOfMaterialUnits())
                    maxNumberOfMaterialUnits = storage.getNumberOfMaterialUnits();
                if(minTotalVolumeOfMaterial > storage.getTotalVolumeOfMaterial())
                    minTotalVolumeOfMaterial = storage.getTotalVolumeOfMaterial();
                if(maxTotalVolumeOfMaterial < storage.getTotalVolumeOfMaterial())
                    maxTotalVolumeOfMaterial = storage.getTotalVolumeOfMaterial();
                if(minReceiptDate.compareTo(storage.getReceiptDate()) > 0)
                    minReceiptDate = storage.getReceiptDate();
                if(maxReceiptDate.compareTo(storage.getReceiptDate()) < 0)
                    maxReceiptDate = storage.getReceiptDate();
            }
            request.setAttribute("minNumberOfMaterialUnits", minNumberOfMaterialUnits);
            request.setAttribute("maxNumberOfMaterialUnits", maxNumberOfMaterialUnits);
            request.setAttribute("minTotalVolumeOfMaterial", minTotalVolumeOfMaterial);
            request.setAttribute("maxTotalVolumeOfMaterial", maxTotalVolumeOfMaterial);
            request.setAttribute("minReceiptDate", minReceiptDate);
            request.setAttribute("maxReceiptDate", maxReceiptDate);
        }
        return "/jsp/Search.jsp";
   } 
}
