/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.dao;

import com.edu.sise.entidades.Clientes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ClienteDao {
    
     Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    CallableStatement cs = null;
    
    public ClienteDao(){
        cn = new Conexion().getConn();
    }
    
    public List<Clientes> getAll(){
    
        List<Clientes> lista = new ArrayList<>();
        
        String sql = "{call pa_listar_clientes2()}";
        
        try {
            cs = cn.prepareCall(sql);
//            rs = st.executeQuery(sql)
            rs = cs.executeQuery();
            
            while(rs.next()){
                lista.add(new Clientes(
                        rs.getInt("id_cli"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getDate("fecha_nacimiento").toLocalDate()
                ));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        return lista;
    }
    
    
    //metodo para agregar un registro en base de datos
    public boolean agregarClientes(Clientes o){
        
        int cantidad = 0;
        
        //crear nuestro script de agregar
        String sql="{call pa_insertar_clientes2(?,?,?)}";
        
        try{
            cs = cn.prepareCall(sql);
            int x = 1;
            cs.setString(x++, o.getNombre());
            cs.setString(x++, o.getApellidos());
            cs.setDate(x++, Date.valueOf(o.getFecha_nacimiento()));
            cantidad = cs.executeUpdate();
        //st = cn.createStatement();
        //cantidad = st.executeUpdate(sql);
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
    
    //metodo para modificar un registro en base de datos
    public boolean modificarClientes(Clientes o){
        
        int cantidad = 0;
        
        //crear nuestro script de modificar
        String sql="{call pa_modificar_clientes2(?,?,?,?)}";
        
        try{
          cs = cn.prepareCall(sql);
          int x = 1;
          cs.setString(x++, o.getNombre());
          cs.setString(x++, o.getApellidos());
          cs.setDate(x++, Date.valueOf(o.getFecha_nacimiento()));
          cs.setInt(x++, o.getId_cli());
          cantidad = cs.executeUpdate();
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
    
     //metodo para eliminar un registro en base de datos
    public boolean eliminarClientes(Integer id){
        
        int cantidad = 0;
        
        //crear nuestro script de eliminar 
        String sql="{call pa_eliminar_clientes2(?)}";
        
        try{
        cs = cn.prepareCall(sql);
        cs.setInt(1, id);
        cantidad = cs.executeUpdate();
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
}
