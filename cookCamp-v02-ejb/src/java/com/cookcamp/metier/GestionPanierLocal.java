/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookcamp.metier;

import Outil.CustomException;
import Transient.LigneDePanierMenu;
import Transient.LigneDePanierProduit;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author cdi108
 */
@Local
public interface GestionPanierLocal {

    public Produit vérifierProduit(Long idProduit) throws CustomException;

    public void ajouterProduit(Long idProduit) throws CustomException;

   

    public void ajouterProduitClient(Long idProduit) throws CustomException;

    public void plusQuantiteProduit(Long idProduit) throws CustomException;

    public void plusQuantiteProduitClient(Long idProduit) throws CustomException;

    public void minusQuantiteProduit(Long idProduit) throws CustomException;

    public void minusQuantiteProduitClient(Long idProduit) throws CustomException;

    public Collection<LigneDePanierProduit> getPanier();

    public Collection<LigneDePanierProduit> getPanierClient();

    public float getPrixTotal();

    public float getPrixTotalClient();

    public void deleteLignePanier(Long idProduit) throws CustomException;

    public void deleteLignePanierClient(Long idProduit) throws CustomException;

    public void addHashMapTotalServeur(String numeroEmplacement) throws CustomException;

    public Collection<LigneDePanierProduit> getProduitParTableServeur(String numeroTable) throws CustomException;

    public void addHashMapTotalClient(String numeroEmplacement) throws CustomException;

    public Collection<LigneDePanierProduit> getProduitParTableClient(String numeroTable) throws CustomException;

    public Collection<LigneDePanierMenu> getMenuClient();

    public void ajouterMenuClient(Long idMenu) throws CustomException;

    public void deleteLignePanierMenuClient(Long idMenu) throws CustomException;

    public void plusQuantiteMenuClient(Long idMenu) throws CustomException;

    public void minusQuantiteMenuClient(Long idMenu) throws CustomException;

  

   

    



  

  
    
}
