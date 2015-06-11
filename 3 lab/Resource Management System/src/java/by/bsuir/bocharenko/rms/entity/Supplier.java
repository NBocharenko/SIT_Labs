/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.bocharenko.rms.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_sup;

    @Column(name="title")
    private String title;
    
    @Column(name="deliveryPrice")
    private Integer deliveryPrice;
    
    @Column(name="resourceUnitPrice")
    private Integer resourceUnitPrice;

    @OneToMany(mappedBy="supplier", fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
    protected List<Orderr> orders;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_mat", nullable = false)
    protected Material material;
    
    public Supplier() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getResourceUnitPrice() {
        return resourceUnitPrice;
    }

    public void setResourceUnitPrice(Integer resourceUnitPrice) {
        this.resourceUnitPrice = resourceUnitPrice;
    }
    
    public Long getId() {
        return id_sup;
    }

    public void setId(Long id) {
        this.id_sup = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Orderr> getOrders() {
        return orders;
    }

    public void setOrders(List<Orderr> orders) {
        this.orders = orders;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_sup != null ? id_sup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id_sup == null && other.id_sup != null) || (this.id_sup != null && !this.id_sup.equals(other.id_sup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id_sup + ", title=" + title + ", deliveryPrice=" + deliveryPrice + ", resourceUnitPrice=" + resourceUnitPrice + ", orders=" + orders + ", material=" + material + '}';
    }

    
    
}
