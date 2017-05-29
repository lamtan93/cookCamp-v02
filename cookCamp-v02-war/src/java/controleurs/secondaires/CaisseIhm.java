package controleurs.secondaires;

import com.cookcamp.entite.Emplacement;
import com.cookcamp.metier.GestionCaisseLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaisseIhm implements SousControleurInterface,Serializable {
    GestionCaisseLocal gestionCaisse = lookupGestionCaisseLocal();
   
   
    
    private static final long serialVersionUID = 1L;
    
   
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        List<Emplacement> commandes=new ArrayList();
        commandes=gestionCaisse.findAllCommande();
        request.setAttribute("mesCommandes", commandes);
        
        
        String url="/WEB-INF/jsp/AccueilCaisse.jsp";
        return url;
    }

    private GestionCaisseLocal lookupGestionCaisseLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCaisseLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionCaisse!com.cookcamp.metier.GestionCaisseLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
    
}
