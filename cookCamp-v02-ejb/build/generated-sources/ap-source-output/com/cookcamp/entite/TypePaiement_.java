package com.cookcamp.entite;

import com.cookcamp.entite.Paiement;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(TypePaiement.class)
public class TypePaiement_ { 

    public static volatile CollectionAttribute<TypePaiement, Paiement> paiements;
    public static volatile SingularAttribute<TypePaiement, String> moyen;
    public static volatile SingularAttribute<TypePaiement, Long> id;

}