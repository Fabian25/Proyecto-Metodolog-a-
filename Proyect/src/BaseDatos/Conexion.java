
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion{

    private static Connection connect = null;
   
    private static void conexion(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
             connect = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10218899", "sql10218899", "dqlkLPTbHd");
        } catch (ClassNotFoundException | SQLException e) {
             System.out.println("MysqlDataSource err: " + e.getMessage());

        }
       
    }
    
    public static Connection getConnection() {
        if (connect == null) {
            conexion();
        }
        return connect;
    }
     
    public static void closeConnection() throws SQLException {
        if (connect != null) {
           connect.close(); 
        }
        
    }
}
