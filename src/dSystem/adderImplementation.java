/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dSystem;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author ACER
 */
public class adderImplementation extends UnicastRemoteObject implements adder{
    public adderImplementation() throws RemoteException{
        
    }
    @Override
    public int add(int n1,int n2){
        return n1+n2;
    }
    
}
