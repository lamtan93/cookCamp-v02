package com.cookcamp.entite;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.TypePaiement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Paiement.class)
public class Paiement_ { 

    public static volatile SingularAttribute<Paiement, Long> idPaiement;
    public static volatile SingularAttribute<Paiement, Date> datePaiement;
    public static volatile CollectionAttribute<Paiement, TypePaiement> typePaiements;
    public static volatile SingularAttribute<Paiement, Commande> commande;

}