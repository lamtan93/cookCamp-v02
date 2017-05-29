package com.cookcamp.entite;

import com.cookcamp.entite.LigneCommandeMenu;
import com.cookcamp.entite.LignedeCommandeProduit;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(DemandeParticuliere.class)
public class DemandeParticuliere_ { 

    public static volatile SingularAttribute<DemandeParticuliere, LigneCommandeMenu> ligneCommandeMenu;
    public static volatile SingularAttribute<DemandeParticuliere, Long> id;
    public static volatile SingularAttribute<DemandeParticuliere, String> type;
    public static volatile SingularAttribute<DemandeParticuliere, LignedeCommandeProduit> lignedeCommandeProduit;

}