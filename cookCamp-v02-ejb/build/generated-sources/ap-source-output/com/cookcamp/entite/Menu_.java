package com.cookcamp.entite;

import com.cookcamp.entite.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Menu.class)
public class Menu_ extends Choix_ {

    public static volatile CollectionAttribute<Menu, Produit> produits;
    public static volatile SingularAttribute<Menu, String> typeMoment;

}