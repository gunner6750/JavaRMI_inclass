/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dSystem;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author ACER
 */
public interface adder extends Remote{
    public int add(int n, int n2) throws RemoteException;
}
