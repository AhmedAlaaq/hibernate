/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.List;
import model.Klant;

/**
 *
 * @author Egelantier
 */
interface GenericDAO<T> {

    public void persistent(T object);

    public T findById(long id);

    public List<T> findAll(Class<T> entityClass);

    public T update(T object);

    public void delete(T object);

    public Object findObjectByName(String name);
}
