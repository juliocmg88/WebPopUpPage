/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.bean.exceptions.NonexistentEntityException;
import com.entidades.CfgImports;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sebastian
 */
public class CfgImportsJpaController implements Serializable {

    public CfgImportsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CfgImports cfgImports) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cfgImports);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CfgImports cfgImports) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cfgImports = em.merge(cfgImports);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cfgImports.getId();
                if (findCfgImports(id) == null) {
                    throw new NonexistentEntityException("The cfgImports with id " + id + " no longer exists.");
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
            CfgImports cfgImports;
            try {
                cfgImports = em.getReference(CfgImports.class, id);
                cfgImports.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cfgImports with id " + id + " no longer exists.", enfe);
            }
            em.remove(cfgImports);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CfgImports> findCfgImportsEntities() {
        return findCfgImportsEntities(true, -1, -1);
    }

    public List<CfgImports> findCfgImportsEntities(int maxResults, int firstResult) {
        return findCfgImportsEntities(false, maxResults, firstResult);
    }

    private List<CfgImports> findCfgImportsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CfgImports.class));
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

    public CfgImports findCfgImports(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CfgImports.class, id);
        } finally {
            em.close();
        }
    }

    public int getCfgImportsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CfgImports> rt = cq.from(CfgImports.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
