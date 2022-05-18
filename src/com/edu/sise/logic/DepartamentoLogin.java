/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.logic;

import com.edu.sise.dao.DAOManager;
import com.edu.sise.dao.DepartamentoDao;
import com.edu.sise.entidades.Departamento;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class DepartamentoLogin {
    
    List<Departamento> lista;
    DepartamentoDao dao = DAOManager.getInstancia().getDepartamentoDao();
    
    public DefaultTableModel getModelo(){
       //cargarlista();
       
       lista = dao.getAll();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE");
       
       for(Departamento obj: lista){
           Object data[] = {
           obj.getId_depa(),
           obj.getNombre()
           };
        modelo.addRow(data);
       }
        return modelo;
    }
    
//    public void cargarlista(){
//    lista = new ArrayList<>();
//    lista.add(new Departamento(100,"La Libertad"));
//    lista.add(new Departamento(200,"Lambayeque"));
//    lista.add(new Departamento(300,"Lima"));
//    lista.add(new Departamento(400,"Tumbes"));
//    }
    
    public void imprimir(JTable tabla){
        tabla.setModel(getModelo());
    }
    
    public boolean agregarDepartamento(Departamento o){
        return dao.agregarDepartamento(o);
    }
    
    public boolean modificarDepartamento(Departamento o){
        return dao.modificarDepartamento(o);
    }
    
    public boolean eliminarDepartamento(Integer id){
        return dao.eliminarDepartamento(id);
    }
    
    //metodo para llenar informacion del combo departamento
    public void llenarComboDepartamento(JComboBox cbo){
        lista = new DepartamentoDao().getAll();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        for(Departamento obj: lista){ 
            modelo.addElement(obj); 
        }  
        
        cbo.setModel(modelo);
    }
    
    public void seleccionarItemCbo(JComboBox cbo, Integer id){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)cbo.getModel();
        
        for(int i=0; i<modelo.getSize();i++) {
            if(((Departamento)modelo.getElementAt(i)).getId_depa()==id){
                modelo.setSelectedItem(modelo.getElementAt(i));
            }

        }
    }
}
