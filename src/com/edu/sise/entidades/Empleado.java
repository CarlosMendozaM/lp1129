/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.entidades;

/**
 *
 * @author Lenovo
 */
public class Empleado {

    public Integer id_emp;
    public String dni;
    public String nombres;
    public String apellidos;

    public Empleado() {
    }
    
    
    public Empleado(Integer id_emp, String dni, String nombres, String apellidos) {
        this.id_emp = id_emp;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getId_emp() {
        return id_emp;
    }

    public void setId_emp(Integer id_emp) {
        this.id_emp = id_emp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
   

}
