/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dSystem;

/**
 *
 * @author ACER
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 */

public class server2 {
    public static void main(String args[]) throws RemoteException{
        adderImplementation adi=new adderImplementation();
        try{
            Registry reg = LocateRegistry.createRegistry(4444); 
            reg.rebind("Add_service", adi); 
            System.out.println("Server is ready...");
        }
        catch (RemoteException e) {
            System.out.println("Exception: "+e);
        }
    }
}
