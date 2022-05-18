/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.sise.dao;

/**
 *
 * @author Lenovo
 */
public class DAOManager {
    
    //atributos para el Singleton
    private static final DAOManager instancia = new DAOManager();
    
    public static DAOManager getInstancia(){
        return instancia;
    }
    //fin de Singleton
    
    //Inicio de Factory
    private CarreraDao carreraDao;
    private DepartamentoDao departamentoDao;
    private ProvinciaDao provinciaDao;
    private TutorDao tutorDao;
    private ProfesorDao profesorDao;
    
    public CarreraDao getCarreraDao(){
        if(carreraDao==null)
            carreraDao = new CarreraDao();
        return carreraDao;
    }
    
    public DepartamentoDao getDepartamentoDao(){
        if(departamentoDao==null)
            departamentoDao = new DepartamentoDao();
        return departamentoDao;
    }
    
    public ProvinciaDao getProvinciaDao(){
        if(provinciaDao==null)
            provinciaDao = new ProvinciaDao();
        return provinciaDao;
    }
    
    public TutorDao getTutorDao(){
        if(tutorDao==null)
            tutorDao = new TutorDao();
        return tutorDao;
    }
    
    public ProfesorDao getProfesorDao(){
        if(profesorDao==null)
            profesorDao = new ProfesorDao();
        return profesorDao;
    }
}
