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
import javax.persistence.Table;

/**
 *
 * @author Egelantier
 */
@Entity
@Inheritance

@Table(name="HERDER")
public class Herder extends Hond{

    public Herder() {
    }
    public Herder(String naam, Integer leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }
}