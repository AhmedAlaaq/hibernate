/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "KLANT")
public class Klant {
   /* @org.hibernate.annotations.Loader(namedQuery = "loadklant")*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "KLANTNAAM")
    private String klantnaam;
    @ManyToMany
    @JoinTable(name = "KLANTenARTIKEL",
            joinColumns = @JoinColumn(name = "KLANTID",
                    referencedColumnName = "id"))
    private List<Artikel> artikelen;
    @Embedded
    private KlantAdres klantadres;

    public Klant() {
        this("");
        artikelen = new ArrayList<>();
    }

    public Klant(String klantnaam) {
        this.klantnaam = klantnaam;
        artikelen = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getKlantnaam() {
        return klantnaam;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKlantnaam(String klantnaam) {
        this.klantnaam = klantnaam;
    }

    public List<Artikel> getArtikelen() {
        return artikelen;
    }

    public void addArtikelen(Artikel artikel) {
        artikelen.add(artikel);
    }

    public KlantAdres getKlantadres() {
        return klantadres;
    }

    public void setArtikelen(List<Artikel> artikelen) {
        this.artikelen = artikelen;
    }

    public void setKlantadres(KlantAdres klantadres) {
        this.klantadres = klantadres;
    }

    @Override
    public String toString() {
        return "Klant{" + "id=" + id + ", klantnaam=" + klantnaam + ", klantadres=" + klantadres + '}'
                + "Het antaal Artikelen van deze klant zijn : " + artikelen.size() ;
    }
    



}
