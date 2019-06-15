//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SolicitudBaja.java
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


public class SolicitudBaja extends Solicitud {
	private String Password;
	private UsuarioRegistrado Rb;

	public SolicitudBaja(){
		super();
		this.Rb=new UsuarioRegistrado();
		this.Password="pass";
	}

	public SolicitudBaja(String Alias, String email,UsuarioRegistrado usuario,String pass){
		super(Alias,email,"SolicitudBaja");
		this.Rb=usuario;
		this.Password=pass;
	}

	public void introducirPass(String Pass) {
		this.Password=Pass;
	}
	
	public void asignarUsuarioRegistrado(UsuarioRegistrado cUsuarioRegistrado) {
		this.Rb=cUsuarioRegistrado;
	}
	
	public UsuarioRegistrado obtenerUsuarioRegistrado() {
		return this.Rb;
	}

	public void mandarSolicitud(SolicitudBaja sol) {
		try(FileWriter fw = new FileWriter("solicitudBaja.txt", true);
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