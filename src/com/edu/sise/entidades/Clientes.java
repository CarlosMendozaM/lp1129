/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.entidades;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class Clientes {
    
    private Integer id_cli;
    private String nombre;
    private String apellidos;
    private LocalDate fecha_nacimiento;

    public Clientes(Integer id_cli, String nombre, String apellidos, LocalDate fecha_nacimiento) {
        this.id_cli = id_cli;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getId_cli() {
        return id_cli;
    }

    public void setId_cli(Integer id_cli) {
        this.id_cli = id_cli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
}
