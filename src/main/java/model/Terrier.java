/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Inheritance;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Egelantier
 */
@Entity
@Inheritance
@AttributeOverrides({@AttributeOverride(name="naam",
                               column=@Column(name="T_NAAM")),
            @AttributeOverride(name="naam",
                               column=@Column(name="T_NAAM")),
            @AttributeOverride(name="leeftijd",
                               column=@Column(name="T_LEEFTIJD"))
        })
@Table(name="TERRIER")
public class Terrier extends Hond{

 
         
    public Terrier(){
        
    }

    public Terrier(String naam, Integer leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
