/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Egelantier
 */
public class MakeEntityManager {

    EntityManagerFactory emf;
    EntityManager em;

    MakeEntityManager() {
        emf = Persistence.createEntityManagerFactory("Hibernate");
        em = emf.createEntityManager();
    }

    public EntityManager getEntity() {
        return em;
    }

}
