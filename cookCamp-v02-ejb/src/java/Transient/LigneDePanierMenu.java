
package Transient;

import com.cookcamp.entite.DemandeParticuliere;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import java.io.Serializable;

public class LigneDePanierMenu implements Serializable{
 private String id;
    private Menu menu;
    private int quantite;
    private float prix;
    private float tva;
    private DemandeParticuliere demandeParticuliere;

    public LigneDePanierMenu() {
        quantite = 1;

    }

    public LigneDePanierMenu(Menu menu)
    {
        this();
        this.menu= menu;
    }
    
    public LigneDePanierMenu(Menu menu, int quantite, float prix, float tva, DemandeParticuliere demandeParticuliere) {
        this.menu = menu;
        this.quantite = quantite;
        this.prix = prix;
        this.tva = tva;
        this.demandeParticuliere = demandeParticuliere;
    }

    public LigneDePanierMenu(String id, Menu menu, int quantite, float prix, float tva, DemandeParticuliere demandeParticuliere) {
        this.id = id;
        this.menu = menu;
        this.quantite = quantite;
        this.prix = prix;
        this.tva = tva;
        this.demandeParticuliere = demandeParticuliere;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public DemandeParticuliere getDemandeParticuliere() {
        return demandeParticuliere;
    }

    public void setDemandeParticuliere(DemandeParticuliere demandeParticuliere) {
        this.demandeParticuliere = demandeParticuliere;
    }

   
    public float getPrixLignePanier()
    {
            return quantite*menu.getPrix();
            
        
       
    }
    
    
}
