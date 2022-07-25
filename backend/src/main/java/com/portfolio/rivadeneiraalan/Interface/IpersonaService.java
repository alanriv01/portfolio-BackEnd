package com.portfolio.rivadeneiraalan.Interface;

import com.portfolio.rivadeneiraalan.Entity.Persona;
import java.util.List;


public interface IpersonaService {
    //Trae una lista de personas
    public List<Persona> getPersona();
    
    //Guarda un objeto tipo persona
    public void savePersona(Persona persona);
    
    //Elimina un objeto tipo persona pero buscado por ID
    public void deletePersona(Long id);
    
    //Busca por Id una persona
    public Persona findPersona(Long id);
}
