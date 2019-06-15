package com.company;
import ConexionBD.*;
import UsuarioRegistrado.*;
public class Main {
    public static void main(String[] args) {
        ConexionBD conect=new ConexionBD();
        int userChoice;
        String logueado=null;
        while(logueado==null){
            userChoice = Menus.menuLogin();
            if(userChoice==3)
                break;
            logueado=Menus.opcionesLogin(conect,userChoice);
        }
        if(logueado!=null){
            UsuarioRegistrado usuarioregistrado = new UsuarioRegistrado(logueado);
            UsuarioLogueado usuariologeado = new UsuarioLogueado(usuarioregistrado);
            System.out.println("\nYa estás logueado.\n");
            Menus menu = new Menus(usuariologeado);
            menu.menuPrincipal();
        }
    }
}
