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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Orderr")
public class Orderr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ord;

    public Orderr() {
    }

    
    public Long getId() {
        return id_ord;
    }

    public void setId(Long id) {
        this.id_ord = id;
    }

    @Column(name = "sign_date")
    @Temporal(TemporalType.DATE)
    private Date signDate;
    
    @Column(name = "exec_date")
    @Temporal(TemporalType.DATE)
    private Date execDate;
    
    @Column(name = "totalVolume")
    private Integer totalVolume;
    
    @Column(name = "totalCost")
    private Integer totalCost;
    
    @Column(name = "isCompleted")
    private String isCompleted;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sup", nullable = false)
    protected Supplier supplier;

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    public Integer getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Integer totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_ord != null ? id_ord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderr)) {
            return false;
        }
        Orderr other = (Orderr) object;
        if ((this.id_ord == null && other.id_ord != null) || (this.id_ord != null && !this.id_ord.equals(other.id_ord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orderr{" + "id=" + id_ord + ", signDate=" + signDate + ", execDate=" + execDate + ", totalVolume=" + totalVolume + ", totalCost=" + totalCost + ", supplier=" + supplier + '}';
    }
    
    
    
}
