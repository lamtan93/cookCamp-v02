package com.cookcamp.entite;

import com.cookcamp.entite.Promotion;
import com.cookcamp.entite.Tva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Choix.class)
public abstract class Choix_ { 

    public static volatile CollectionAttribute<Choix, Promotion> promotions;
    public static volatile SingularAttribute<Choix, Float> prix;
    public static volatile SingularAttribute<Choix, Long> id;
    public static volatile SingularAttribute<Choix, String> nom;
    public static volatile SingularAttribute<Choix, Tva> tva;

}