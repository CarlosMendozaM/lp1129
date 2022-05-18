/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.entidades;

/**
 *
 * @author Lenovo
 */
public class Provincia {
    private Integer id_prov;
    private String nombre;
    private Integer id_depa;
    
    private String Des_ID_Depa;


    public Provincia(Integer id_prov, String nombre, Integer id_depa) {
        this.id_prov = id_prov;
        this.nombre = nombre;
        this.id_depa = id_depa;
    }

    public Provincia(Integer id_prov, String nombre, Integer id_depa, String Des_ID_Depa) {
        this.id_prov = id_prov;
        this.nombre = nombre;
        this.id_depa = id_depa;
        this.Des_ID_Depa = Des_ID_Depa;
    }
    
    

    public Integer getId_prov() {
        return id_prov;
    }

    public void setId_prov(Integer id_prov) {
        this.id_prov = id_prov;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_depa() {
        return id_depa;
    }

    public void setId_depa(Integer id_depa) {
        this.id_depa = id_depa;
    }

    public String getDes_ID_Depa() {
        return Des_ID_Depa;
    }

    public void setDes_ID_Depa(String Des_ID_Depa) {
        this.Des_ID_Depa = Des_ID_Depa;
    }

 @Override
    public String toString() {
        return id_prov + ".- " + nombre;
    }
}
