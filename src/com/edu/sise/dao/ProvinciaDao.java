/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.dao;

import com.edu.sise.entidades.Provincia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ProvinciaDao {
    
    //atributos
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    
    public ProvinciaDao(){
        cn = new Conexion().getConn();
    }
    
    public List<Provincia> getAll(){
    
        List<Provincia> lista = new ArrayList<>();
        
        String sql = "select prov.*, depa.nombre 'Des_ID_Depa' \n" +
                     "from provincias prov inner join \n" +
                     "departamentos depa on (prov.id_depa = depa.id_depa)";
        
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                lista.add(new Provincia(
                        rs.getInt("id_prov"),
                        rs.getString("nombre"),
                        rs.getInt("id_depa"),
                        rs.getString("Des_ID_Depa")
                ));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        return lista;
    }
    
    
    //metodo para agregar un registro en base de datos
    public boolean agregarProvincia(Provincia o){
        
        int cantidad = 0;
        
        //crear nuestro script de agregar
        String sql="insert into provincias(nombre,id_depa) values('"+o.getNombre()+"',"+o.getId_depa()+")";
        
        try{
        st = cn.createStatement();
        cantidad = st.executeUpdate(sql);
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
    
    //metodo para modificar un registro en base de datos
    public boolean modificarProvincia(Provincia o){
        
        int cantidad = 0;
        
        //crear nuestro script de modificar
        String sql="update provincias set nombre = '"+o.getNombre()+"',id_depa="+o.getId_depa()+" where id_prov = " + o.getId_prov();
        
        try{
        st = cn.createStatement();
        cantidad = st.executeUpdate(sql);
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
    
     //metodo para eliminar un registro en base de datos
    public boolean eliminarProvincia(Integer id){
        
        int cantidad = 0;
        
        //crear nuestro script de eliminar 
        String sql="delete from provincias where id_prov = "+id;
        
        try{
        st = cn.createStatement();
        cantidad = st.executeUpdate(sql);
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
}
