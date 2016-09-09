/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatServidor;

import java.util.ArrayList;

/**
 *
 * @author Enrique y Lorena
 */
public class user{
    String nick;
    int image;
    int location;
    ArrayList<String> mensajes;
    
    public user(String nick, int image, int location) {
        this.nick = nick;
        this.image = image;
        this.mensajes = new ArrayList();
        this.location = location;
    }
    public String getMensaje() {
        String mensaje = "";
        if (mensajes != null){
            if(mensajes.size() > 0){
                mensaje = mensajes.get(0);
                mensajes.remove(0);
            }
        }
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        mensajes.add(mensaje);
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
    public int getImage() {
        return image;
    }
}
