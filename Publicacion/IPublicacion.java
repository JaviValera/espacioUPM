package  Publicacion;
import  UsuarioRegistrado.*;
import  Comentario.*;
public  interface  IPublicacion {
public  void  like(Integer  CodPublicacion);
public  void  dislike(Integer  CodPublicacion);
public  void  verPublicacion(Integer  CodPublicacion);
public  void  repostear(Integer  CodPublicacion,  String  Alias);
public  void  ordenarComentario();
public  void  publicar(Integer  CodPublicacion);
}