package com.cookcamp.metier;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.LigneCommandeMenu;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionAffichageServeur implements GestionAffichageServeurLocal {

    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;


    @Override
    public List<Commande> getCommande() {
        Query qr = em.createNamedQuery("com.cookcamp.entite.Commande.findAllCommande");
        List<Commande> listeCommande = qr.getResultList();
        return listeCommande;
    }

    @Override
    public List<Emplacement> findAllCommande() {
        List<Emplacement> results = new ArrayList();
        Query query = em.createNamedQuery("com.cookcamp.entite.Commande.FindCommandes");
        if (!query.getResultList().isEmpty()) {
            results = query.getResultList();
        }

        return results;
    }

    @Override
    public List<LignedeCommandeProduit> findLdcpByCommandeId(String numCom) {
        Query query = em.createQuery("SELECT c.ldcp FROM Commande c WHERE c.id=:numCom");
        query.setParameter("numCom", Long.valueOf(numCom));
        List<LignedeCommandeProduit> ldpc = query.getResultList();
        return ldpc;
    }

    

    @Override
    public Produit findProduitByLdcpId(String numLdcp) {
        Query query = em.createQuery("SELECT ldcp.produit FROM LignedeCommandeProduit ldcp WHERE ldcp.id=:numLdcp");
        query.setParameter("numLdcp", numLdcp);
        Produit p = (Produit) query.getSingleResult();
        return p;
    }   
    
   
  
    @Override
    public Collection<Produit> findProduitLdcpByCommandeId(Long IdCmdeProduit) {
        Query query = em.createQuery("SELECT ldcp.produit FROM LignedeCommandeProduit ldcp WHERE ldcp.commande.id=:IdCmdeProduit");
        query.setParameter("IdCmdeProduit", IdCmdeProduit);
        Collection<Produit> produits = query.getResultList();
        return produits;
    }
    

   
    @Override
    public Collection<Produit> findProduitLdcmByCommandeId(Long IdCdeMenu) {
        Query query = em.createQuery("SELECT ldcm.produit FROM LigneCommandeMenu ldcm WHERE ldcm.commande.id=:IdCmde");
//        query.setParameter("numCdeMenu", Long.valueOf(numCdeMenu));
        query.setParameter("IdCdeMenu", IdCdeMenu);
        Collection<Produit> produits = query.getResultList();
        return produits;
    }
    
  
    @Override
    public Collection<Menu> findMenuLdcmByCommandeId (Long IdCmdeMenu){
        Query query = em.createQuery("SELECT ldcm.menu FROM LigneCommandeMenu ldcm WHERE ldcm.commande.id=:IdCmdeMenu");
        query.setParameter("IdCmdeMenu", IdCmdeMenu);
        Collection<Menu> menus = query.getResultList();
        return menus;       
    }
       
            }



