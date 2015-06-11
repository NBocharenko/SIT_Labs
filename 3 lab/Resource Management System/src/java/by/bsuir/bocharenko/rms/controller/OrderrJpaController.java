/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.controller;

import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author user
 */
public class OrderrJpaController implements Serializable {

    public OrderrJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orderr orderr) throws NonexistentEntityException{
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Supplier supplier = em.getReference(Supplier.class, orderr.getSupplier().getId());
            if (supplier == null)
                throw new NonexistentEntityException("Поставщик с таким номером " + orderr.getSupplier().getId() 
                        + " не зарегистрирован в БД.");
            orderr.setSupplier(supplier);
            em.persist(orderr);
            if (supplier.getOrders()==null)
                supplier.setOrders(new ArrayList<>());
            List<Orderr> orders = supplier.getOrders();
            orders.add(orderr);
            supplier.setOrders(orders);
            em.merge(supplier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orderr orderr) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        if(findOrderr(orderr.getId())==null)
            throw new NonexistentEntityException("Заказ с таким номером " + orderr.getId() + " не зарегистрирован в БД.");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orderr persistentOrder = em.find(Orderr.class, orderr.getId());
            Supplier supplierOld = persistentOrder.getSupplier();
            Supplier supplierNew = em.getReference(Supplier.class, orderr.getSupplier().getId());
            if(supplierNew==null)
                throw new NonexistentEntityException("Поставщик с таким номером " + orderr.getSupplier().getId() 
                        + " не зарегистрирован в БД.");
            if (!supplierNew.equals(supplierOld)){
                List<Orderr> oldOrders = supplierOld.getOrders();
                oldOrders.remove(persistentOrder);
                supplierOld.setOrders(oldOrders);
                em.merge(supplierOld);
                List<Orderr> newOrders = supplierNew.getOrders();
                newOrders.add(orderr);
                supplierNew.setOrders(newOrders);
                em.merge(supplierNew);
            }
            else {
                List<Orderr> oldOrders = supplierOld.getOrders();
                oldOrders.remove(persistentOrder);
                oldOrders.add(orderr);
                supplierOld.setOrders(oldOrders);
                em.merge(supplierOld);
            }
            orderr.setSupplier(supplierNew);
            em.merge(orderr);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        if(findOrderr(id)==null)
            throw new NonexistentEntityException("Заказ с таким номером " + id + " не зарегистрирован в БД.");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orderr order = em.getReference(Orderr.class, id);
            Supplier supplier = order.getSupplier();
            List<Orderr> orders = supplier.getOrders();
            orders.remove(order);
            supplier.setOrders(orders);
            em.merge(supplier);
            em.remove(order);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orderr> findOrderrEntities() {
        return findOrderrEntities(true, -1, -1);
    }

    public List<Orderr> findOrderrEntities(int maxResults, int firstResult) {
        return findOrderrEntities(false, maxResults, firstResult);
    }

    private List<Orderr> findOrderrEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orderr.class));
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

    public Orderr findOrderr(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orderr.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderrCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orderr> rt = cq.from(Orderr.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
