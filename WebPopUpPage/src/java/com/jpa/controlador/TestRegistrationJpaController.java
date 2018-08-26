/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.entidades.TestRegistration;
import com.jpa.controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author Sebastian
 */
public class TestRegistrationJpaController implements Serializable {

    private EntityManagerFactory emf = null;
    public TestRegistrationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TestRegistration testRegistration) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(testRegistration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TestRegistration testRegistration) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            testRegistration = em.merge(testRegistration);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = testRegistration.getUserId();
                if (findTestRegistration(id) == null) {
                    throw new NonexistentEntityException("The testRegistration with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TestRegistration testRegistration;
            try {
                testRegistration = em.getReference(TestRegistration.class, id);
                testRegistration.getUserId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The testRegistration with id " + id + " no longer exists.", enfe);
            }
            em.remove(testRegistration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TestRegistration> findTestRegistrationEntities() {
        return findTestRegistrationEntities(true, -1, -1);
    }

    public List<TestRegistration> findTestRegistrationEntities(int maxResults, int firstResult) {
        return findTestRegistrationEntities(false, maxResults, firstResult);
    }

    private List<TestRegistration> findTestRegistrationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TestRegistration.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public TestRegistration validar(String username,String password){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<TestRegistration> tqtr = em.createNamedQuery("TestRegistration.findByUsernameAndPassword",
                    TestRegistration.class);
            tqtr.setParameter("username", username);
            tqtr.setParameter("password", password);
            List<TestRegistration> ltr = tqtr.getResultList();
            return ltr.get(0);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public TestRegistration findTestRegistration(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TestRegistration.class, id);
        } finally {
            em.close();
        }
    }

    public int getTestRegistrationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TestRegistration> rt = cq.from(TestRegistration.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
