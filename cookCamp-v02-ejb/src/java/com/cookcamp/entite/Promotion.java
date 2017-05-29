package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private float remise;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFin;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDebut;

    @ManyToMany(mappedBy = "promotions")
    private Collection<Choix> mesChoix;

    public Promotion() {
        mesChoix = new ArrayList<Choix>();
        
    }

    public Promotion(float remise, Date dateFin, Date dateDebut) {
        this();
        this.remise = remise;
        this.dateFin = dateFin;
        this.dateDebut = dateDebut;
    }
    
    

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Collection<Choix> getMesChoix() {
        return mesChoix;
    }

    public void setMesChoix(Collection<Choix> mesChoix) {
        this.mesChoix = mesChoix;
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
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
