/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.logic;

import com.edu.sise.dao.ClienteDao;
import com.edu.sise.entidades.Clientes;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ClienteLogic {
    
    List<Clientes> lista;
    
    public DefaultTableModel getModelo(){
       //cargarlista();
       
       lista = new ClienteDao().getAll();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("APELLIDOS");;
       modelo.addColumn("FNACIMIENTO");
       
       for(Clientes obj: lista){
           Object data[] = {
           obj.getId_cli(),
           obj.getNombre(), 
           obj.getApellidos(),
           obj.getFecha_nacimiento()
           };
        modelo.addRow(data);
       }
        return modelo;
    }
    
    
    public void imprimir(JTable tabla){
        tabla.setModel(getModelo());
    }
    
    public boolean agregarClientes(Clientes o){
        return new ClienteDao().agregarClientes(o);
    }
    
    public boolean modificarClientes(Clientes o){
        return new ClienteDao().modificarClientes(o);
    }
    
    public boolean eliminarClientes(Integer id){
        return new ClienteDao().eliminarClientes(id);
    }
    
}
