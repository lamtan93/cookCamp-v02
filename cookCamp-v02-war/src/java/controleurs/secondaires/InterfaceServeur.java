package controleurs.secondaires;

import com.cookcamp.entite.Commande;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.LigneCommandeMenu;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import com.cookcamp.metier.GestionAffichageServeurLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import test.TestBDDLocal;

public class InterfaceServeur implements SousControleurInterface, Serializable {
    GestionAffichageServeurLocal gestionAffichageServeur = lookupGestionAffichageServeurLocal();
    
    
    
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        response.setContentType(null);
        
        
        HttpSession session = request.getSession();
  
//        Long choixCommande = Long.parseLong(request.getParameter("choixCommande"));
//        Long choixCommand = Long.valueOf(request.getParameter("choixCommande"));
    
        String action = request.getParameter("action");

        String url = "/WEB-INF/jsp/AccueilServeur.jsp";
        
        if ("affichageCommande".equalsIgnoreCase(action)) {
            Collection<Commande> commandes = gestionAffichageServeur.getCommande();
            session.setAttribute("mesCommandes", commandes);
            System.out.println("Mes commandes : " + commandes);
            System.out.println("Fin---------------");
            url = "/WEB-INF/jsp/AccueilServeur.jsp";
            
        }


        if ("afficherProduitByCmde".equalsIgnoreCase(action)) {
            System.out.println("Mes commandes : " + request.getParameter("idCommande"));
            Long idCommande = Long.parseLong(request.getParameter("idCommande"));
            System.out.println("Mes commandes : " + idCommande);
            Collection<Produit> produits = gestionAffichageServeur.findProduitLdcpByCommandeId(idCommande);
            session.setAttribute("produitParCommande", produits);

            
            System.out.println("Mes commandes : " + request.getParameter("idCommande"));
//            Long idCommande1 = Long.parseLong(request.getParameter("idCommande"));
            System.out.println("Mes commandes : " + idCommande);
            
            Collection<Menu> menus = gestionAffichageServeur.findMenuLdcmByCommandeId(idCommande);
            System.out.println("Menu : " + menus);
            session.setAttribute("menuParCommande", menus);            
            url = "/WEB-INF/jsp/AccueilServeur.jsp";      

        }
        
        if ("afficherMenuByCmde".equalsIgnoreCase(action)) {  
                  
        }

        
        return url;
    }

    private GestionAffichageServeurLocal lookupGestionAffichageServeurLocal() {
        try {
            Context c = new InitialContext();
            return (GestionAffichageServeurLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionAffichageServeur!com.cookcamp.metier.GestionAffichageServeurLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
