package com.cookcamp.metier;

import com.cookcamp.entite.Choix;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import com.cookcamp.entite.Promotion;
import com.cookcamp.entite.Type;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionAffichageClient implements GestionAffichageClientLocal {
    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;
    
    
    @Override
    public List<Type> getType(){
        Query qr = em.createNamedQuery("com.cookcamp.entite.Type.findAllTypes");
        List<Type> listeTypes = qr.getResultList();
        return listeTypes;
    }
    
    
    @Override
    public List<Menu> getMenus(){
        Query qr = em.createNamedQuery("com.cookcamp.entite.Menu.findAllMenus");
        List<Menu> listeMenus = qr.getResultList();
        return listeMenus;
    }
    
    
    @Override
    public List<Produit> getProduitsbyType(String nomType){
        Query qr = em.createNamedQuery("com.cookcamp.entite.Produit.findProduitByType");
        qr.setParameter("paramType", nomType);
        List<Produit> listeProduits = qr.getResultList();
        return listeProduits;
    }
    
    
    @Override
    public Produit getProduitbyId(Long id){
        Produit monProduit = em.find(Produit.class, id);
        //Produit monProduit = (Produit) qr.getSingleResult();
        System.out.println("Mon produit : "+monProduit.getNom()+" "+monProduit.getType());
        return monProduit;
    }
    
    @Override
    public List<Choix> getChoixByPromo(){
        Date d = new GregorianCalendar().getTime();
        Query qr = em.createQuery("select p.mesChoix from Promotion p where p.dateDebut<:paramDate and p.dateFin>:paramDate");
        qr.setParameter("paramDate", d);
        List<Choix> listeChoix = qr.getResultList();
        return listeChoix;
    }

    @Override
    public void persist(Object object) {
        em.persist(object);
    }
    
    
}

