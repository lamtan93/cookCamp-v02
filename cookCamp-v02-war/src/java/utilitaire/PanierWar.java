
package utilitaire;

import Outil.CustomException;
import Transient.LigneDePanierProduit;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.Produit;
import com.cookcamp.metier.GestionPanierLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class PanierWar {
    
  private GestionPanierLocal gestionPanier ;


    
    
    public PanierWar()
    {
       gestionPanier = lookupGestionPanierLocal();
    }



    private GestionPanierLocal lookupGestionPanierLocal() {
        try {
            Context c = new InitialContext();
            return (GestionPanierLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionPanier!com.cookcamp.metier.GestionPanierLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
