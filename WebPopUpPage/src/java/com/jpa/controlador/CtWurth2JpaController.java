/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.bean.exceptions.NonexistentEntityException;
import com.entidades.CtWurth2;
import com.entidades.HistoricoGestion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sebastian
 */
public class CtWurth2JpaController implements Serializable {

    public CtWurth2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CtWurth2 ctWurth2) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ctWurth2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CtWurth2 ctWurth2) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ctWurth2 = em.merge(ctWurth2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ctWurth2.getRecordId();
                if (findCtWurth2(id) == null) {
                    throw new NonexistentEntityException("The ctWurth2 with id " + id + " no longer exists.");
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
            CtWurth2 ctWurth2;
            try {
                ctWurth2 = em.getReference(CtWurth2.class, id);
                ctWurth2.getRecordId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ctWurth2 with id " + id + " no longer exists.", enfe);
            }
            em.remove(ctWurth2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CtWurth2> findCtWurth2Entities() {
        return findCtWurth2Entities(true, -1, -1);
    }

    public List<CtWurth2> findCtWurth2Entities(int maxResults, int firstResult) {
        return findCtWurth2Entities(false, maxResults, firstResult);
    }

    private List<CtWurth2> findCtWurth2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CtWurth2.class));
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
    
    public List<CtWurth2> findCtWurthEntitiesByTodayTime(String username) {
        EntityManager em = getEntityManager();
        try {            
            TypedQuery<CtWurth2> tqcw = em.createNamedQuery("CtWurth2.findByToday",
                    CtWurth2.class);            
            Calendar cal = Calendar.getInstance(); // locale-specific
                    cal.setTime(new Date());
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
            tqcw.setParameter("agentDn", username);
            tqcw.setParameter("crrTime",cal.getTime());
            
            List<CtWurth2> lcw = tqcw.getResultList();
            return lcw;
        } finally {
            em.close();
        }
    }
    
        public List<CtWurth2> findCtWurthEntitiesBySchedTime(String username) {
        EntityManager em = getEntityManager();
        try {            
            TypedQuery<CtWurth2> tqcw = em.createNamedQuery("CtWurth2.findBySched",
                    CtWurth2.class);                  
            Calendar cal = Calendar.getInstance(); // locale-specific
                    cal.setTime(new Date());
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
            tqcw.setParameter("agentDn", username);
            tqcw.setParameter("schedTime",cal.getTime());
            
            List<CtWurth2> lcw = tqcw.getResultList();
            return lcw;
        } finally {
            em.close();
        }
    }
        


    public CtWurth2 findCtWurth2(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CtWurth2.class, id);
        } finally {
            em.close();
        }
    }

    public int getCtWurth2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CtWurth2> rt = cq.from(CtWurth2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
