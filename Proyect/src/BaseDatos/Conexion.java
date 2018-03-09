/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;

<<<<<<< HEAD
public  class Conexion {

            Connection con = null;

public static   Connection conexion() {

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/","sql10218899","dqlkLPTbHd");
return conn;
}
catch(Exception e)
{

return null;
=======
public class Conexion {
    
            Connection conexion = null;
    public  Connection conexion() {

        try {
            conexion = null;
            Class.forName("com.mysql.jdbc.Driver");
             conexion = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/", "sql10218899", "dqlkLPTbHd");
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion");
            System.out.println("error de conexion " + e);
        }
        return conexion;
    }
>>>>>>> 6cb49a26eedec2b367badc7a9ed4900bebf141b7
}
}
}



