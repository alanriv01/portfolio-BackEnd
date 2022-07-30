
package com.portfolio.rivadeneiraalan.Repository;

import com.portfolio.rivadeneiraalan.Entity.Acercade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercade extends JpaRepository<Acercade, Integer> {
    public Optional<Acercade> findByAcercadeA(String acercadeA);
    public boolean existsByAcercadeA(String acercadeA);
}
