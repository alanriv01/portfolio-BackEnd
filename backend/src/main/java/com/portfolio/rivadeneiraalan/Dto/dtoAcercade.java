
package com.portfolio.rivadeneiraalan.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcercade {
    @NotBlank
    private String acercadeA;
    
    //constructor

    public dtoAcercade() {
    }

    public dtoAcercade(String acercadeA) {
        this.acercadeA = acercadeA;
    }
    
    //getter y setter

    public String getAcercadeA() {
        return acercadeA;
    }

    public void setAcercadeA(String acercadeA) {
        this.acercadeA = acercadeA;
    }
    
}
