/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernate;
import dao.GenericDAOImpl;
import com.test.hibernate.*;
import model.*;



/**
 *
 * @author Egelantier
 */
public class Controller{
    GenericDAOImpl artikelDao ;
    MakeEntityManager mem ;
    public Controller (){
        mem = new MakeEntityManager();
    }
    public void  persistent(Hond hond){
       artikelDao  = new GenericDAOImpl(Artikel.class, mem.getEntity()) ;
        mem.getEntity().getTransaction().begin();
        artikelDao.persistent(hond);
        mem.getEntity().getTransaction().commit();
        
    }
    
}
