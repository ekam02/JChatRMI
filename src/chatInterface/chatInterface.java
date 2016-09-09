/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatInterface;

import java.rmi.*;
//import java.rmi.RemoteException;

/**
 *
 * @author Enrique y Lorena
 */
public interface chatInterface extends Remote {
    
    public boolean starSession(String nick, int image, int location) throws RemoteException;
    public String closeSession(String nick) throws RemoteException;
    public String emission(String message) throws RemoteException;
    public String reception(String nick) throws RemoteException;
    public String showOnline() throws RemoteException;
    public int randomLocation() throws RemoteException;
    public int locationShowOnline() throws RemoteException;
    public boolean join() throws RemoteException;
    
}
