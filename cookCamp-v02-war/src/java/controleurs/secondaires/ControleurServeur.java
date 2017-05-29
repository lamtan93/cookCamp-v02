package controleurs.secondaires;

import com.cookcamp.entite.Emplacement;
import com.cookcamp.metier.GestionEmplacementLocal;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleurServeur implements SousControleurInterface, Serializable {

    GestionEmplacementLocal gestionEmplacement = lookupGestionEmplacementLocal();

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = "/WEB-INF/jsp/serveur.jsp";

        String action = request.getParameter("action");
        if ("emplacement".equalsIgnoreCase(action)) {
            Collection<Emplacement> listEmplacements = gestionEmplacement.getEmplacements();
            request.setAttribute("emplacements", listEmplacements);
            url = "/WEB-INF/fragment/emplacement.jsp";
        }
        
        if("emplacementClient".equalsIgnoreCase(action))
        {
            
           Collection<Emplacement> listEmplacements = gestionEmplacement.getEmplacements();
           request.setAttribute("emplacementsClient", listEmplacements);
           url = "/WEB-INF/fragment/emplacementClient.jsp";
        }

        return url;
    }

    private GestionEmplacementLocal lookupGestionEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (GestionEmplacementLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionEmplacement!com.cookcamp.metier.GestionEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
