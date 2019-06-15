
package ConexionBD;
import Comentario.Comentario;
import Publicacion.Publicacion;

import java.sql.*;

public class ConexionBD {
    Connection conexion;

    public ConexionBD(){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar Driver");
        }
        try {
            conexion = DriverManager.getConnection("jdbc:ucanaccess://BBDD//espacioUPM.accdb");
        } catch (SQLException e) {
            System.out.println("Error en la dirección de la base de datos");
        }
    }

    public Boolean YaExiste(String Alias){
        Boolean r=false;
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("SELECT a.Alias\n" +
                    "FROM Usuarios AS a\n" +
                    "WHERE EXISTS(SELECT * FROM Usuarios WHERE Alias='"+Alias+"')");
            ResultSet rs=sentencia.getResultSet();
            r=rs.next();

            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    public Boolean PertenecePublicacionUsuario(String Autor, Integer CodPublicacion ){
        Boolean r=false;
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("SELECT P.Autor\n" +
                    "FROM Publicaciones P \n" +
                    "WHERE P.ID='"+CodPublicacion+"' AND P.Autor='"+Autor+"'");
            ResultSet rs=sentencia.getResultSet();
            r=rs.next();
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return r;
    }


    public void Registrar(String Alias, String email, String Pass){
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("INSERT INTO Usuarios (Alias,email,Pass) " +
                    "VALUES ('"+Alias+"', '"+email+"', '"+Pass+"');");
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean Login(String Alias, String Pass){
        Boolean r=false;
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("SELECT a.Alias\n" +
                    "FROM Usuarios AS a\n" +
                    "WHERE EXISTS(SELECT * FROM Usuarios WHERE Alias='"+Alias+"' AND Pass='"+Pass+"')");
            ResultSet rs=sentencia.getResultSet();
            r=rs.next();

            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return r;
    }


    public boolean ExistePublicacion (Integer CodPublicacion){
        Boolean r=false;
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("SELECT ID\n" +
                    "FROM Publicaciones \n" +
                    "WHERE ID='"+CodPublicacion+"'");
            ResultSet rs=sentencia.getResultSet();
            r=rs.next();

            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    public void AddPublicaciones(Integer CodPubli,String Autor,Integer Origen,String Tipo, String Contenido){
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("INSERT INTO Publicaciones (ID,Autor,Origen,Tipo,Contenido) " +
                    "VALUES ('"+CodPubli+"', '"+Autor+"', '"+Origen+"', '"+Tipo+"', '"+Contenido+"');");
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void EliminarPublicaciones(Integer CodPubli){
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("DELETE FROM Publicaciones WHERE ID='"+CodPubli+"' ");
            //sentencia.execute("DELETE FROM Comentarios WHERE PUBLICACION='"+CodPubli+"'");
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String ObtenerPublicacion (Integer CodPubli){
        String texto="";
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("select * from Publicaciones where ID='"+CodPubli+"'");
            ResultSet rs=sentencia.getResultSet();
            while(rs.next()){
                texto += "******************************\nCod.Publicación: "+ rs.getString("ID")+ "\nComentario: " +
                        rs.getString("Contenido")+"\nPopularidad: "+rs.getString("Popularidad")+" ♥\nFecha: "+rs.getString("Fecha")+"\n******************************\nCOMENTARIOS\n--------------------------\n";
                Statement sentencia2=conexion.createStatement();
                sentencia2.execute("SELECT C.CodComen, C.Contenido, C.Autor, C.Fecha\n" +
                        "FROM Comentarios C \n" +
                        "WHERE C.Publicacion='"+CodPubli+"'" +
                        "ORDER BY C.Fecha DESC;");
                ResultSet rs2=sentencia2.getResultSet();
                while(rs2.next()){
                    texto += "Autor: @"+ rs2.getString("Autor")+"\n"+rs2.getString("Contenido")+"\nFecha: "
                            +rs2.getDate("Fecha")+"\n--------------------------\n";
                }
                sentencia2.close();
            }

            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return texto;
    }

    public void LikePublicaciones(Integer CodPubli){
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("UPDATE Publicaciones SET Popularidad= Popularidad+1 " +
                    "WHERE ID = '"+CodPubli+"';" );

            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void DislikePublicaciones(Integer CodPubli){
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("UPDATE Publicaciones SET Popularidad= Popularidad-1 " +
                    "WHERE ID = '"+CodPubli+"';" );

            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Integer NumeroPublicacion (){
        Integer id=-1;
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("SELECT MAX(ID) ID FROM Publicaciones");
            ResultSet rs=sentencia.getResultSet();
            while(rs.next()) {
                id = rs.getInt("ID");
            }
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public Integer NumeroComentario (){
        Integer id=-1;
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("select MAX(CodComen) ID from comentarios");
            ResultSet rs=sentencia.getResultSet();
            while(rs.next()) {
                id = rs.getInt("ID");
            }
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public String[] listarPublicaciones(String Usuario){
        String texto[]= new String[10];
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("select * from Publicaciones where Autor='"+Usuario+"' " + "order by 1 desc limit 10");
            ResultSet rs=sentencia.getResultSet();
            int i=0;
            while(rs.next()){
                if(rs.getInt("ID")!=0) {
                    texto[i] = "Autor: @" + rs.getString("Autor") + "  idPubli: " + rs.getString("ID")
                            + "\nContenido: " + rs.getString("Contenido") + "\nPopularidad: " + rs.getString("Popularidad") + " ♥ \nFecha: " + rs.getString("Fecha") + "\n";
                }
                i++;
            }
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return texto;
    }
    public String[] getInfo(String alias){
        String[] array = new String[3];
        try{
            Statement sentencia=conexion.createStatement();
            sentencia.execute("select Alias, email, Pass from Usuarios where Alias='"+alias+"';");
            ResultSet rs=sentencia.getResultSet();
            while(rs.next()){
                array[0]=rs.getString("Alias");
                array[1]=rs.getString("email");
                array[2]=rs.getString("Pass");
            }
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return array;
    }

    public void addComentario(Integer CodPublicacion, Integer CodComentario, String autor, String contenido){
        try{Statement sentencia=conexion.createStatement();
            sentencia.execute("INSERT INTO Comentarios(CodComen,Publicacion,Autor,Contenido) " +
                    "VALUES ('"+CodComentario+"','"+CodPublicacion+"','"+autor+"','"+contenido+"');");
                    sentencia.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
