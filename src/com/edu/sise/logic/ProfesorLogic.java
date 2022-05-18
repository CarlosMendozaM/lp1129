/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.logic;

import com.edu.sise.dao.DAOManager;
import com.edu.sise.dao.ProfesorDao;
import com.edu.sise.entidades.Profesor;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ProfesorLogic {
    
    List<Profesor> lista;
    ProfesorDao dao = DAOManager.getInstancia().getProfesorDao();
    
    public DefaultTableModel getModelo(){
       //cargarlista();
       //lista = new ProfesorDao().getAll();
       lista = dao.getAll();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("DNI");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("PAPELLIDO");
       modelo.addColumn("SAPELLIDO");
       modelo.addColumn("FNACIMIENTO");
       modelo.addColumn("TELEFONO");
       modelo.addColumn("ID_CARRERA");
       modelo.addColumn("ID_PROV");
       
       for(Profesor obj: lista){
           Object data[] = {
           obj.getId_profe(),
           obj.getDni(),
           obj.getNombre(), 
           obj.getPapellido(),
           obj.getSapellido(),
           obj.getFnacimiento(),
           obj.getTelefono(),
           obj.getId_carrera(),
           obj.getId_prov()
           };
        modelo.addRow(data);
       }
        return modelo;
    }
    
    public DefaultTableModel getModelo(String nombre){
       //cargarlista();
       
       lista = new ProfesorDao().getSearch(nombre);
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("ID");
       modelo.addColumn("DNI");
       modelo.addColumn("NOMBRE");
       modelo.addColumn("PAPELLIDO");
       modelo.addColumn("SAPELLIDO");
       modelo.addColumn("FNACIMIENTO");
       modelo.addColumn("TELEFONO");
       modelo.addColumn("ID_CARRERA");
       modelo.addColumn("ID_PROV");
       
       for(Profesor obj: lista){
           Object data[] = {
           obj.getId_profe(),
           obj.getDni(),
           obj.getNombre(), 
           obj.getPapellido(),
           obj.getSapellido(),
           obj.getFnacimiento(),
           obj.getTelefono(),
           obj.getId_carrera(),
           obj.getId_prov()
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
    
    public boolean agregarProfesor(Profesor o){
        return dao.agregarProfesor(o);
    }
    
    public boolean modificarProfesor(Profesor o){
        return dao.modificarProfesor(o);
    }
    
    public boolean eliminarProfesor(Integer id){
        return dao.eliminarProfesor(id);
    }
    
    public int cargaMasiva(String rutaArchivo){
        int registros_afectados = 0;
        try {
            FileInputStream archivo = new FileInputStream(rutaArchivo);
            DataInputStream entrada = new DataInputStream(archivo);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String linea;
            List<Profesor>listaCargaMasiva = new ArrayList<>();
            while((linea=buffer.readLine())!=null){
                System.out.println(linea);
                String[] campos = linea.split("\\|");
                listaCargaMasiva.add(new Profesor(
                    -1,
                    campos[0],
                    campos[1],
                    campos[2],
                    campos[3],
                    LocalDate.parse(campos[4]),
                    campos[5],
                    Integer.parseInt(campos[6]),//id_carrera
                    Integer.parseInt(campos[7])//id_prov
                ));
            }
            
            entrada.close();
            int[] resultados = new ProfesorDao().cargaMasiva(listaCargaMasiva);
            for(int i = 0; i<resultados.length;i++)
                registros_afectados += resultados[i];
        } catch (Exception ex) {
            System.out.println("Error Carga Masiva: " + ex.getMessage());
        }
        
        return registros_afectados;
    }
}
