//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : UsuarioRegistrado.java
//  @ Date : 2019/5/23
//  @ Author : 
//
//
package UsuarioRegistrado;

import ConexionBD.ConexionBD;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioRegistrado implements IUsuarioRegistrado {
	private ConexionBD conect=new ConexionBD();
	private String Alias;
	private String email;
	private String Password;
	private ArrayList<String> followers;
	private ArrayList<String> following;
	public UsuarioRegistrado(){

	}
	public UsuarioRegistrado(String Alias) {
		ConexionBD conect=new ConexionBD();
		String[] datos = new String[3];
		datos=conect.getInfo(Alias);
		this.Alias=datos[0];
		this.email=datos[1];
		this.Password=datos[2];
		//this.Rb=muro;
		//this.followers=followers;
		//this.following=following;
	}

	public String login() {
		Boolean logueado=false;
		String aliasf = null;
		Scanner input=new Scanner(System.in);
		System.out.println("Introduzca su alias:");
		String alias=input.nextLine();
		System.out.println("Introduzca su password:");
		String pass=input.nextLine();
		if(conect.YaExiste(alias)){
			logueado=conect.Login(alias,pass);
			if(!logueado) {
				aliasf = null;
				System.out.println("\nContraseña incorrecta\n");
			}else
			{	aliasf=alias;}}
		else{
			System.out.println("\nNo existe esta cuenta\n");
		}
		return aliasf;
	}

	public void solicitarDatosRecuPass(String email, String Alias) {

	}
	
	public void setAlias(String Alias) {
		this.Alias=Alias;
	}
	
	public String getAlias() {
		return Alias;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email=email;
	}

	public void SetPassword(String password) {
		this.Password = password;
	}

	public String GetPassword() {
		return this.Password;
	}
}
