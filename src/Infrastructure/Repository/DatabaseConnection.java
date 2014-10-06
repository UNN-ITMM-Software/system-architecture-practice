/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
     static Connection c = null;
     
     static public Connection getConnection(){
         if(c == null)
         {
             try {
                 Class.forName("org.sqlite.JDBC");
                 c = DriverManager.getConnection("jdbc:sqlite::memory:");
                 System.out.println("Opened database successfully");
                 
                 Statement stmt = null;
                 stmt = c.createStatement();
                 String sql = "CREATE TABLE FLIGHTS " +
                              "(ID_FLIGHTS CHAR(36) PRIMARY KEY NOT NULL," +
                              " AIRPLANE   CHAR(36)             NOT NULL, " + 
                              " A_FROM     CHAR(36)             NOT NULL, " + 
                              " A_TO       CHAR(36)             NOT NULL, " + 
                              " TIME_START  LONG                NOT NULL, " +
                              " TIME_FINISH LONG                NOT NULL)"; 
                 stmt.executeUpdate(sql);
                 stmt.close();
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return c;
     }
}
