//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SolicitudRecuPass.java
//  @ Date : 2019/5/23
//  @ Author : 
//
//
package Solicitud;
import UsuarioRegistrado.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class SolicitudRecuPass extends Solicitud {
	private UsuarioRegistrado Ra;

	public SolicitudRecuPass(){
		super();
		this.Ra=new UsuarioRegistrado();
	}

	public SolicitudRecuPass(String Alias, String email,UsuarioRegistrado usuario){
		super(Alias,email,"SolicitudRecuPass");
		this.Ra=usuario;
	}

	public void asignarUsuarioRegistrado(UsuarioRegistrado cUsuarioRegistrado) {
		this.Ra=cUsuarioRegistrado;
	}
	
	public UsuarioRegistrado obtenerUsuarioRegistrado() {
		return this.Ra;
	}

	public void mandarSolicitud(SolicitudRecuPass sol) {
		try(FileWriter fw = new FileWriter("solicitudRecuPass.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			out.println(sol.getCodSolicitud()+" | "+sol.getAlias()+" | "+sol.getEmail()+" | ");

		} catch (IOException e) {
			System.out.println("Error al enviar la solicitud.");
		}

	}

	public void eliminar() {
	
	}
	

}
