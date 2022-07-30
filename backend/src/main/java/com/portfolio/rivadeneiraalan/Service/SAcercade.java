
package com.portfolio.rivadeneiraalan.Service;

import com.portfolio.rivadeneiraalan.Entity.Acercade;
import com.portfolio.rivadeneiraalan.Repository.RAcercade;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercade {
    @Autowired
    RAcercade rAcercade;
    
    public List<Acercade> list(){
        return rAcercade.findAll();
    }
    
    public Optional<Acercade> getOne(int id){
        return rAcercade.findById(id);
    }
    
    public Optional<Acercade> getByAcercadeA(String acercadeA){
        return rAcercade.findByAcercadeA(acercadeA);
    }
    
    public void save(Acercade acercade){
        rAcercade.save(acercade);
    }
    
    public void delete(int id){
        rAcercade.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAcercade.existsById(id);
    }
    
    public boolean existsByAcercadeA(String acercadeA){
        return rAcercade.existsByAcercadeA(acercadeA);
    }
}
