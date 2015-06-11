/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.webappcommand.go_to;

import by.bsuir.bocharenko.rms.controller.EMFactory;
import by.bsuir.bocharenko.rms.controller.OrderrJpaController;
import by.bsuir.bocharenko.rms.controller.StorageJpaController;
import by.bsuir.bocharenko.rms.entity.Orderr;
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
public class GoToFinanceCommand implements ICommand{
    @Override
   public String execute (HttpServletRequest request, HttpServletResponse response){
        Date date;
        try {
           date = DateParser.parseStandartDate(request, "dateForvarded");
        } catch (ParseException ex) {
            request.setAttribute("errorMessage", "Неверный ввод даты");
            return "/jsp/error.jsp";
        }
        OrderrJpaController dbconnOrder = new OrderrJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Orderr> orders = dbconnOrder.findOrderrEntities();
        List<Orderr> finOrders = new ArrayList();
        StorageJpaController dbconnStorage = new StorageJpaController(EMFactory.getInstance().getEntityManagerFactory());
        List<Storage> storages = dbconnStorage.findStorageEntities();
        
        Float totalSum = (float)0;
        Integer deliveryCost = 0;
        Float storageCost = (float)0;
        
        for(Orderr order : orders){
            if(order.getIsCompleted().equals("завершен")){
                deliveryCost += order.getTotalCost();
                finOrders.add(order);
            }
        }
        for(Storage storage : storages){
            long difference = (date.getTime() - storage.getReceiptDate().getTime())/ (24 * 60 * 60 * 1000);
            System.out.println(difference);
            storageCost += storage.getNumberOfMaterialUnits() * storage.getMaterial().getUnitStorageCost()
                    * difference;
        }
        totalSum = (float)deliveryCost + storageCost;
        
        request.setAttribute("totalSum", totalSum);
        request.setAttribute("deliveryCost", deliveryCost);
        request.setAttribute("storageCost", storageCost);
        request.setAttribute("orders", finOrders);
        request.setAttribute("storages", storages);
        request.setAttribute("date", date);
        return "/jsp/Finance.jsp";
   } 
}
