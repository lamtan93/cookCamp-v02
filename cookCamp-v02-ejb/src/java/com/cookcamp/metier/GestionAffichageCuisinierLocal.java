/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cookcamp.metier;

import com.cookcamp.entite.Commande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fetah54
 */
@Local
public interface GestionAffichageCuisinierLocal {

    public List<Commande> afficherCommandeEnCours();

    public Commande modifierEtat(String id, String etat);
    
}
