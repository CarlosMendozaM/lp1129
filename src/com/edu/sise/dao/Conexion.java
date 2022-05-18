/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Lenovo
 */
public class Conexion {
    
    //idenetificar nuestra url, user(login) y password
    //apuntan a la misma maquina existe dos formas:
    //local host o 127.0.0.1
    private static String url="jdbc:mysql://localhost:3306/lpjava1129";
    private static String user="root";
    private static String password="root";
    
    //declarar el Driver 
    private static String driver="com.mysql.cj.jdbc.Driver";
    
    //declarar el tipo Conetion
    Connection conn = null;
    
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en Driver: " + ex.getMessage());
        }
    }
    
    public Connection getConn(){
        
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error en DriverManager: " + ex.getMessage());
        }
        
        return conn;
    }
}
