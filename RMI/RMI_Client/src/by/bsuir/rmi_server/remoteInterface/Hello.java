package by.bsuir.rmi_server.remoteInterface;

import by.bsuir.rmi_server.exchangeObject.exchangeObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Hello extends Remote {
    String addRecord(exchangeObject record) throws RemoteException;
    List<exchangeObject> getAllRecords(String date) throws RemoteException;
}
