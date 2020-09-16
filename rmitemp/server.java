/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitemp;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Karan
 */
public class server {
    public server() throws RemoteException  
    {  
        
    }
    
    public static void main(String args[]) throws RemoteException{
        
        try
        {
            Registry reg = LocateRegistry.createRegistry(9999);  
            tempimpl s = new tempimpl();  
            reg.rebind("Server",s);  
            System.out.println("Server is ready!"); 
            
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
        
    }
}
