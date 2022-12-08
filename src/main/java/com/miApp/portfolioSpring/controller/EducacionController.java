
package com.miApp.portfolioSpring.controller;

import com.miApp.portfolioSpring.model.Educacion;
import com.miApp.portfolioSpring.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    public IEducacionService eduServ;
    
    @PostMapping("/new/educacion")
    public void crearEducacion(@RequestBody Educacion edu){
        eduServ.crearEducacion(edu);
    }
    
    @GetMapping("ver/educacion")
    @ResponseBody
    public List <Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @DeleteMapping("/eliminar/educacion/{id}")
    public void eliminarEducacion(@PathVariable Long id){
        eduServ.eliminarEducacion(id);
    }
    
    @PutMapping("editar/educacion")
    public void editarEducacion(@RequestBody Educacion edu){
        eduServ.editarEducacion(edu);
    }
}
