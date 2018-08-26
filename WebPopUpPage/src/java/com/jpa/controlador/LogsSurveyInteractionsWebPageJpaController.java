/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.entidades.HistoricoGestion;
import com.entidades.LogsSurveyInteractionsWebPage;
import com.jpa.controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sebastian
 */

@NamedStoredProcedureQuery(
	name = "sp_getHistoricoGestionCliente", 
	procedureName = "sp_getHistoricoGestionCliente", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "p_cliente")
	}
)
public class LogsSurveyInteractionsWebPageJpaController implements Serializable {

    public LogsSurveyInteractionsWebPageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LogsSurveyInteractionsWebPage logsSurveyInteractionsWebPage) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(logsSurveyInteractionsWebPage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LogsSurveyInteractionsWebPage logsSurveyInteractionsWebPage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            logsSurveyInteractionsWebPage = em.merge(logsSurveyInteractionsWebPage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = logsSurveyInteractionsWebPage.getId();
                if (findLogsSurveyInteractionsWebPage(id) == null) {
                    throw new NonexistentEntityException("The logsSurveyInteractionsWebPage with id " + id + " no longer exists.");
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
            LogsSurveyInteractionsWebPage logsSurveyInteractionsWebPage;
            try {
                logsSurveyInteractionsWebPage = em.getReference(LogsSurveyInteractionsWebPage.class, id);
                logsSurveyInteractionsWebPage.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The logsSurveyInteractionsWebPage with id " + id + " no longer exists.", enfe);
            }
            em.remove(logsSurveyInteractionsWebPage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LogsSurveyInteractionsWebPage> findLogsSurveyInteractionsWebPageEntities() {
        return findLogsSurveyInteractionsWebPageEntities(true, -1, -1);
    }

    public List<LogsSurveyInteractionsWebPage> findLogsSurveyInteractionsWebPageEntities(int maxResults, int firstResult) {
        return findLogsSurveyInteractionsWebPageEntities(false, maxResults, firstResult);
    }

    private List<LogsSurveyInteractionsWebPage> findLogsSurveyInteractionsWebPageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LogsSurveyInteractionsWebPage.class));
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

    public LogsSurveyInteractionsWebPage findLogsSurveyInteractionsWebPage(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LogsSurveyInteractionsWebPage.class, id);
        } finally {
            em.close();
        }
    }

    public int getLogsSurveyInteractionsWebPageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LogsSurveyInteractionsWebPage> rt = cq.from(LogsSurveyInteractionsWebPage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List getHistoricoGestion(String ncliente){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        StoredProcedureQuery tqo = em.createNamedStoredProcedureQuery("sp_getHistoricoGestionCliente");        
	//tqo.registerStoredProcedureParameter("p_cliente", String.class, ParameterMode.IN);
        tqo.setParameter("p_cliente", ncliente);
        tqo.execute();
        List list =tqo.getResultList();
        return list;
    }
    
}
