package com.cookcamp.entite;

import com.cookcamp.entite.Information;
import com.cookcamp.entite.Ingredient;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Type;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Produit.class)
public class Produit_ extends Choix_ {

    public static volatile CollectionAttribute<Produit, Menu> produits;
    public static volatile SingularAttribute<Produit, String> description;
    public static volatile CollectionAttribute<Produit, Ingredient> ingredients;
    public static volatile CollectionAttribute<Produit, Menu> menus;
    public static volatile SingularAttribute<Produit, Integer> stock;
    public static volatile SingularAttribute<Produit, Type> type;
    public static volatile SingularAttribute<Produit, String> urlImage;
    public static volatile CollectionAttribute<Produit, Information> informations;

}