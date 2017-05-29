/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookcamp.metier;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.LigneCommandeMenu;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GestionAffichageServeurLocal {
    
//    public List<LigneCommandeMenu> getLigneCommandeMenu();
//
//    public List<LignedeCommandeProduit> getLigneCommandeProduit();
//    
//    public Commande getCommandeById(Long id);
  
    public List<Commande> getCommande();
    
    public List<Emplacement> findAllCommande();

    
//    
//    public List<LigneCommandeMenu> getLigneCmdMenuByCommande(Commande commande);
//
//    public List<LignedeCommandeProduit> getLigneCmdProduitByCommande(Commande commande);

//    public List<LigneCommandeMenu> findLdcmByCommandeId(String numCdeMenu);

    public List<LignedeCommandeProduit> findLdcpByCommandeId(String numCom);

    public Produit findProduitByLdcpId(String numLdcp);

    
    public Collection<Produit> findProduitLdcpByCommandeId(Long IdCmdeProduit);

    public Collection<Menu> findMenuLdcmByCommandeId(Long IdCmdeMenu);

    public Collection<Produit> findProduitLdcmByCommandeId(Long IdCdeMenu);

  

  

  

   

   

  

   

    


    

    
}
