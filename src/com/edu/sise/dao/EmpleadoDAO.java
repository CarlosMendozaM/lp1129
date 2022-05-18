/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.dao;

import com.edu.sise.entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EmpleadoDAO {
    
    //atributos
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public EmpleadoDAO(){
        cn = new Conexion().getConn();
    }
    
     private Empleado getRS(ResultSet record) throws SQLException{
        return new Empleado(
                        record.getInt("id_emp"),
                        record.getString("dni"),
                        record.getString("nombres"),
                        record.getString("apellidos"));
    }
    
    public List<Empleado> getAll(){
    
        List<Empleado> lista = new ArrayList<>();
        
        String sql = "select * from Empleado";
        
        try {
             ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()) lista.add(getRS(rs));
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        return lista;
    }
    
    public List<Empleado> getSearch(String nombre){
    
        List<Empleado> lista = new ArrayList<>();
        
        String sql = "select * from empleado where nombres like ?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+nombre+"%");
            rs = ps.executeQuery();
            while(rs.next()) lista.add(getRS(rs));
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        return lista;
    }
    
    //metodo para agregar en base de datos
    public boolean agregarEmpleado(Empleado e){
        
        int cantidad = 0;
        
        //crear nuestro script de agregar
        String sql="insert into empleado(dni,nombres,apellidos) values(?,?,?)";
        
        try{
//        st = cn.createStatement();
//        cantidad = st.executeUpdate(sql);

        ps = cn.prepareStatement(sql);
        int x =1;
        ps.setString(x++, e.getDni());
        ps.setString(x++, e.getNombres());
        ps.setString(x++, e.getApellidos());
        cantidad = ps.executeUpdate();
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
    
    //metodo para modificar un registro en base de datos
    public boolean modificarEmpleado(Empleado e){
        
        int cantidad = 0;
        
        //crear nuestro script de modificar
        String sql="update empleado set dni = ? , nombres = ? , apellidos = ? where id_emp = ? ";
        
        try{
//        st = cn.createStatement();
//        cantidad = st.executeUpdate(sql);
        ps = cn.prepareStatement(sql);
        int x =1;
        ps.setString(x++, e.getDni());
        ps.setString(x++, e.getNombres());
        ps.setString(x++, e.getApellidos());
        ps.setInt(x++, e.getId_emp());
        cantidad = ps.executeUpdate();
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
    
     //metodo para eliminar un registro en base de datos
    public boolean eliminarEmpleado(Integer id){
        
        int cantidad = 0;
        
        String sql="delete from empleado where id_emp = ? ";
        
        try{
//        st = cn.createStatement();
//        cantidad = st.executeUpdate(sql);
          ps = cn.prepareStatement(sql);
          ps.setInt(1, id);
          cantidad = ps.executeUpdate();
    } catch (Exception ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        }
        
    return (cantidad>0);
    }
}
