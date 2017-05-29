package com.cookcamp.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paiement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idPaiement;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<TypePaiement> typePaiements;
    @OneToOne
      private Commande commande;
    
    
    public Paiement ()
    {
        typePaiements = new ArrayList<>();
    }

    public Paiement(Date datePaiement) {
        this();
        this.datePaiement = datePaiement;
      
    }

    public Paiement(Date datePaiement, Commande commande) {
        this.datePaiement = datePaiement;
        this.commande = commande;
    }
    

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Collection<TypePaiement> getTypePaiements() {
        return typePaiements;
    }

    public void setTypePaiements(Collection<TypePaiement> typePaiements) {
        this.typePaiements = typePaiements;
    }

    public Long getIdPaiement() {
        return idPaiement;
    }

     public void setIdPaiement(Long idPaiement) {
        this.idPaiement = idPaiement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaiement != null ? idPaiement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idPaiement fields are not set
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.idPaiement == null && other.idPaiement != null) || (this.idPaiement != null && !this.idPaiement.equals(other.idPaiement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "date Paiement: "+ this.datePaiement;
    }
    
}
