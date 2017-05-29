package com.cookcamp.metier;

import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Paiement;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionCaisseLocal {

    public List<Emplacement> findAllCommande();

    public List<LignedeCommandeProduit> findCommandeById(String numCo);

    public LignedeCommandeProduit findLigneProduits(long idLigneCommande);

    public Paiement ValiderPaiement(String idCo);

}
