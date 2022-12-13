
package com.miApp.portfolioSpring.service;

import com.miApp.portfolioSpring.model.Educacion;
import com.miApp.portfolioSpring.model.Persona;
import com.miApp.portfolioSpring.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
     public PersonaRepository persoRepo;
    
    @Autowired
     public EducacionService eduServ; 
    
    @Override
    public List<Persona> verPersonas() {
     return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }
    
    @Override
    public void editarPersona(Persona per){
        persoRepo.save(per);
    }

    @Override
    public void agregarEducacion(Educacion edu, Persona per) {
        
        System.out.println(edu);
        System.out.println(":"+edu.getNombreInstituto());
        
        Educacion edu_id = eduServ.crearEducacion(edu);
        per.addEducacion(edu_id);
        persoRepo.save(per);
        
        for(Educacion lista : per.getListaEducacion()){
            
            System.out.println("lista completa: " + lista.getNombreInstituto());
            
            
        }
        
    }
    
   
    
}
