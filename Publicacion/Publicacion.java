	 	package  Publicacion;
	 	import  ConexionBD.*;
	 	import  UsuarioRegistrado.*;
	 	import  Comentario.*;
	 	import  java.util.ArrayList;
	 	
	 	public  class  Publicacion  implements  IPublicacion  {
	 	          private  ConexionBD  conexion=new  ConexionBD();
	 	          private  Integer  CodPublicacion;
	 	          private  String  UsuarioReferenciado;
	 	          private  long  Fecha;
	 	          private  Integer  NumLikes;
	 	          private  Integer  NumDislikes;
	 	          private  Integer  Popularidad;
	 	          private  String  Tipo;
	 	          private  UsuarioRegistrado  Rb;
	 	          private  String  Texto;
	 	
	 	          public  Publicacion(){
	 	                    this.CodPublicacion=conexion.NumeroPublicacion()+1;
	 	                    this.UsuarioReferenciado=null;
	 	                    this.Fecha=System.currentTimeMillis();
	 	                    this.NumLikes=0;
	 	                    this.NumDislikes=0;
	 	                    this.Popularidad=NumLikes-NumDislikes;
	 	                    this.Tipo="Texto";
	 	                    Rb=null;
	 	                    this.Texto="";
	 	          }
	 	
	 	          public  Publicacion(String  Tipo,  String  Texto,  UsuarioRegistrado  Usuario)  {
	 	                    this.CodPublicacion=conexion.NumeroPublicacion()+1;
	 	                    this.UsuarioReferenciado=null;
	 	                    this.Fecha=System.currentTimeMillis();
	 	                    this.NumLikes=0;
	 	                    this.NumDislikes=0;
	 	                    this.Popularidad=NumLikes-NumDislikes;
	 	                    this.Tipo=Tipo;
	 	                    Rb=Usuario;
	 	                    this.Texto=Texto;
	 	          }
	 	
	 	          public  void  like(Integer  CodPublicacion)  {
	 	                    conexion.LikePublicaciones(CodPublicacion);
	 	                    this.NumLikes++;
	 	          }
	 	         
	 	          public  void  dislike(Integer  CodPublicacion)  {
	 	                    conexion.DislikePublicaciones(CodPublicacion);
	 	                    this.NumDislikes++;
	 	          }
	 	
	 	          public  void  borrarPublicacion(Integer  CodPublicacion)  {
	 	                    conexion.EliminarPublicaciones(CodPublicacion);
	 	          }
	 	
	 	          public  void  verPublicacion(Integer  CodPublicacion)  {
	 	         
	 	          }
	 	         
	 	          public  void  repostear(Integer  CodPublicacion,  String  Alias)  {
	 	
	 	          }
	 	         
	 	          public  void  ordenarComentario()  {
	 	         
	 	          }
	 	
	 	          public  void  publicar(Integer  CodPublicacion)  {
	 	         
	 	          }
	 	         
	 	          public  void  setCodPublicacion(Integer  CodPublicacion)  {
	 	                    this.CodPublicacion=CodPublicacion;
	 	          }
	 	
	 	
	 	          public  Integer  getCodPublicacion()  {
	 	          return  this.CodPublicacion;
	 	          }
	 	         
	 	          public  String  getAlias()  {
	 	          return  this.Rb.getAlias();
	 	          }
	 	          public  String  getTexto()  {
	 	                    return  this.Texto;
	 	          }
	 	          public  void  setAlias(String  Alias)  {
	 	          this.Rb.setAlias(Alias);
	 	          }
 	         
	 	          public  String  getUsuarioReferenciado()  {
	 	          return  this.UsuarioReferenciado;
	 	          }
	 	         
	 	          public  void  setUsuarioReferenciado(String  UsuarioReferenciado)  {
	 	          this.UsuarioReferenciado=UsuarioReferenciado;
	 	          }
	 	         
	 	          public  Integer  getNumLikes()  {
	 	          return  this.NumLikes;
	 	          }
	 	         
 	          public  void  setNumLikes(Integer  NumLikes)  {
	 	          this.NumLikes=NumLikes;
	 	          }
	 	
	 	          public  Integer  getNumDislikes()  {
	 	          return  this.NumDislikes;
	 	          }
 	         
 	          public  void  setNumDislikes(Integer  NumDislikes)  {
                    this.NumDislikes=NumDislikes;
	          }
	 	
	 	          public  Integer  getPopularidad()  {
	 	                    return  this.Popularidad;
	 	          }
	 	         
	 	          public  void  setPopularidad(Integer  Popularidad)  {
	 	                    this.Popularidad=Popularidad;
	 	          }
	 	
	 	          public  String  getTipo()  {
	 	          return  this.Tipo;
	 	          }
	 	
	 	          public  void  setTipo(String  Tipo)  {
 	                    this.Tipo=Tipo;
	 	          }
	 	
	 	          public  void  setComentario(Comentario  Comentario)  {
	 	         
	 	          }
	 	          /*
	 	          public  Comentario  getComentario(Comentario  Comentario)  {
	 	
	 	          }
	 	          */
	 	          public  void  eliminar(Comentario  Comentario)  {
	 	         
 	          }
	 	
	 	}