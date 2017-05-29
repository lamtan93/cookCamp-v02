package com.cookcamp.entite;

import com.cookcamp.entite.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Ingredient.class)
public class Ingredient_ { 

    public static volatile ListAttribute<Ingredient, Produit> produits;
    public static volatile SingularAttribute<Ingredient, Long> id;
    public static volatile SingularAttribute<Ingredient, String> origine;
    public static volatile SingularAttribute<Ingredient, String> nom;

}