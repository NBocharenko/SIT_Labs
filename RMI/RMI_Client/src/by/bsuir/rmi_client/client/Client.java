package by.bsuir.rmi_client.client;

import by.bsuir.rmi_server.exchangeObject.exchangeObject;
import by.bsuir.rmi_server.remoteInterface.Hello;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {

    private Client() {}
    
    public exchangeObject createRecord(Scanner sc) {
        exchangeObject record = new exchangeObject();
        System.out.println("Enter date, track, greetings");
        record.setDate(sc.nextLine());
        record.setSong(sc.nextLine());
        record.setCongrat(sc.nextLine());
        return record;
    }
    
    public void printAllRecords(List<exchangeObject> allRecords) {
        if(allRecords==null)
            System.out.println("There is no records on this date");
        else
            for(int i=0;i<allRecords.size();i++){
                System.out.print(allRecords.get(i).getDate()+" "+allRecords.get(i).getSong()+" "+
                        allRecords.get(i).getCongrat());
                System.out.println();}
    }
    
    public static void main(String[] args) {
        Client client = new Client();
        try {
            int x=0;
            Scanner sc = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry(null, 12345);
            Hello stub = (Hello) registry.lookup("Hello");
            do{
                System.out.println("1.Enter record");
                System.out.println("2.Get records on date");
                System.out.println("3.Exit");
                x=sc.nextInt();
                sc.nextLine();
                switch(x){
                    case 1: {
                        String response = stub.addRecord(client.createRecord(sc));
                        System.out.println("Response: " + response);
                    }break;
                    case 2: {
                        System.out.println("Enter date");
                        String date=sc.nextLine();
                        client.printAllRecords(stub.getAllRecords(date));
                    }break;
                    case 3:System.out.println("Adios"); break;
                    default:System.out.println("Enter valid value:");
                }
            }while(x!=3);
            
            
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
