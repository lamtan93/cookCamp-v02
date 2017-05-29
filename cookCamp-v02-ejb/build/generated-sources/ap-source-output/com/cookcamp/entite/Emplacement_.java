package com.cookcamp.entite;

import com.cookcamp.entite.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Emplacement.class)
public class Emplacement_ { 

    public static volatile CollectionAttribute<Emplacement, Commande> commandes;
    public static volatile SingularAttribute<Emplacement, Integer> capacite;
    public static volatile SingularAttribute<Emplacement, String> numero;
    public static volatile SingularAttribute<Emplacement, String> etat;

}