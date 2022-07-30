
package com.portfolio.rivadeneiraalan.Controller;

import com.portfolio.rivadeneiraalan.Dto.dtoAcercade;
import com.portfolio.rivadeneiraalan.Entity.Acercade;
import com.portfolio.rivadeneiraalan.Security.Controller.Mensaje;
import com.portfolio.rivadeneiraalan.Service.SAcercade;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcercade {
    @Autowired
    SAcercade sAcercade;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acercade>> list(){
        List<Acercade> list = sAcercade.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Acercade> getById(@PathVariable("id") int id){
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Acercade acercade = sAcercade.getOne(id).get();
        return new ResponseEntity(acercade, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sAcercade.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sAcercade.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoacercade){      
        if(StringUtils.isBlank(dtoacercade.getAcercadeA()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sAcercade.existsByAcercadeA(dtoacercade.getAcercadeA()))
            return new ResponseEntity(new Mensaje("Ese campo ya existe"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade = new Acercade (dtoacercade.getAcercadeA());
        sAcercade.save(acercade);
        
        return new ResponseEntity(new Mensaje("Campo agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoacercade){
        //Validamos si existe el ID
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sAcercade.existsByAcercadeA(dtoacercade.getAcercadeA()) && sAcercade.getByAcercadeA(dtoacercade.getAcercadeA()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese campo ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoacercade.getAcercadeA()))
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade = sAcercade.getOne(id).get();
        acercade.setAcercadeA(dtoacercade.getAcercadeA());
                
        sAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Campo actualizado"), HttpStatus.OK);
             
    }
}
