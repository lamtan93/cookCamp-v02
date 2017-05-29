package com.cookcamp.entite;

import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.LigneCommandeMenu;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Paiement;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Emplacement> emplacement;
    public static volatile ListAttribute<Commande, LigneCommandeMenu> ldcm;
    public static volatile SingularAttribute<Commande, Paiement> paiement;
    public static volatile ListAttribute<Commande, LignedeCommandeProduit> ldcp;
    public static volatile SingularAttribute<Commande, Long> id;
    public static volatile SingularAttribute<Commande, String> etat;

}