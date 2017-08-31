/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.Klant;

/**
 *
 * @author Egelantier
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    @PersistenceContext
    protected EntityManager em;
    protected Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public GenericDAOImpl(EntityManager em) {
        this.em = em;

    }

    public GenericDAOImpl(Class<T> entityClass, EntityManager em) {
        this.entityClass = entityClass;
        this.em = em;
    }

    @Override

    public void persistent(T object) {

        em.persist(object);
    }

    @Override
    public T findById(long id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        CriteriaQuery<T> c
                = em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }

    @Override

    public T update(T object) {

        return em.merge(object);

    }

    @Override

    public void delete(T object) {

        em.remove(object);

    }
@Override
    public Object findObjectByName(String name) {
        Query query = em.createNativeQuery("select i from KLANT i  where i.KLANTNAAM = :name");
       query.setParameter("name", name);
        return (Object)(query.getSingleResult());
    }

}
