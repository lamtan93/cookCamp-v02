package com.cookcamp.entite;

import com.cookcamp.entite.Choix;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T12:30:21")
@StaticMetamodel(Tva.class)
public class Tva_ { 

    public static volatile SingularAttribute<Tva, Date> date;
    public static volatile SingularAttribute<Tva, Float> pourcentage;
    public static volatile SingularAttribute<Tva, Long> id;
    public static volatile ListAttribute<Tva, Choix> mesChoix;

}