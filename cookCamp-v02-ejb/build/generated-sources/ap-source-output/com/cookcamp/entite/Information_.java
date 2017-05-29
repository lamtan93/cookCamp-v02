package com.cookcamp.entite;

import com.cookcamp.entite.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Information.class)
public class Information_ { 

    public static volatile ListAttribute<Information, Produit> produits;
    public static volatile SingularAttribute<Information, String> valeur;
    public static volatile SingularAttribute<Information, Long> id;
    public static volatile SingularAttribute<Information, String> nom;

}