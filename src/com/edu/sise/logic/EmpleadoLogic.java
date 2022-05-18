/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.logic;

import com.edu.sise.dao.EmpleadoDAO;
import com.edu.sise.entidades.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class EmpleadoLogic {
    
    List<Empleado> lista;
    
    public DefaultTableModel getModelo(){
       //cargarlista();
       
       lista = new EmpleadoDAO().getAll();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("DNI");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("APELLIDO");
       
       for(Empleado obj: lista){
           Object data[] = {
           obj.id_emp,
           obj.dni,
           obj.nombres,
           obj.apellidos
           };
        modelo.addRow(data);
       }
        return modelo;
    }
    
     public DefaultTableModel getModelo(String nombre){
       //cargarlista();
       
       lista = new EmpleadoDAO().getSearch(nombre);
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("DNI");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("APELLIDO");
       
       for(Empleado obj: lista){
           Object data[] = {
           obj.getId_emp(),
           obj.getDni(),
           obj.getNombres(),
           obj.getApellidos(),
           };
        modelo.addRow(data);
       }
        return modelo;
    }
    
    public void imprimir(JTable tabla){
        tabla.setModel(getModelo());
    }
    
    public void imprimir(JTable tabla, String nombre){
        tabla.setModel(getModelo(nombre));
    }
    
    public boolean agregarEmpleado(Empleado e){
        return new EmpleadoDAO().agregarEmpleado(e);
    }
    
    public boolean modificarEmpleado(Empleado e){
        return new EmpleadoDAO().modificarEmpleado(e);
    }
    
    public boolean eliminarEmpleado(Integer id){
        return new EmpleadoDAO().eliminarEmpleado(id);
    }
}
