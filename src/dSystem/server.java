package dSystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;  
/**
 * 
 */

public class server extends UnicastRemoteObject implements adder {
    private final String url = "jdbc:postgresql://localhost:5432/retail";
    private final String user = "postgres";
    private final String password = "password";
    public Connection connect() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public server() throws RemoteException{
        super();
    }
    @Override
    public int add(int n1, int n2) throws RemoteException{
        return n1 + n2;
    }
    public void main(String args[]) throws RemoteException, SQLException{
        try{
            
            String SQL = "SELECT * FROM \"Retail Sales\""; 
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn=connect();
                pstmt =conn.prepareStatement(SQL);           
                rs = pstmt.executeQuery();
            }
            catch(SQLException e){
                System.out.println("error");
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            for (int i=1; i<= columnsNumber; i++) {
                System.out.print(rsmd.getColumnName (i) + "\t");
            }
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getString( "year") + "\t"
                + rs.getString ( "month") + "\t"
                + rs.getString( "supplier") + "\t"
                + rs.getString( "item_code") + "\t"
                + rs.getString( "item_description") + "\t"
                + rs.getString ("item_type") + "\t"
                + rs.getString( "retail_sales") + "\t"
                + rs.getString( "retail_transfer") + "\t"
                + rs.getString( "warehouse_sales"));
            }
            Registry reg = LocateRegistry.createRegistry(4444); 
            reg.rebind("Add_service", new server()); 
            System.out.println("Server is ready...");
        }
        catch (RemoteException e) {
            System.out.println("Exception: "+e);
        }
    }
}
