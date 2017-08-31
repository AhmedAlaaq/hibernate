/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Egelantier
 */
@Entity
@Table(name = "ARTIKEL")
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARTIKELID")
    private long id;
    @Column(name = "ARTIKELNAAM")
    private String artikelnaam;
    @ManyToMany(mappedBy="artikelen")
    
    private List<Klant> klanten;

    public Artikel() {
        klanten = new ArrayList<>();
    }

    public Artikel(String artikelnaam) {
        this.artikelnaam = artikelnaam;
         klanten = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getArtikelnaam() {
        return artikelnaam;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setArtikelnaam(String artikelnaam) {
        this.artikelnaam = artikelnaam;
    }

    public List<Klant> getKlanten() {
        return klanten;
    }

    public void addKlanten(Klant klant) {
        klanten.add(klant);
    }
 
    

    @Override
    public String toString() {
        return "Artikel{" + "id=" + id + ", artikelnaam=" + artikelnaam + '}';
    }

}
