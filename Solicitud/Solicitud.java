//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Solicitud.java
//  @ Date : 2019/5/23
//  @ Author : 
//
//
package Solicitud;
import java.util.Random;


public class Solicitud implements ISolicitud {
	private String CodSolicitud;
	private String alias;
	private String email;
	private String tipo;
	public void mandarSolicitud(Solicitud sol) {

	}

	public Solicitud(){
		this.CodSolicitud="s00000";
		this.alias="user";
		this.email="user@upm.alumnos.es";
		this.tipo="Solicitud";

	}

	public Solicitud(String Alias, String email, String Tipo) {
	 this.CodSolicitud="s"+Math.floor(Math.random()*10000+1);
	 this.alias=Alias;
	 this.email=email;
	 this.tipo=Tipo;
	}
	
	public void setAlias(String Alias) {
		this.alias=Alias;
	}
	
	public String getAlias() {
		return this.alias;
	}
	
	public String getCodSolicitud() {
		return this.CodSolicitud;
	}
	
	public void setCodSolicitud(String CodSolicitud) {
		this.CodSolicitud=CodSolicitud;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setmail(String Email) {
		this.email=Email;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String Tipo) {
		this.tipo=Tipo;
	}
	
	public void introducirDatos(String CodSolicitud, String Alias, String Email) {
		setAlias(Alias);
		setCodSolicitud(CodSolicitud);
		setmail(Email);
	}
	
	public void Destroy() {
	
	}
}
