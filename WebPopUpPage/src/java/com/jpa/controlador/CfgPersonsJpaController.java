/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.bean.exceptions.NonexistentEntityException;
import com.entidades.CfgPersons;
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
public class CfgPersonsJpaController implements Serializable {

    private EntityManagerFactory emf = null;
    public CfgPersonsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CfgPersons cfgPersons) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cfgPersons);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CfgPersons cfgPersons) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cfgPersons = em.merge(cfgPersons);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cfgPersons.getId();
                if (findCfgPersons(id) == null) {
                    throw new NonexistentEntityException("The cfgPersons with id " + id + " no longer exists.");
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
            CfgPersons cfgPersons;
            try {
                cfgPersons = em.getReference(CfgPersons.class, id);
                cfgPersons.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cfgPersons with id " + id + " no longer exists.", enfe);
            }
            em.remove(cfgPersons);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CfgPersons> findCfgPersonsEntities() {
        return findCfgPersonsEntities(true, -1, -1);
    }

    public List<CfgPersons> findCfgPersonsEntities(int maxResults, int firstResult) {
        return findCfgPersonsEntities(false, maxResults, firstResult);
    }

    private List<CfgPersons> findCfgPersonsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CfgPersons.class));
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

    public CfgPersons findCfgPersons(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CfgPersons.class, id);
        } finally {
            em.close();
        }
    }

    public int getCfgPersonsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CfgPersons> rt = cq.from(CfgPersons.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public CfgPersons getCfgPersonsByUsername(String username){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<CfgPersons> tqcp = em.createNamedQuery("CfgPersons.findByUsername",
                    CfgPersons.class);
            tqcp.setParameter("username", username);
            List<CfgPersons> lcp = tqcp.getResultList();
            return lcp.get(0);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
