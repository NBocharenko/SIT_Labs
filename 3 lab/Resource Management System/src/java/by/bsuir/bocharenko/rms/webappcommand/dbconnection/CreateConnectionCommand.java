/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.dbconnection;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.controller.StorageJpaController;
import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.Storage;
import by.bsuir.bocharenko.rms.webappcommand.ICommand;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class CreateConnectionCommand implements ICommand{
    @Override
    public String execute (HttpServletRequest request, HttpServletResponse response){
        Date date = new Date();
        request.setAttribute("date", date);
        
        EMFactory.setPort(request.getParameter("port"));
        EMFactory.setUsername(request.getParameter("username"));
        EMFactory.setPassword(request.getParameter("password"));
        EMFactory.setDbname(request.getParameter("dbname"));
        
        OrderrJpaController dbconnOrder = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        StorageJpaController dbconnStorage = new StorageJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Orderr> list = dbconnOrder.findOrderrEntities();
        List<Storage> storages = dbconnStorage.findStorageEntities();
        for(Orderr order : list){
            if(order.getExecDate().compareTo(date) <= 0 && order.getIsCompleted().equals("не завершен")){
                    Storage storageMaterial = new Storage();
                    storageMaterial.setMaterial(order.getSupplier().getMaterial());
                    storageMaterial.setNumberOfMaterialUnits(order.getTotalVolume());
                    storageMaterial.setTotalVolumeOfMaterial
                    (storageMaterial.getMaterial().getVolume() * storageMaterial.getNumberOfMaterialUnits());
                    storageMaterial.setReceiptDate(order.getExecDate());
                    try {
                        dbconnStorage.create(storageMaterial);
                    } catch (NonexistentEntityException ex) {
                        request.setAttribute("errorMessage", ex.getMessage());
                        return "/jsp/error.jsp";
                    } 
                }
                order.setIsCompleted("завершен");
                try {
                    dbconnOrder.edit(order);
                } catch (Exception ex) {
                    request.setAttribute("errorMessage", ex.getMessage());
                    return "/jsp/error.jsp";
                }
            
            if(order.getExecDate().compareTo(date) > 0 && order.getIsCompleted().equals("завершен")){
                for(Storage storage : storages){
                    if(order.getSupplier().getMaterial().getTitle().equals(storage.getMaterial().getTitle()) 
                            && order.getSupplier().getMaterial().getSpecification().equals(storage.getMaterial().getSpecification())
                            && order.getExecDate().equals(storage.getReceiptDate()) && order.getTotalVolume().equals(storage.getNumberOfMaterialUnits())){
                            try {
                                dbconnStorage.destroy(storage.getId());
                            } catch (NonexistentEntityException ex) {
                                System.out.println("в удалении");
                                request.setAttribute("errorMessage", ex.getMessage());
                                return "/jsp/error.jsp";
                            }
                        }
                    }
                        
                order.setIsCompleted("не завершен");
                try {
                    dbconnOrder.edit(order);
                } catch (Exception ex) {
                    request.setAttribute("errorMessage", ex.getMessage());
                    return "/jsp/error.jsp";
                }
            }
        }
        
        return "/jsp/main.jsp";
    }
}
