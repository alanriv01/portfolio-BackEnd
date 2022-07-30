
package com.portfolio.rivadeneiraalan.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acercade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String acercadeA;
    
    //constructor

    public Acercade() {
    }

    public Acercade(String acercadeA) {
        this.acercadeA = acercadeA;
    }
    
    //getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcercadeA() {
        return acercadeA;
    }

    public void setAcercadeA(String acercadeA) {
        this.acercadeA = acercadeA;
    }
    
}
