/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernate;

import model.PostCode;
import model.Artikel;
import model.Hond;
import model.Herder;
import model.Terrier;
import model.KlantAdres;
import model.Klant;
import dao.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Egelantier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate");
        EntityManager em = emf.createEntityManager();
        GenericDAOImpl klantDao = new  GenericDAOImpl(Klant.class, em) ;
        GenericDAOImpl artikelDao = new GenericDAOImpl(Artikel.class, em) ;
        
        //--------------------------------------------------
        // als we met Controller afdelelen
        Controller controller = new Controller();
            
        // ------------------------------------------
        Klant klant1 = new Klant("Thomas");
        KlantAdres adres1 = new KlantAdres.AdresBuilder().straatNaam("Smitsweg")
                .nummer(33).postCode(new PostCode(3452, "ds")).plaats("Soest").build();
        klant1.setKlantadres(adres1);
        Klant klant2 = new Klant("Henk");
        Klant klant3 = new Klant("Ahmed");
        //---------------------------------------
        Artikel artikel1 = new Artikel("Oudekazen");
        Artikel artikel2 = new Artikel("Frysian");
        Artikel artikel3 = new Artikel("Goudsekaas");
        //----------------------------------------

        klant1.addArtikelen(artikel3);
        klant1.addArtikelen(artikel1);
        klant3.addArtikelen(artikel1);
        klant3.addArtikelen(artikel2);

        //------------------------------------------
        
        Hond hond1 = new Terrier("dog1", 3);
        Hond hond2 = new Herder("Roben", 13);
        Hond hond3 = new Terrier ("Toto", 4);
        //------------------------------------------
        
        em.getTransaction().begin();
        klantDao.persistent(klant1);
        klantDao.persistent(klant2);
        klantDao.persistent(klant3);
        artikelDao.persistent(artikel1);
        artikelDao.persistent(artikel2);
        artikelDao.persistent(artikel3);
        em.persist(hond1);
        em.persist(hond2);
        //**** Het geval van controller gebruiken
        controller.persistent(hond3);
        // ------------------------------
        em.getTransaction().commit();
        em.clear();

        System.out.println("Aantal artikelen for klant1 is : " + (em.find(Klant.class, 1L)).getArtikelen().size());
        System.out.println("De naam van 2e klant is : " + klantDao.findById(2));
        System.out.println ("De klant3 details is" + klantDao.findObjectByName("klant3").toString() );
        em.clear();
        System.out.println("the nummber of klanten witch got artikel3 is :" + (em.find(Artikel.class, 3L)).getKlanten().size());
        em.close();
        // TODO code application logic here
    }

}
