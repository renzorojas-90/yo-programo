
package com.miApp.portfolioSpring.service;

import com.miApp.portfolioSpring.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public void crearEducacion(Educacion edu);
    public List <Educacion> verEducacion();
    public void eliminarEducacion(long id);
    public void editarEducacion(Educacion edu);
}
