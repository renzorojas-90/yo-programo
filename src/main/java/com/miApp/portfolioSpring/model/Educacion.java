
package com.miApp.portfolioSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;    

    private String nombreInstituto;
    private String tituloEducacion;
    private String periodo;
    

    
    public Educacion() {
    }

    public Educacion(long id, String nombreInstituto, String tituloEducacion, String periodo) {
        this.id = id;
        this.nombreInstituto = nombreInstituto;
        this.tituloEducacion = tituloEducacion;
        this.periodo = periodo;
    }

    
    
}
