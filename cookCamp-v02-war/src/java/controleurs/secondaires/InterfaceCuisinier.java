package controleurs.secondaires;

import com.cookcamp.entite.Commande;
import com.cookcamp.metier.GestionAffichageCuisinierLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InterfaceCuisinier implements SousControleurInterface, Serializable {

    GestionAffichageCuisinierLocal gestionAffichageCuisinier = lookupGestionAffichageCuisinierLocal();

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        ServletContext context = request.getSession().getServletContext();
        HttpSession session = request.getSession();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = "/WEB-INF/jsp/AccueilCuisinier.jsp";
        String rechercher = request.getParameter("rechercher");
        String etat = request.getParameter("etat");
        String id = request.getParameter("id");

        if ("pret".equals(etat)) {
            Commande c = gestionAffichageCuisinier.modifierEtat(id, etat);
            context.setAttribute("CommandePrete", c);
            List<Commande> mesCommandesEnCours = gestionAffichageCuisinier.afficherCommandeEnCours();
            session.setAttribute("mesCommandesEnCours", mesCommandesEnCours);
        }
        if ("vrai".equals(rechercher)) {
            List<Commande> mesCommandesEnCours = gestionAffichageCuisinier.afficherCommandeEnCours();
            session.setAttribute("mesCommandesEnCours", mesCommandesEnCours);
        }

        return url;
    }

    private GestionAffichageCuisinierLocal lookupGestionAffichageCuisinierLocal() {
        try {
            Context c = new InitialContext();
            return (GestionAffichageCuisinierLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionAffichageCuisinier!com.cookcamp.metier.GestionAffichageCuisinierLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
