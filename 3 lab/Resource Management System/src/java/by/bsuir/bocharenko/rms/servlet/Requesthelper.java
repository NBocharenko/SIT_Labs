package by.bsuir.bocharenko.rms.servlet;


import by.bsuir.bocharenko.rms.webappcommand.material.SearchMaterialCommand;
import java.util.HashMap;
import by.bsuir.bocharenko.rms.webappcommand.*;
import by.bsuir.bocharenko.rms.webappcommand.date.*;
import by.bsuir.bocharenko.rms.webappcommand.dbconnection.CreateConnectionCommand;
import by.bsuir.bocharenko.rms.webappcommand.go_to.*;
import by.bsuir.bocharenko.rms.webappcommand.order.*;
import by.bsuir.bocharenko.rms.webappcommand.supplier.*;
import by.bsuir.bocharenko.rms.webappcommand.material.*;
import by.bsuir.bocharenko.rms.webappcommand.storage.*;
import javax.servlet.http.HttpServletRequest;

public class Requesthelper {
    private static Requesthelper rh;
    HashMap<String,ICommand> hm=new HashMap<>();

    private Requesthelper(){
        hm.put("GoToCreateMaterial", new GoToCreateMaterialCommand());
        hm.put("CreateMaterial",new CreateMaterialCommand());
        hm.put("ReadMaterial", new ReadMaterialCommand());
        hm.put("GoToUpdateMaterial", new GoToUpdateMaterialCommand());
        hm.put("UpdateMaterial", new UpdateMaterialCommand());
        hm.put("GoToDeleteMaterial", new GoToDeleteMaterialCommand());
        hm.put("DeleteMaterial", new DeleteMaterialCommand());
        hm.put("GoToCreateSupplier", new GoToCreateSupplierCommand());
        hm.put("CreateSupplier",new CreateSupplierCommand());
        hm.put("ReadSupplier", new ReadSupplierCommand());
        hm.put("GoToUpdateSupplier", new GoToUpdateSupplierCommand());
        hm.put("UpdateSupplier", new UpdateSupplierCommand());
        hm.put("GoToDeleteSupplier", new GoToDeleteSupplierCommand());
        hm.put("DeleteSupplier", new DeleteSupplierCommand());
        hm.put("GoToCreateOrder", new GoToCreateOrderCommand());
        hm.put("CreateOrder",new CreateOrderCommand());
        hm.put("ReadOrder", new ReadOrderCommand());
        hm.put("GoToUpdateOrder", new GoToUpdateOrderCommand());
        hm.put("UpdateOrder", new UpdateOrderCommand());
        hm.put("GoToDeleteOrder", new GoToDeleteOrderCommand());
        hm.put("DeleteOrder", new DeleteOrderCommand());
        hm.put("ReadStorage", new ReadStorageCommand());
        hm.put("ChangeDate", new ChangeDateCommand());
        hm.put("GoToMain", new GoToMainCommand());
        hm.put("GoToFinance", new GoToFinanceCommand());
        hm.put("GoToStatistics", new GoToStatisticsCommand());
        hm.put("GoToSearch", new GoToSearchCommand());
        hm.put("GoToSort", new GoToSortCommand());
        hm.put("SearchMaterial", new SearchMaterialCommand());
        hm.put("SearchSupplier", new SearchSupplierCommand());
        hm.put("SearchOrder", new SearchOrderCommand());
        hm.put("SearchStorage", new SearchStorageCommand());
        hm.put("SortMaterial", new SortMaterialCommand());
        hm.put("SortOrder", new SortOrderCommand());
        hm.put("SortSupplier", new SortSupplierCommand());
        hm.put("SortStorage", new SortStorageCommand());
        hm.put("CreateConnection", new CreateConnectionCommand());
        hm.put("NoCommand", new NoCommand());
    }
    
    public static Requesthelper getInstance(){
        if(rh==null)
            rh=new Requesthelper();
        return rh;
    }
    
    public ICommand getCommand (HttpServletRequest request){
        String action=request.getParameter("command");
        ICommand command=hm.get(action);
        if(command==null)
            command=new NoCommand();
        return command;
    }
}
