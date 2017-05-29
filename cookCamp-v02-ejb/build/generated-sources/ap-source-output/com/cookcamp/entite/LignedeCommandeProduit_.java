package com.cookcamp.entite;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.DemandeParticuliere;
import com.cookcamp.entite.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(LignedeCommandeProduit.class)
public class LignedeCommandeProduit_ { 

    public static volatile SingularAttribute<LignedeCommandeProduit, Produit> produit;
    public static volatile SingularAttribute<LignedeCommandeProduit, Float> prix;
    public static volatile CollectionAttribute<LignedeCommandeProduit, DemandeParticuliere> demandeParticulieres;
    public static volatile SingularAttribute<LignedeCommandeProduit, Long> id;
    public static volatile SingularAttribute<LignedeCommandeProduit, Commande> commande;
    public static volatile SingularAttribute<LignedeCommandeProduit, Float> tva;
    public static volatile SingularAttribute<LignedeCommandeProduit, Integer> quantite;

}