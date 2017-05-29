package com.cookcamp.entite;

import com.cookcamp.entite.Employe;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Fonction.class)
public class Fonction_ { 

    public static volatile SingularAttribute<Fonction, String> nomFonction;
    public static volatile SingularAttribute<Fonction, Long> id;
    public static volatile CollectionAttribute<Fonction, Employe> employes;

}