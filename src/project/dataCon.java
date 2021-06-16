/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i_m_r
 */
public class dataCon {
    public static Connection datacon(){
        Connection con=null;
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=StockDB;username=sa;password=shailesh";
            try {
                con = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
           
        } catch (ClassNotFoundException ex) {
System.out.println(ex);        }
        return con;
    }

    PreparedStatement prepareStatement(String select__from_cust_info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
