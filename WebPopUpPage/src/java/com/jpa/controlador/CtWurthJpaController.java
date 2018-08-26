/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.entidades.CtWurth;
import com.jpa.controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sebastian
 */
public class CtWurthJpaController implements Serializable {

    public CtWurthJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CtWurth ctWurth) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ctWurth);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CtWurth ctWurth) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ctWurth = em.merge(ctWurth);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ctWurth.getRecordId();
                if (findCtWurth(id) == null) {
                    throw new NonexistentEntityException("The ctWurth with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CtWurth ctWurth;
            try {
                ctWurth = em.getReference(CtWurth.class, id);
                ctWurth.getRecordId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ctWurth with id " + id + " no longer exists.", enfe);
            }
            em.remove(ctWurth);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CtWurth> findCtWurthEntities() {
        return findCtWurthEntities(true, -1, -1);
    }

    public List<CtWurth> findCtWurthEntities(int maxResults, int firstResult) {
        return findCtWurthEntities(false, maxResults, firstResult);
    }

    private List<CtWurth> findCtWurthEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CtWurth.class));
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
    
    public List<CtWurth> findCtWurthEntitiesByUsername(String username) {
        EntityManager em = getEntityManager();
        try {            
            TypedQuery<CtWurth> tqcw = em.createNamedQuery("CtWurth.findByUsernameEjecutivo",
                    CtWurth.class);
            tqcw.setParameter("usernameEjecutivo", username);
            
            List<CtWurth> lcw = tqcw.getResultList();
            return lcw;
        } finally {
            em.close();
        }
    }

    public CtWurth findCtWurth(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CtWurth.class, id);
        } finally {
            em.close();
        }
    }

    public int getCtWurthCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CtWurth> rt = cq.from(CtWurth.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
