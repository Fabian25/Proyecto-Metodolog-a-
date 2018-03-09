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

public class Conexion {

    Connection con = null;

    public static Connection conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/", "sql10218899", "dqlkLPTbHd");
            return conn;
        } catch (Exception e) {

            return null;

        }
    }
}
