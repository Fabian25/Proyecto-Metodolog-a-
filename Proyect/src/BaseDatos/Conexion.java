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

    private static Connection connect = null;
   
 
    private static void conexion(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
             connect = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10218899", "sql10218899", "dqlkLPTbHd");
              
            
        } catch (ClassNotFoundException | SQLException e) {
             System.out.println("MysqlDataSource err: " + e.getMessage());
            e.printStackTrace();

        }
       
    }
     public static Connection getConnection() {
        if (connect == null) {
        
            conexion();
        }
        
        return connect;
    }
}
