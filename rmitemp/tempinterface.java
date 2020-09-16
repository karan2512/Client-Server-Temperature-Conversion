/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitemp;
import java.rmi.*;
/**
 *
 * @author Karan
 */
public interface tempinterface extends Remote
{
    
    public double cel_fh(double x) throws RemoteException;
    public double fh_cel(double x) throws RemoteException;
    public double cel_kel(double x) throws RemoteException;
    public double kel_cel(double x) throws RemoteException;
    public double kel_fh(double x) throws RemoteException;
    public double fh_kel(double x) throws RemoteException;
    
}
