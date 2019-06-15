package com.company;
import ConexionBD.ConexionBD;
import UsuarioNoRegistrado.UsuarioNoRegistrado;
import UsuarioRegistrado.UsuarioRegistrado;

import java.awt.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import UsuarioRegistrado.*;
public class Menus {
    private UsuarioLogueado usuario;
    ConexionBD conexion = new ConexionBD();
    Menus(UsuarioLogueado cusuario){
        usuario=cusuario;
    }

    public static int menuLogin(){
        int selection;
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("***************************");
        System.out.println("* Bienvenido a espacioUPM *");
        System.out.println("***************************");
        System.out.println("* 1 - Login               *");
        System.out.println("* 2 - Registrar           *");
        System.out.println("* 3 - Salir               *");
        System.out.println("***************************");
        System.out.println("Escriba una opcion: \n");
        if(input.hasNextInt()) {
            selection = input.nextInt();
        }
        else
            selection=5;
        return selection;
    }
    public static String opcionesLogin(ConexionBD conect, Integer s){
        String logueado=null;
        String CodVisitante;
        CodVisitante="v"+Math.floor(Math.random()*10000+1);
        UsuarioNoRegistrado visitante=new UsuarioNoRegistrado(CodVisitante);
        UsuarioRegistrado registrado= new UsuarioRegistrado();
        switch (s){
            case 1:
                logueado=registrado.login();
                break;
            case 2:
                visitante.solicitarDatosAlta();
                break;
            default:
                System.out.println("Porfavor, elija alguna opción entre 1 y 2 \n");
        }

        return logueado;
    }
    public void menuPrincipal(){
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
            while (!salir) {

                /***************************************************/
                System.out.println("***************************");
                System.out.println("*       Bienvenido        *");
                System.out.println("***************************");
                System.out.println("* 1 - Ver Muro Propio     *");
                System.out.println("* 2 - Escribir Publicacion*");
                System.out.println("* 3 - Salir               *");
                System.out.println("***************************");
                System.out.println("Escriba una opcion: \n");
                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Has seleccionado ver tu muro");
                            menuMostrarPublicaciones();
                            break;
                        case 2:
                            System.out.println("Has seleccionado escribir publicacion");
                            menuCrearPublicacion();
                            break;
                        case 3:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo numeros entre 1 y 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un numero");
                    sn.next();
                }
            }

        }
    public void menuCrearPublicacion(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            /***************************************************/
            System.out.println("***************************");
            System.out.println("*   Escribir Publicacion  *");
            System.out.println("***************************");
            System.out.println("* 1 - Tipo texto          *");
            System.out.println("* 2 - Tipo Enlace         *");
            System.out.println("* 3 - Salir               *");
            System.out.println("***************************");
            System.out.println("Escriba una opcion: \n");
            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado escribir una publicacion de tipo texto");
                        usuario.CrearPublicacion("texto");
                        break;
                    case 2:
                        System.out.println("Has seleccionado escribir una publicacion de tipo enlace");
                        usuario.CrearPublicacion("enlace");
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }
    }

    public void menuMostrarPublicaciones(){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {
            /***************************************************/
            System.out.println("****************************");
            System.out.println("* Listado de Publicaciones *");
            System.out.println("****************************");
            String publis[];
            publis=conexion.listarPublicaciones(usuario.getUsuario().getAlias());
            if(publis[0]==null)
                System.out.println("\n NO HAY PUBLICACIONES AUN \n");
            else{
            for(String publi : publis){
                if(publi!=null) {
                    System.out.println(publi);
                    System.out.println("************************************");
                }
            }
            }
            System.out.println("Escriba (0) Para salir.");
            System.out.println("Escriba el id de publicacion (puede buscar la de cualquier usuario) para ver una especifica: \n");
            try {
                opcion = sn.nextInt();
                if(!conexion.ExistePublicacion(opcion))
                    opcion=-1;
                switch (opcion) {
                    case 0:
                        System.out.println("Has seleccionado Salir");
                        salir=true;
                        break;
                    case -1:
                        System.out.println("Esta opcion no existe");
                        break;
                    default:
                        menuPubli(opcion);
                        salir=true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }
    }

    public void menuPubli(int id){
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {
            String texto=conexion.ObtenerPublicacion(id);
            System.out.println(texto);
            System.out.println("**********************************************************");
            System.out.println("*                        Opciones                        *");
            System.out.println("**********************************************************");
            System.out.println("* 0 - Comentar                                           *");
            System.out.println("* 1 - Dar like                                           *");
            System.out.println("* 2 - Dar dislike                                        *");
            System.out.println("* 3 - Borrar esta publicacion (solo se puede si es suya) *");
            System.out.println("* 4 - Salir                                              *");
            System.out.println("**********************************************************");
            System.out.println("Escriba una opcion: \n");
            try {
                opcion = sn.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Has seleccionado comentar");
                        usuario.crearComentario(id);
                        break;
                    case 1:
                        System.out.println("Has seleccionado dar like");
                        conexion.LikePublicaciones(id);
                        break;
                    case 2:
                        System.out.println("Has seleccionado dar dislike");
                        conexion.DislikePublicaciones(id);
                        break;
                    case 3:
                        System.out.println("Has seleccionado borrar publicacion");
                        if(conexion.PertenecePublicacionUsuario(usuario.getUsuario().getAlias(),id))
                        {conexion.EliminarPublicaciones(id);
                            System.out.println("\nBorrada correctamente\n");}
                        else
                        System.out.println("\nEsta publicacion no es tuya, por tanto no puedes eliminarla\n");
                        salir=true;
                        break;
                    case 4:
                        System.out.println("Has seleccionado salir");
                        salir=true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 0 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }

    }
}
