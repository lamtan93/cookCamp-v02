package com.cookcamp.entite;

import com.cookcamp.entite.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Type.class)
public class Type_ { 

    public static volatile CollectionAttribute<Type, Produit> produits;
    public static volatile SingularAttribute<Type, Long> id;
    public static volatile SingularAttribute<Type, String> nom;

}