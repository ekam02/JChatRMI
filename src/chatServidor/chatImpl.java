/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatServidor;

import chatInterface.chatInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Enrique y Lorena
 */
public class chatImpl extends UnicastRemoteObject implements chatInterface{
    private ArrayList<user> user;
    private ArrayList<Integer> emptyLocation, busyLocation;
    
    
    public chatImpl() throws RemoteException {
        super();
        user = new ArrayList();
        emptyLocation = new ArrayList();
        busyLocation = new ArrayList();
        for (int i = 0; i < 64; i++) {
            emptyLocation.add(i);
        }
    }
    public boolean starSession(String nick, int image, int location) {
        boolean result = true;
        int x = -1;
        //boolean encontrado = false;
        for(int i = 0; i<user.size(); i++) {
            if(user.get(i).getNick().equals(nick)) {
                x = i;
                result = false;
                break;
            }
        }
        if(result == true) {
            user.get(x).setMensaje("El usuario "+nick+" inició sesión");
            user.add(new user(nick, image, location));
            result = true;
        }
        return result;
    }
    public String closeSession(String nick){
        for (int i = 0; i < user.size(); i++) {
            if(user.get(i).getNick().equals(nick)) {
                user.remove(i);
                user.get(i).setMensaje("El usuario "+nick+" cerró la sesión.");
                break;
            }
        }
        return nick;
    }
    public String emission(String message) {
        for(int i = 0; i<user.size(); i++){
            user.get(i).setMensaje(message);
        }
        return message;
    }
    public String reception(String nick)  {
        String message = "";
        for(int i = 0; i<user.size(); i++){
            if(user.get(i).getNick().equals(nick)){
                message = user.get(i).getMensaje();
            }
        }
        return message;
    }
    public String showOnline() {
        String online = "";
        for(int i = 0; i<user.size(); i++){
            online = online+", " + user.get(i).getNick();
        }
        return online; 
    }
    public int randomLocation() {
        int aux = emptyLocation.get((int)(Math.random()*emptyLocation.size()+1));
        emptyLocation.remove(emptyLocation.indexOf(aux));
        busyLocation.add(aux);
        return aux;
    }
    public int locationShowOnline() {
        int location = 0;
        for(int i = 0; i<user.size(); i++){
            location = user.get(i).getLocation();
        }
        return location;
    }
    public boolean join(){
        return true;
    }
}