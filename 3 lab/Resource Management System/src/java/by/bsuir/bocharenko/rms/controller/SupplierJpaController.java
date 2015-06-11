/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.controller;

import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import by.bsuir.bocharenko.rms.entity.Material;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author user
 */
public class SupplierJpaController implements Serializable {

    public SupplierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Supplier supplier) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Material material = em.getReference(Material.class, supplier.getMaterial().getId());
            if (material == null)
                throw new NonexistentEntityException("Материал с таким номером " + supplier.getMaterial().getId() + " не зарегистрирован в БД.");
            material = em.getReference(Material.class, material.getId());
            supplier.setMaterial(material);
            em.persist(supplier);
            List<Supplier> suppliers = material.getSuppliers();
            suppliers.add(supplier);
            material.setSuppliers(suppliers);
            em.merge(material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Supplier supplier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        if (findSupplier(supplier.getId()) == null)
            throw new NonexistentEntityException("Поставщик с таким номером " + supplier.getId() 
                    + " не зарегестрирован в БД");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //Изменяется родительская сущность Материал
            Supplier persistentSupplier = em.find(Supplier.class, supplier.getId());
            Material materialOld = persistentSupplier.getMaterial();
            Material materialNew = em.find(Material.class, supplier.getMaterial().getId());
            if(materialNew==null)
                throw new NonexistentEntityException("Материал с таким номером " + supplier.getMaterial().getId() 
                        + " не зарегистрирован в БД.");
            if (!materialNew.equals(materialOld)){
                List<Supplier> oldSuppliers = materialOld.getSuppliers();
                oldSuppliers.remove(persistentSupplier);
                materialOld.setSuppliers(oldSuppliers);
                em.merge(materialOld);
                List<Supplier> newSuppliers = materialNew.getSuppliers();
                newSuppliers.add(supplier);
                materialNew.setSuppliers(newSuppliers);
                em.merge(materialNew);
            }
            else {
                List<Supplier> oldSuppliers = materialOld.getSuppliers();
                oldSuppliers.remove(persistentSupplier);
                oldSuppliers.add(supplier);
                materialOld.setSuppliers(oldSuppliers);
                em.merge(materialOld);
            }
            supplier.setMaterial(materialNew);
            //Каскадно изменяются заказы данного поставщика
            List<Orderr> ordersOld = persistentSupplier.getOrders();
            List<Orderr> ordersNew = new ArrayList();
            if(ordersOld!=null){
                for (Orderr oldOrder : ordersOld) {
                    oldOrder.setSupplier(supplier);
                    em.merge(oldOrder);
                    ordersNew.add(oldOrder);
                }
            }   
            supplier.setOrders(ordersNew);
            em.merge(supplier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        if(findSupplier(id)==null)
            throw new NonexistentEntityException("Поставщик с таким номером " + id
                    + " не зарегестрирован в БД");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //Редактирование родительской сущности Material
            Supplier supplier = em.getReference(Supplier.class, id);
            Material material = supplier.getMaterial();
            List<Supplier> suppliers = material.getSuppliers();
            suppliers.remove(supplier);
            material.setSuppliers(suppliers);
            em.merge(material);
            
            //Удаление заказов-сирот
            List<Orderr> orphanOrders = supplier.getOrders();
            if(orphanOrders!=null)
                for(Orderr ord : orphanOrders){
                    em.remove(ord);
                }
            em.remove(supplier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Supplier> findSupplierEntities() {
        return findSupplierEntities(true, -1, -1);
    }

    public List<Supplier> findSupplierEntities(int maxResults, int firstResult) {
        return findSupplierEntities(false, maxResults, firstResult);
    }

    private List<Supplier> findSupplierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Supplier.class));
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

    public Supplier findSupplier(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Supplier.class, id);
        } finally {
            em.close();
        }
    }

    public int getSupplierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Supplier> rt = cq.from(Supplier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
