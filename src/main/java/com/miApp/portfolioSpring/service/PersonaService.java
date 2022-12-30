
package com.miApp.portfolioSpring.service;

import com.miApp.portfolioSpring.model.Educacion;
import com.miApp.portfolioSpring.model.Persona;
import com.miApp.portfolioSpring.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    //se agrega el persoRepo para persistir en la BD a la persona
    @Autowired
     public PersonaRepository persoRepo;
    
    //se agrega el servicio mara manipular a la Educacion ypoder persistir luego
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
        //aqui viene la magia jajaja
        
        //1- se crea la variable edu_id que almacene la educacion que se duardara en la tabla,
        //2- [eduServ.crearEducacion(edu);] persiste la educacion en la tabla y 
        //retorna la educacion ya guardada, esta se almacena en edu_id ("ver crearEducacion() en educacionService")     
        Educacion edu_id = eduServ.crearEducacion(edu);
        //ya en este punto se creo la educacion en la tabla y se almaceno en (edu_id) momentaneamente
        //ahora vamos a añadir a la listaEducacion de la clase persona esa educacion  
        // la cual tenemos en (edu_id)
        
        //3- (per) es la persona que se le envió y atraves de ella accedemos a los atributos de persona
        //al hacer per.addEducacion accedemos a la funcion en la clase Persona funcion: addEducacion
        //que recibe una educacion "ver el modelo Persona.java"
        //le enviamos edu_id a per.addEducacion(edu_id);
        //y asi se le asigna la educacion a la listaEducacion porque es una lista es decir se 
        //trabaja como Array y los metodos da un Array son add, remove. etc.
        // no se setea la lista porque remplazaria las educaciones consecutivamente y se necesita es 
        //ir agregandole no remplazandole.
        per.addEducacion(edu_id);
        //aqui ya se le agrego la educacion a la listaEducacion de personas una nueva educacion
        //es decir se modifico el atributo listaEducacion
        //pero esta persona que se le agrego esa eduacion no esta persistida en la base de datos
        //asi que toca persistirla para que almacene la educacion en su persona y quede relacionada.
        persoRepo.save(per);
            
        //y listo tres lineas de codigo. mil horas de pensamiento jajajajaja    
        
        
    }
      
}
