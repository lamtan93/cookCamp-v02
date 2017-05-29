
package Transient;

import com.cookcamp.entite.DemandeParticuliere;
import com.cookcamp.entite.Produit;
import java.io.Serializable;

public class LigneDePanierProduit implements Serializable{
    
    private String id;
    private Produit produit;
    private int quantite;
    private float prix;
    private float tva;
    private DemandeParticuliere demandeParticuliere;

    public LigneDePanierProduit() {
        quantite = 1;

    }

    public LigneDePanierProduit(Produit p)
    {
        this();
        this.produit= p;
    }
    
    public LigneDePanierProduit(Produit produit, int quantite, float prix, float tva, DemandeParticuliere demandeParticuliere) {
        this.produit = produit;
        this.quantite = quantite;
        this.prix = prix;
        this.tva = tva;
        this.demandeParticuliere = demandeParticuliere;
    }

    public LigneDePanierProduit(String id, Produit produit, int quantite, float prix, float tva, DemandeParticuliere demandeParticuliere) {
        this.id = id;
        this.produit = produit;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
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
            return quantite*produit.getPrix();
        
       
    }
    
    
}
