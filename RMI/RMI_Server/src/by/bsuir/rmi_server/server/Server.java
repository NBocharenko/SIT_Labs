package by.bsuir.rmi_server.server;

import by.bsuir.rmi_server.exchangeObject.exchangeObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import by.bsuir.rmi_server.remoteInterface.Hello;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
        
public class Server implements Hello {
    public HashMap<String,List<exchangeObject>> allRecords;
    public Server() {
        allRecords = new HashMap<>();
    }

    @Override
    public String addRecord(exchangeObject record) {
        if(allRecords.containsKey(record.getDate()))
        {
            List<exchangeObject> temp=allRecords.get(record.getDate());
            temp.add(record);
            allRecords.put(record.getDate(), temp);
        }
        else
        {
            List<exchangeObject> temp=new ArrayList<>();
            temp.add(record);  
            allRecords.put(record.getDate(), temp);
        }   
        System.out.println("Record is added");
        return "Done!";
    }
    
    @Override
    public List<exchangeObject> getAllRecords(String date) {
        List<exchangeObject> temp=allRecords.get(date);
        System.out.println("Record are taken");
        return temp;
    }
        
    public static void main(String args[]) {
        Server obj = new Server();
        try {
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("Hello", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
