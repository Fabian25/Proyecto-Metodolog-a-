/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

<<<<<<< HEAD
            Connection con = null;
    public static Connection conexion() {
//
//        try {
//            conexion = null;
//            Class.forName("com.mysql.jdbc.Driver");
//             conexion = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/", "sql10218899", "dqlkLPTbHd");
//            System.out.println("conexion establecida");
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("error de conexion");
//            System.out.println("error de conexion " + e);
//        }
//        return conexion;
//    }
=======
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
>>>>>>> 74a894483c9e37f03b7e72b8322bcc796af3c6b1
    }
}

