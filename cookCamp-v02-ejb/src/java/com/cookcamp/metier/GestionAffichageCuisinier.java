package com.cookcamp.metier;

import com.cookcamp.entite.Commande;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fetah54
 */
@Stateless
public class GestionAffichageCuisinier implements GestionAffichageCuisinierLocal {

    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;

    @Override
    public List<Commande> afficherCommandeEnCours() {
        Query qr = em.createNamedQuery("com.cookcamp.entite.Commande.findCommandeEnCours");
        qr.setParameter("paramEtat", "en cours");
        List<Commande> listeCommandes = qr.getResultList();
        return listeCommandes;
    }
    
    @Override
    public Commande modifierEtat(String id, String etat){
        Long l = Long.valueOf(id);
        Commande c = em.find(Commande.class, l);
        c.setEtat(etat);
        em.persist(c);
        return c;
    }
}
