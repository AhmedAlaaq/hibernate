/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author Egelantier
 */
@Entity
@Inheritance(strategy=InheritanceType. JOINED)
public class Hond {
    @Id @GeneratedValue // In het gevaal superklasse zonder strategie
    protected long id;
    protected String naam;
    protected Integer leeftijd;
    
}
