/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name="material")
public class Material implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_mat;

    @Column(name="title")
    private String title;
    
    @Column(name="specification")
    private String specification;
    
    @Column(name="measure")
    private String measure;
    
    @Column(name="volume")
    private Float volume;
    
    @Column(name="weight")
    private Float weight;

    @Column(name="unitStorageCost")
    private Integer unitStorageCost;
    
    @OneToMany(mappedBy="material", fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
    protected List<Supplier> suppliers;
    
    @OneToMany(mappedBy="material", fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
    protected List<Storage> storage;
    
    public Material() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
    
    
    public Long getId() {
        return id_mat;
    }

    public void setId(Long id) {
        this.id_mat = id;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Storage> getStorage() {
        return storage;
    }

    public void setStorage(List<Storage> storage) {
        this.storage = storage;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getUnitStorageCost() {
        return unitStorageCost;
    }

    public void setUnitStorageCost(Integer unitStorageCost) {
        this.unitStorageCost = unitStorageCost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_mat != null ? id_mat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (!Objects.equals(this.id_mat, other.id_mat)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    
    /*@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }*/


    @Override
    public String toString() {
        return "Material{" + "id=" + id_mat + ", title=" + title + ", measure=" + measure + ", volume=" + volume + ", weight=" + weight + ", suppliers=" + suppliers + '}';
    }

    
    
}
