package controleurs.secondaires;

import com.cookcamp.entite.Choix;
import com.cookcamp.entite.Menu;
import com.cookcamp.entite.Produit;
import com.cookcamp.entite.Type;
import java.io.Serializable;
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
import com.cookcamp.metier.GestionAffichageClientLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletContext;

public class InterfaceClientAffichage implements SousControleurInterface, Serializable {

    GestionAffichageClientLocal gestionAffichageClient = lookupGestionAffichageClientLocal();

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        HttpSession session = request.getSession();
        String url = "/WEB-INF/jsp/accueilClient.jsp";
        String choixType = request.getParameter("choixType");
        String choixVignette = request.getParameter("choixVignette");
        String detailProduit = request.getParameter("detailProduit");
        String monMenu = request.getParameter("MenuSelect");

        ServletContext context = request.getSession().getServletContext();

        String aide = request.getParameter("aide");
        String idEmp = request.getParameter("idEmp");

        if ("vrai".equals(aide)) {
            context.setAttribute("aide", idEmp);
            session.removeAttribute("EmplacementClient");
            session.removeAttribute("aide");
        }

        if (detailProduit != null) {
            if (choixVignette != null) {
                if (choixVignette.equals("vignetteProduit")) {
                    url = "/WEB-INF/fragment/vignetteProduit.jsp";
                    Date today = new GregorianCalendar().getTime();
                    session.setAttribute("today", today);
                }
            } else {
                Long monId = Long.parseLong(detailProduit);
                Produit p = gestionAffichageClient.getProduitbyId(monId);
                session.setAttribute("produitDetail", p);
            }
        } else {
            if (choixVignette != null) {
                if (choixVignette.equals("vignetteProduit")) {
                    url = "/WEB-INF/fragment/vignetteProduit.jsp";
                    Date today = new GregorianCalendar().getTime();
                    session.setAttribute("today", today);
                }
            } else {
                if (choixType != null) {
                    session.setAttribute("choixType", choixType);
                    if (choixType.equals("Menu")) {
                        List<Menu> listeMenus = gestionAffichageClient.getMenus();
                        session.setAttribute("listeMenus", listeMenus);
                        List<Type> listeTypes = gestionAffichageClient.getType();
                        session.setAttribute("listeTypes", listeTypes);
                    } else {
                        List<Produit> listeProduits = gestionAffichageClient.getProduitsbyType(choixType);
                        session.setAttribute("listeProduits", listeProduits);
                    }

                } else {
                    List<Type> listeTypes = gestionAffichageClient.getType();
                    session.setAttribute("listeTypes", listeTypes);
                    List<Choix> listeChoix = gestionAffichageClient.getChoixByPromo();
                    List<Menu> listeMenus = new ArrayList();
                    List<Produit> listeProduits = new ArrayList();
                    for (Choix c : listeChoix) {
                        if (c instanceof Menu) {
                            Menu m = (Menu) c;
                            listeMenus.add(m);
                        } else {
                            Produit p = (Produit) c;
                            listeProduits.add(p);
                        }
                    }
                    session.setAttribute("listeMenus", listeMenus);
                    session.setAttribute("listeProduits", listeProduits);
                }
            }
        }

        return url;
    }

    private GestionAffichageClientLocal lookupGestionAffichageClientLocal() {
        try {
            Context c = new InitialContext();
            return (GestionAffichageClientLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionAffichageClient!com.cookcamp.metier.GestionAffichageClientLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
