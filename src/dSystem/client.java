/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dSystem;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
/**
 *
 * @author ACER
 */
public class client {
    public static void main(String args[]){
        client c = new client();
        c.connectRemote();
    }
    
    private void connectRemote(){
        try{
            Registry reg = LocateRegistry.getRegistry("localhost",4444);
            adder ad = (adder) reg.lookup("Add_service");
            System.out.print("Addition is: "+ad.add(87,92));
        }
        catch(NotBoundException|RemoteException e){
            System.out.println("Exception: "+e);
        }
    }
}
