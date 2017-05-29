package controleurs.secondaires;

import Outil.CustomException;
import com.cookcamp.entite.Employe;
import com.cookcamp.entite.Fonction;
import com.cookcamp.metier.GestionAuthentificationLocal;
import java.io.IOException;
//import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleurAuthentification implements SousControleurInterface, Serializable {

    GestionAuthentificationLocal gestionAuthentification = lookupGestionAuthentificationLocal();

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loginAjax = request.getParameter("loginAjax");

        String url = "/WEB-INF/fragment/authentification.jsp";
        try {
            Employe emp = gestionAuthentification.authentifier(loginAjax);
            Collection<Fonction> listFonctions = emp.getFonctions();
            session.setAttribute("sessionEmploye", emp);
            session.setAttribute("fonction", listFonctions);
            request.setAttribute("message", "Connecté !");

            for (Fonction listFonction : listFonctions) {
                if (listFonction.getNomFonction().equalsIgnoreCase("Serveur")) {

                    url = "/WEB-INF/jsp/serveur.jsp";

                } else if (listFonction.getNomFonction().equalsIgnoreCase("Responsable")) {
                    url = "/WEB-INF/jsp/responsable.jsp";

                }else if(listFonction.getNomFonction().equalsIgnoreCase("Cuisinier"))
                {
                    url = "/WEB-INF/jsp/AccueilCuisinier.jsp";
                }
            }

        } catch (CustomException ce) {
            HashMap<String, String> map = ce.getHashMapErreur();

            for (String key : map.keySet()) {

                request.setAttribute(key, map.get(key));

            }
            url = "/WEB-INF/fragment/resultAuthentificationAjax.jsp";
//        } catch (IOException ex) {
//            Logger.getLogger(ControleurAuthentification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        return url;

    }

    private GestionAuthentificationLocal lookupGestionAuthentificationLocal() {
        try {
            Context c = new InitialContext();
            return (GestionAuthentificationLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/GestionAuthentification!com.cookcamp.metier.GestionAuthentificationLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
