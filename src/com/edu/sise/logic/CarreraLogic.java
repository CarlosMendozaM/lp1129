/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.logic;

import com.edu.sise.dao.CarreraDao;
import com.edu.sise.dao.DAOManager;
import com.edu.sise.entidades.Carrera;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class CarreraLogic {
    
    List<Carrera> lista;
    CarreraDao dao = DAOManager.getInstancia().getCarreraDao();
    
    public DefaultTableModel getModelo(){
       //cargarlista();
       
       lista = dao.getAll();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE");
       
       for(Carrera obj: lista){
           Object data[] = {
           obj.getId_carrera(),
           obj.getNombre()
           };
        modelo.addRow(data);
       }
        return modelo;
    }
    
    public DefaultTableModel getModelo(String nombre){
       //cargarlista();
       
       lista = dao.getSearch(nombre);
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("NOMBRE");
       
       for(Carrera obj: lista){
           Object data[] = {
           obj.getId_carrera(),
           obj.getNombre()
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
    
    public boolean agregarCarrera(Carrera o){
        return dao.agregarCarrera(o);
    }
    
    public boolean modificarCarrera(Carrera o){
        return dao.modificarCarrera(o);
    }
    
    public boolean eliminarCarrera(Integer id){
        return dao.eliminarCarrera(id);
    }
    
    public void generarReporte(){
        JasperReport reporte;
        String ruta = "C:\\Users\\Lenovo\\Pictures\\Desktop\\CARLOS ADRIAN\\Lenguaje-Programacion(Java)\\Reportes_1129\\rpt_carreras_v1.jasper";
        
        //Mis parametros
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("empresa","INSTITUTO SISE");
        
         try {
            //a cargar el reporte en memoria
            reporte = (JasperReport)JRLoader.loadObjectFromFile(ruta);
            JasperPrint print = JasperFillManager.fillReport(reporte,parametros,
                    new JRBeanCollectionDataSource(new CarreraDao().getAll()));
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true); 
        } catch (Exception e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }

    }

    //metodo para llenar informacion del combo departamento
    public void llenarComboCarrera(JComboBox cbo){
        lista = dao.getAll();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        for(Carrera obj: lista){ 
            modelo.addElement(obj); 
        }  
        
        cbo.setModel(modelo);
    }
    
    public void seleccionarItemCbo(JComboBox cbo, Integer id){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)cbo.getModel();
        
        for(int i=0; i<modelo.getSize();i++) {
            if(((Carrera)modelo.getElementAt(i)).getId_carrera()==id){
                modelo.setSelectedItem(modelo.getElementAt(i));
            }

        }
    }

    
}
