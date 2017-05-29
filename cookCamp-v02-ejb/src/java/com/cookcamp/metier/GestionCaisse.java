package com.cookcamp.metier;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Paiement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionCaisse implements GestionCaisseLocal {
    

    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;

    @Override
    public List<Emplacement> findAllCommande() {
        List<Emplacement> results = new ArrayList();

       Query query = em.createNamedQuery("FindCommandes");
        if (!query.getResultList().isEmpty()) {
            results = query.getResultList();
        }

        return results;
    }

    @Override
    public List<LignedeCommandeProduit> findCommandeById(String numCo) {
        List<LignedeCommandeProduit> ldpc = new ArrayList();
        Query query = em.createNamedQuery("FindCommandeById");
        
        query.setParameter("numCo", Long.valueOf(numCo));
        ldpc = query.getResultList();
        return ldpc;
    }


    @Override
    public LignedeCommandeProduit findLigneProduits(long idLigneCommande) {
        return em.find(LignedeCommandeProduit.class, idLigneCommande);
    }
    public Paiement ValiderPaiement(String idCo){
//        Commande c=new Commande();
        Date d=new java.sql.Date(System.currentTimeMillis());
        Query query01 =em.createNamedQuery("FindOnlyCommandeId");
        
        query01.setParameter("numCo",Long.valueOf(idCo));
        System.out.println("#######dans gestion caisse validerPaiement ");
        Commande c=(Commande) query01.getSingleResult();
       
        //Query query=em.createQuery("INSERT INTO Paiement (datePaiement,Commande.id) VALUES(:d,:commande)");
        
        Paiement p =new Paiement(d,c);
        em.persist(p);
        
        
//        query.setParameter("d", d);
//        query.setParameter("commande",idCo);
        
        //Paiement p=(Paiement) query.getSingleResult();
        return p;
    }

}
