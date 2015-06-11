/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
public class Storage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_mat", nullable = false)
    protected Material material;
    
    @Column(name="numberOfMaterialUnits")
    private Integer numberOfMaterialUnits;
    
    @Column(name="totalVolumeOfMaterial")
    private Float totalVolumeOfMaterial;

    @Column(name="receiptDate")
    @Temporal(TemporalType.DATE)
    private Date receiptDate;
    
    public Storage() {
    }
    
    public Long getId() {
        return id;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getNumberOfMaterialUnits() {
        return numberOfMaterialUnits;
    }

    public void setNumberOfMaterialUnits(Integer numberOfMaterialUnits) {
        this.numberOfMaterialUnits = numberOfMaterialUnits;
    }

    public Float getTotalVolumeOfMaterial() {
        return totalVolumeOfMaterial;
    }

    public void setTotalVolumeOfMaterial(Float totalVolumeOfMaterial) {
        this.totalVolumeOfMaterial = totalVolumeOfMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Storage{" + "id=" + id + ", material=" + material + ", numberOfMaterialUnits=" + numberOfMaterialUnits + ", totalVolumeOfMaterial=" + totalVolumeOfMaterial + '}';
    }


    
}
