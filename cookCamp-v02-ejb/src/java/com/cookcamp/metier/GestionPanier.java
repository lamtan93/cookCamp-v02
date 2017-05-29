package com.cookcamp.metier;

import Outil.CustomException;
import Transient.LigneDePanierMenu;
import Transient.LigneDePanierProduit;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionPanier implements GestionPanierLocal {

    @EJB
    private GestionEmplacementLocal gestionEmplacement;

    @PersistenceContext(unitName = "cookCamp-v02-ejbPU")
    private EntityManager em;

    private HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierProduit>>> hashMapTotalServeur;
    private HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierProduit>>> hashMapTotalClient;
    private ArrayList<HashMap<Long, LigneDePanierProduit>> arrayMapServeur;
    private ArrayList<HashMap<Long, LigneDePanierProduit>> arrayMapClient;

    private HashMap<Long, LigneDePanierProduit> hashMapContenueServeur;
    private HashMap<Long, LigneDePanierProduit> hashMapContenueClient;

    //-------------Menu---------------------
    private HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierMenu>>> hashMapTotalMenuClient;
    ArrayList<HashMap<Long, LigneDePanierMenu>> arrayMenuClient;
    private HashMap<Long, LigneDePanierMenu> hashMapContenueMenuClient;

    //HashMap01<Emplacement,ArrayList<HashMap02>>
    //HashMap02<Long,LigneDePanierProduit>
    public GestionPanier() {
        hashMapTotalServeur = new HashMap<>();
        hashMapTotalClient = new HashMap<>();
        arrayMapServeur = new ArrayList<>();
        arrayMapClient = new ArrayList<>();
        hashMapContenueServeur = new HashMap<>();
        hashMapContenueClient = new HashMap<>();
        //------------Menu--------------
        hashMapTotalMenuClient = new HashMap<>();
        arrayMenuClient = new ArrayList<>();
        hashMapContenueMenuClient = new HashMap<>();

    }

    public GestionEmplacementLocal getGestionEmplacement() {
        return gestionEmplacement;
    }

    public void setGestionEmplacement(GestionEmplacementLocal gestionEmplacement) {
        this.gestionEmplacement = gestionEmplacement;
    }

    public HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierProduit>>> getHashMapTotalServeur() {
        return hashMapTotalServeur;
    }

    public void setHashMapTotalServeur(HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierProduit>>> hashMapTotalServeur) {
        this.hashMapTotalServeur = hashMapTotalServeur;
    }

    public HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierProduit>>> getHashMapTotalClient() {
        return hashMapTotalClient;
    }

    public void setHashMapTotalClient(HashMap<Emplacement, ArrayList<HashMap<Long, LigneDePanierProduit>>> hashMapTotalClient) {
        this.hashMapTotalClient = hashMapTotalClient;
    }

    public ArrayList<HashMap<Long, LigneDePanierProduit>> getArrayMapServeur() {
        return arrayMapServeur;
    }

    public void setArrayMapServeur(ArrayList<HashMap<Long, LigneDePanierProduit>> arrayMapServeur) {
        this.arrayMapServeur = arrayMapServeur;
    }

    public ArrayList<HashMap<Long, LigneDePanierProduit>> getArrayMapClient() {
        return arrayMapClient;
    }

    public void setArrayMapClient(ArrayList<HashMap<Long, LigneDePanierProduit>> arrayMapClient) {
        this.arrayMapClient = arrayMapClient;
    }

    public HashMap<Long, LigneDePanierProduit> getHashMapContenueServeur() {
        return hashMapContenueServeur;
    }

    public void setHashMapContenueServeur(HashMap<Long, LigneDePanierProduit> hashMapContenueServeur) {
        this.hashMapContenueServeur = hashMapContenueServeur;
    }

    public HashMap<Long, LigneDePanierProduit> getHashMapContenueClient() {
        return hashMapContenueClient;
    }

    public void setHashMapContenueClient(HashMap<Long, LigneDePanierProduit> hashMapContenueClient) {
        this.hashMapContenueClient = hashMapContenueClient;
    }

    @Override
    public Produit vérifierProduit(Long idProduit) throws CustomException {
        String jpql = "Select p from Produit p Where p.id=:idProduit";
        Query query = em.createQuery(jpql);
        query.setParameter("idProduit", idProduit);
        try {
            Produit produit = (Produit) query.getSingleResult();
            return produit;
        } catch (NoResultException ne) {
            HashMap<String, String> mapErreur = new HashMap<>();
            mapErreur.put("problemePanier", "Produit n'existe pas !");
            throw new CustomException(CustomException.PROBLEME_PANIER, mapErreur);

        }

    }

    public Menu vérifierMenu(Long idMenu) throws CustomException {
        String jpql = "Select m from Menu m Where m.id=:idMenu";
        Query query = em.createQuery(jpql);
        query.setParameter("idMenu", idMenu);
        try {
            Menu menu =  (Menu) query.getSingleResult();
            return menu;
        } catch (NoResultException ne) {
            HashMap<String, String> mapErreur = new HashMap<>();
            mapErreur.put("problemePanier", "Menu n'existe pas !");
            throw new CustomException(CustomException.PROBLEME_PANIER, mapErreur);

        }
    }

    @Override
    public void ajouterMenuClient(Long idMenu) throws CustomException {
        Menu menu = vérifierMenu(idMenu);

        if (hashMapContenueMenuClient.containsKey(menu.getId())) {

            hashMapContenueMenuClient.get(menu.getId()).setQuantite(hashMapContenueMenuClient.get(menu.getId()).getQuantite() + 1);

            
        } else {
            LigneDePanierMenu lp = new LigneDePanierMenu(menu);
            hashMapContenueMenuClient.put(idMenu, lp);
            arrayMenuClient.add(hashMapContenueMenuClient);//Test HashMapTotal avec table
        }
    }
    
//    public void AjouterProduit()
//    {
//        List<Produit> listProduits = new ArrayList<>();
//        
//    }

    @Override
    public void ajouterProduit(Long idProduit) throws CustomException {
        Produit produit = vérifierProduit(idProduit);

        if (hashMapContenueServeur.containsKey(produit.getId())) {
            if (hashMapContenueServeur.get(produit.getId()).getQuantite() < hashMapContenueServeur.get(produit.getId()).getProduit().getStock()) {

                hashMapContenueServeur.get(produit.getId()).setQuantite(hashMapContenueServeur.get(produit.getId()).getQuantite() + 1);
            } else {
                HashMap<String, String> hashMapErreur = new HashMap<>();
                hashMapErreur.put("problemePanier", "Quantité insuffisante !");
                throw new CustomException(CustomException.PROBLEME_PANIER, hashMapErreur);

            }

        } else {
            LigneDePanierProduit lp = new LigneDePanierProduit(produit);
            hashMapContenueServeur.put(idProduit, lp);
            arrayMapServeur.add(hashMapContenueServeur);//Test HashMapTotal avec table
        }

    }
    //-----------Client-----------

    @Override
    public void ajouterProduitClient(Long idProduit) throws CustomException {
        Produit produit = vérifierProduit(idProduit);

        if (hashMapContenueClient.containsKey(produit.getId())) {
            if (hashMapContenueClient.get(produit.getId()).getQuantite() < hashMapContenueClient.get(produit.getId()).getProduit().getStock()) {

                hashMapContenueClient.get(produit.getId()).setQuantite(hashMapContenueClient.get(produit.getId()).getQuantite() + 1);
            } else {
                HashMap<String, String> hashMapErreur = new HashMap<>();
                hashMapErreur.put("problemePanier", "Quantité insuffisante !");
                throw new CustomException(CustomException.PROBLEME_PANIER, hashMapErreur);

            }

        } else {
            LigneDePanierProduit lp = new LigneDePanierProduit(produit);
            hashMapContenueClient.put(idProduit, lp);
            arrayMapClient.add(hashMapContenueClient);//Test HashMapTotal avec table
        }

    }
    //----------------------------

    @Override
    public void plusQuantiteProduit(Long idProduit) throws CustomException {
        Produit produit = vérifierProduit(idProduit);
        LigneDePanierProduit lp = hashMapContenueServeur.get(produit.getId());
        if (lp.getQuantite() < lp.getProduit().getStock()) {
            lp.setQuantite(lp.getQuantite() + 1);
        } else {
            try {
                lp.setQuantite(lp.getQuantite());
            } catch (Exception e) {
                HashMap<String, String> hashMapErreur = new HashMap<>();
                hashMapErreur.put("problemePanier", "Produit insuffisant !");
                throw new CustomException(CustomException.PROBLEME_PANIER, hashMapErreur);
            }

        }

    }

    @Override
    public void plusQuantiteProduitClient(Long idProduit) throws CustomException {
        Produit produit = vérifierProduit(idProduit);
        LigneDePanierProduit lp = hashMapContenueClient.get(produit.getId());
        if (lp.getQuantite() < lp.getProduit().getStock()) {
            lp.setQuantite(lp.getQuantite() + 1);
        } else {
            try {
                lp.setQuantite(lp.getQuantite());
            } catch (Exception e) {
                HashMap<String, String> hashMapErreur = new HashMap<>();
                hashMapErreur.put("problemePanier", "Produit insuffisant !");
                throw new CustomException(CustomException.PROBLEME_PANIER, hashMapErreur);
            }

        }

    }
    
    
    @Override
     public void plusQuantiteMenuClient(Long idMenu) throws CustomException {
        Menu menu = vérifierMenu(idMenu);
        LigneDePanierMenu lp = hashMapContenueMenuClient.get(menu.getId());
        
            lp.setQuantite(lp.getQuantite() + 1);
       

        

    }

    @Override
    public void minusQuantiteProduit(Long idProduit) throws CustomException {

        Produit produit = vérifierProduit(idProduit);
        LigneDePanierProduit lp = hashMapContenueServeur.get(produit.getId());
        if (lp.getQuantite() > 1) {
            lp.setQuantite(lp.getQuantite() - 1);
        } else {
            hashMapContenueServeur.remove(produit.getId());
        }

    }

    @Override
    public void minusQuantiteProduitClient(Long idProduit) throws CustomException {

        Produit produit = vérifierProduit(idProduit);
        LigneDePanierProduit lp = hashMapContenueClient.get(produit.getId());
        if (lp.getQuantite() > 1) {
            lp.setQuantite(lp.getQuantite() - 1);
        } else {
            hashMapContenueClient.remove(produit.getId());
        }

    }
    
    @Override
     public void minusQuantiteMenuClient(Long idMenu) throws CustomException {

        Menu menu = vérifierMenu(idMenu);
        LigneDePanierMenu lp = hashMapContenueMenuClient.get(menu.getId());
        if (lp.getQuantite() > 1) {
            lp.setQuantite(lp.getQuantite() - 1);
        } else {
            hashMapContenueMenuClient.remove(menu.getId());
        }

    }

    @Override
    public Collection<LigneDePanierProduit> getPanier() {
        return hashMapContenueServeur.values();

    }

    @Override
    public Collection<LigneDePanierProduit> getPanierClient() {
        return hashMapContenueClient.values();

    }
    @Override
    public Collection<LigneDePanierMenu> getMenuClient()
    {
        return hashMapContenueMenuClient.values();
    }

    @Override
    public float getPrixTotal() {
        float prixProduit = 0;
        
        Collection<LigneDePanierProduit> collecPanier = hashMapContenueServeur.values();
        for (LigneDePanierProduit collec : collecPanier) {
            prixProduit += collec.getPrixLignePanier();

        }
        
        return prixProduit;

    }

    @Override
    public float getPrixTotalClient() {
        float prixProduit = 0;
        float prixMenu = 0;
        Collection<LigneDePanierProduit> collecPanier = hashMapContenueClient.values();
        for (LigneDePanierProduit collec : collecPanier) {
            prixProduit += collec.getPrixLignePanier();

        }
        
        Collection<LigneDePanierMenu> collecPanierMenu = hashMapContenueMenuClient.values();
        for (LigneDePanierMenu collec1 : collecPanierMenu) {
            prixMenu += collec1.getPrixLignePanier();
        }
        
        float prixTotal = prixProduit+prixMenu;
        
        
        
        return prixTotal;

    }

    @Override
    public void deleteLignePanier(Long idProduit) throws CustomException {
        Produit produit = vérifierProduit(idProduit);

        if (hashMapContenueServeur.containsKey(produit.getId())) {

            hashMapContenueServeur.remove(produit.getId());
        }

    }

    @Override
    public void deleteLignePanierClient(Long idProduit) throws CustomException {
        Produit produit = vérifierProduit(idProduit);

        if (hashMapContenueClient.containsKey(produit.getId())) {

            hashMapContenueClient.remove(produit.getId());
        }

    }
    
    
    
    public void deleteLignePanierMenuClient(Long idMenu) throws CustomException {
        Menu menu = vérifierMenu(idMenu);

        if (hashMapContenueMenuClient.containsKey(menu.getId())) {

            hashMapContenueMenuClient.remove(menu.getId());
        }

    }
//------------------------------------------------------------------------------
    //1. Set

    @Override
    public void addHashMapTotalServeur(String numeroEmplacement) throws CustomException {
        Emplacement table = gestionEmplacement.verifierEmplacement(numeroEmplacement);
        hashMapTotalServeur.put(table, getArrayMapServeur());

    }

    @Override
    public void addHashMapTotalClient(String numeroEmplacement) throws CustomException {
        Emplacement table = gestionEmplacement.verifierEmplacement(numeroEmplacement);
        hashMapTotalClient.put(table, getArrayMapClient());

    }

    //2. Get produits par table à utiliser en cas de produits non persistés
    @Override
    public Collection<LigneDePanierProduit> getProduitParTableServeur(String numeroTable) throws CustomException {
        Emplacement emplacement = gestionEmplacement.verifierEmplacement(numeroTable);

        ArrayList<HashMap<Long, LigneDePanierProduit>> arrayList = hashMapTotalServeur.get(emplacement.getNumero());
        Collection<LigneDePanierProduit> collec = null;
        for (HashMap<Long, LigneDePanierProduit> array : arrayList) {
            collec = array.values();
            return collec;
        }

        return collec;
    }

    @Override
    public Collection<LigneDePanierProduit> getProduitParTableClient(String numeroTable) throws CustomException {
        Emplacement emplacement = gestionEmplacement.verifierEmplacement(numeroTable);

        ArrayList<HashMap<Long, LigneDePanierProduit>> arrayList = hashMapTotalClient.get(emplacement.getNumero());
        Collection<LigneDePanierProduit> collec = null;
        for (HashMap<Long, LigneDePanierProduit> array : arrayList) {
            collec = array.values();
            return collec;
        }

        return collec;
    }

}
