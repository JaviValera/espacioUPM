//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Comentario.java
//  @ Date : 2019/5/23
//  @ Author : 
//
//
package Comentario;
import ConexionBD.ConexionBD;
import Publicacion.*;
import UsuarioRegistrado.*;


public class Comentario implements IComentario {
	private int CodComentario;
	private ConexionBD conexion=new ConexionBD();
	private String Alias;
	private long Fecha;
	private UsuarioLogueado Rb;
	private String texto;
	private Publicacion publi;

	public Comentario(){
		this.CodComentario=conexion.NumeroComentario()+1;
		this.Alias="usuario";
		this.texto=null;
		this.Fecha=System.currentTimeMillis();
        this.Rb=null;
		this.publi=null;
	}

	public Comentario( String texto,UsuarioLogueado usuario,Publicacion publicacion) {
		this.CodComentario=conexion.NumeroComentario()+1;
		this.texto=texto;
		this.publi=publicacion;
		this.Fecha=System.currentTimeMillis();
		this.Rb=usuario;
	}
	public int getCodComentario() {
		return CodComentario;
	}
	
	public void setCodComentario(int CodComentario) {
		this.CodComentario=CodComentario;
	}
	
	public void setAlias(String Alias) {
		this.Alias=Alias;
	}
	
	public String getAlias() {
		return Alias;
	}
	
	public long getFecha() {
		return Fecha;
	}
	
	public void setFecha(long Fecha) {
		this.Fecha=Fecha;
	}
	
	public void asignarUsuarioLogueado(UsuarioLogueado cUsuarioLogueado) {
		this.Rb=cUsuarioLogueado;
	}
	
	public UsuarioLogueado ObtenerUsuarioLogueado() {
		return Rb;
	}


}
