/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatServidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author Ekam2
 */
public class chatServidor {
    public static void main(String args[]) {
	try {
            LocateRegistry.createRegistry(1099);//rmiregistry
            chatImpl chat = new chatImpl();
            Naming.rebind("host", chat);
            System.out.println("Servidor del Chat Iniciado!");
	}
        catch (Exception e) {
            System.out.println("Error");
        }
    }
}
