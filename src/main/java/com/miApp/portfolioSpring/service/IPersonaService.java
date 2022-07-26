
package com.miApp.portfolioSpring.service;

import com.miApp.portfolioSpring.model.Educacion;
import com.miApp.portfolioSpring.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List <Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public void editarPersona(Persona per);
    public void agregarEducacion(Educacion edu,Persona per);
    
    
}
