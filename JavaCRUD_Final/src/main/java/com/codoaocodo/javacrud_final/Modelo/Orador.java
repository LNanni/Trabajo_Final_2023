package com.codoaocodo.javacrud_final.Modelo;

import java.time.LocalDateTime;

public class Orador {
    private int id;
    private String nombre;
    private String apellido;
    private String tema;
    private String mail;
    private LocalDateTime fechaAlta;
    
    public Orador(int id, String nom, String ape, String tema, String mail, LocalDateTime alta){
        this.id = id;
        nombre = nom; 
        apellido = ape;
        this.tema = tema;
        this.mail = mail;
        fechaAlta = alta;
    }
    
    public int getId(){return id;}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getTema(){return tema;}
    public String getMail(){return mail;}
    public LocalDateTime getFechaAlta(){return fechaAlta;}    
}
