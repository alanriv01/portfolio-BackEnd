package com.portfolio.rivadeneiraalan.Service;

import com.portfolio.rivadeneiraalan.Entity.Persona;
import com.portfolio.rivadeneiraalan.Interface.IpersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.rivadeneiraalan.Repository.IpersonaRepository;

@Service
public class ImpPersonaService implements IpersonaService{
    @Autowired IpersonaRepository ipersonaRepositorio;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepositorio.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepositorio.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepositorio.findById(id).orElse(null);
        return persona;
    }
    
}
