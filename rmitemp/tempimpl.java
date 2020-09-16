/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitemp;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Karan
 */
public class tempimpl extends UnicastRemoteObject implements tempinterface
{
    
    tempimpl() throws RemoteException 
    {
        super();
    }

    @Override
    public double cel_fh(double x) throws RemoteException {
        return ((x*9/5)+32);
    }

    @Override
    public double fh_cel(double x) throws RemoteException {
        return ((x-32)*5/9);
    }

    @Override
    public double cel_kel(double x) throws RemoteException {
        return (x+273.15);
    }

    @Override
    public double kel_cel(double x) throws RemoteException {
        return (x-273.15);
    }

    @Override
    public double kel_fh(double x) throws RemoteException {
        return ((x-32) * 5/9 + 273.15 );
    }

    @Override
    public double fh_kel(double x) throws RemoteException {
        return ((x-273.15) * 9/5 + 32 );
    }
 
}
