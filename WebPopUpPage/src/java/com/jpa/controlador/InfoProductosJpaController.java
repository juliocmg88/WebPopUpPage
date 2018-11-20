/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.controlador;

import com.entidades.CfgPersons;
import com.entidades.InfoProductos;
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
public class InfoProductosJpaController implements Serializable {

    public InfoProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InfoProductos infoProductos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(infoProductos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InfoProductos infoProductos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infoProductos = em.merge(infoProductos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infoProductos.getId();
                if (findInfoProductos(id) == null) {
                    throw new NonexistentEntityException("The infoProductos with id " + id + " no longer exists.");
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
            InfoProductos infoProductos;
            try {
                infoProductos = em.getReference(InfoProductos.class, id);
                infoProductos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infoProductos with id " + id + " no longer exists.", enfe);
            }
            em.remove(infoProductos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InfoProductos> findInfoProductosEntities() {
        return findInfoProductosEntities(true, -1, -1);
    }

    public List<InfoProductos> findInfoProductosEntities(int maxResults, int firstResult) {
        return findInfoProductosEntities(false, maxResults, firstResult);
    }

    private List<InfoProductos> findInfoProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InfoProductos.class));
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

    public InfoProductos findInfoProductos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InfoProductos.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfoProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InfoProductos> rt = cq.from(InfoProductos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    public List<InfoProductos> findInfoProductosByNcliente(int ncliente) {
        EntityManager em = getEntityManager();
        try{
            TypedQuery<InfoProductos> tqcp = em.createNamedQuery("InfoProductos.findByNcliente",
                    InfoProductos.class);
            tqcp.setParameter("ncliente", ncliente);
            List<InfoProductos> lcp = tqcp.getResultList();
            return lcp;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
