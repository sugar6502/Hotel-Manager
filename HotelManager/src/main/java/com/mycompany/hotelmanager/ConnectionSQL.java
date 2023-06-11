/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author PC
 */
public class ConnectionSQL {
        private Connection con = null;
        private final String userName = "sa";
        private final String password = "sa";
       
        private final String url = "jdbc:sqlserver://localhost:1433;databaseName=Hotel_Manager;encrypt=true;trustServerCertificate=true;";
        private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public ConnectionSQL(){
     try{
        Class.forName(this.driver);
        this.con = DriverManager.getConnection(this.url,this.userName,this.password);
        }catch(ClassNotFoundException | SQLException e){

            System.out.println(e);
     
        }
    
    }
    
  
    public Connection getCon() {
        return con;
    }
    
        
       
}
