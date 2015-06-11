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
import by.bsuir.bocharenko.rms.entity.Storage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author user
 */
public class StorageJpaController implements Serializable {

    public StorageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Storage storage) throws NonexistentEntityException{
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Material material = em.getReference(Material.class, storage.getMaterial().getId());
            if (material == null)
                throw new NonexistentEntityException("Материал с таким номером " + storage.getMaterial().getId() 
                        + " не зарегистрирован в БД.");
            material = em.getReference(Material.class, material.getId());
            storage.setMaterial(material);
            em.persist(storage);
            
            List<Storage> storages = material.getStorage();
            storages.add(storage);
            material.setStorage(storages);
            em.merge(material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Storage storage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        if (findStorage(storage.getId()) == null)
            throw new NonexistentEntityException("Материал с таким номером " + storage.getId() 
                    + " не зарегестрирован на складе");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //Изменяется родительская сущность Материал
            Storage persistentStorage = em.find(Storage.class, storage.getId());
            Material materialOld = persistentStorage.getMaterial();
            Material materialNew = em.find(Material.class, storage.getMaterial().getId());
            if(materialNew==null)
                throw new NonexistentEntityException("Материал с таким номером " + storage.getMaterial().getId() 
                        + " не зарегистрирован в БД.");
            if (!materialNew.equals(materialOld)){
                List<Storage> oldStorages = materialOld.getStorage();
                oldStorages.remove(persistentStorage);
                materialOld.setStorage(oldStorages);
                em.merge(materialOld);
                List<Storage> newStorages = materialNew.getStorage();
                newStorages.add(storage);
                materialNew.setStorage(newStorages);
                em.merge(materialNew);
            }
            else {
                List<Storage> oldStorages = materialOld.getStorage();
                oldStorages.remove(persistentStorage);
                oldStorages.add(storage);
                materialOld.setStorage(oldStorages);
                em.merge(materialOld);
            }
            storage.setMaterial(materialNew);
            em.merge(storage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        if(findStorage(id)==null)
            throw new NonexistentEntityException("Материал под номером " + id
                    + " не зарегестрирован на складе");
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Storage storage = em.getReference(Storage.class, id);
            Material material = storage.getMaterial();
            List<Storage> storages = material.getStorage();
            storages.remove(storage);
            material.setStorage(storages);
            em.merge(material);
            em.remove(storage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Storage> findStorageEntities() {
        return findStorageEntities(true, -1, -1);
    }

    public List<Storage> findStorageEntities(int maxResults, int firstResult) {
        return findStorageEntities(false, maxResults, firstResult);
    }

    private List<Storage> findStorageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Storage.class));
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

    public Storage findStorage(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Storage.class, id);
        } finally {
            em.close();
        }
    }

    public int getStorageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Storage> rt = cq.from(Storage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
