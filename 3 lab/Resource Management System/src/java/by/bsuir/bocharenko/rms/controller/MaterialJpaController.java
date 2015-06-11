/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.controller;

import by.bsuir.bocharenko.rms.controller.exceptions.NonexistentEntityException;
import by.bsuir.bocharenko.rms.entity.Material;
import by.bsuir.bocharenko.rms.entity.Orderr;
import by.bsuir.bocharenko.rms.entity.Storage;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import by.bsuir.bocharenko.rms.entity.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author user
 */
public class MaterialJpaController implements Serializable {

    public MaterialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Material material) {
        if (material.getSuppliers() == null) {
            material.setSuppliers(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Material material) throws NonexistentEntityException{
        EntityManager em = null;
        if(findMaterial(material.getId())==null)
            throw new NonexistentEntityException("Материал с таким номером " + material.getId() + " не зарегистрирован в БД.");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Material persistentMaterial = em.find(Material.class, material.getId());
            List<Supplier> suppliersOld = persistentMaterial.getSuppliers();
            List<Supplier> suppliersNew = new ArrayList();
            if(suppliersOld!=null){
                for (Supplier oldSup : suppliersOld) {
                    oldSup.setMaterial(material);
                    em.merge(oldSup);
                    suppliersNew.add(oldSup);
                }   
            }
            material.setSuppliers(suppliersNew);
            
            List<Storage> storageOld = persistentMaterial.getStorage();
            List<Storage> storageNew = new ArrayList();
            if(storageOld!=null){
                for (Storage oldstorage : storageOld) {
                    oldstorage.setMaterial(material);
                    em.merge(oldstorage);
                    storageNew.add(oldstorage);
                }   
            }
            material.setStorage(storageNew);
            em.merge(material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        if(findMaterial(id)==null)
            throw new NonexistentEntityException("Материал с таким номером " + id + " не зарегистрирован в БД.");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Material material;
            material = em.getReference(Material.class, id);
            List<Supplier> orphanSuppliers = material.getSuppliers();
            if(orphanSuppliers!=null){
                for(Supplier orphanSup : orphanSuppliers){
                    List<Orderr> orphanOrders = orphanSup.getOrders();
                    if(orphanOrders!=null)
                        for(Orderr orphanOrd : orphanOrders)
                            em.remove(orphanOrd);
                    em.remove(orphanSup);
                }
            }
            
            List<Storage> orphanStorages = material.getStorage();
            if(orphanStorages!=null){
                for(Storage orphanStorage : orphanStorages)
                    em.remove(orphanStorage);
            }
            
            em.remove(material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Material> findMaterialEntities() {
        return findMaterialEntities(true, -1, -1);
    }

    public List<Material> findMaterialEntities(int maxResults, int firstResult) {
        return findMaterialEntities(false, maxResults, firstResult);
    }

    private List<Material> findMaterialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Material.class));
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

    public Material findMaterial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Material.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Material> rt = cq.from(Material.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
