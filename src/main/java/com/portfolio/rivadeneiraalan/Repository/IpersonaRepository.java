package com.portfolio.rivadeneiraalan.Repository;

import com.portfolio.rivadeneiraalan.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpersonaRepository extends JpaRepository<Persona,Long> {
    
}
