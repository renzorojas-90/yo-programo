/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miApp.portfolioSpring.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona  {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private long id;
    
    private String nombre;
    private String apellido;
    
    @OneToMany
    List<Educacion> listaEducacion;      



    public Persona() {
    }

    public Persona(long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaEducacion = new ArrayList<>();
    }

    public void addEducacion(Educacion edu){
        this.listaEducacion.add(edu);
    }
    
    
}
