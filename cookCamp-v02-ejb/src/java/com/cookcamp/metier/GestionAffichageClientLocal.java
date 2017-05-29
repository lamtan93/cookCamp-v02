package com.cookcamp.metier;

import com.cookcamp.entite.Choix;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import com.cookcamp.entite.Type;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionAffichageClientLocal {

    public List<Type> getType();

    public List<Menu> getMenus();

    public List<Produit> getProduitsbyType(String nomType);

    public Produit getProduitbyId(Long id);

    public void persist(Object object);

    public List<Choix> getChoixByPromo();
    
}
