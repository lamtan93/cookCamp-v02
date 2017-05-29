/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.secondaires;

import com.cookcamp.entite.LignedeCommandeProduit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cookcamp.metier.GestionCaisseLocal;

/**
 *
 * @author cdi105
 */
public class AjaxRepartition implements SousControleurInterface {
    GestionCaisseLocal gestionCaisse = lookupGestionCaisseLocal();
   

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        HttpSession session= request.getSession();
//        String lp=request.getParameter("listeProduits");
//        ArrayList<String> Listes=new ArrayList(Arrays.asList(lp.split(",")));
//        ArrayList<LignedeCommandeProduit> listeAjax=new ArrayList();
        
       
//        for (String Liste : Listes) {
//            listeAjax.add(gestionCaisse.findLigneProduits(Long.valueOf(Liste)));
//            System.out.println(" dans ");
//            
//        }
//       session.setAttribute("ListeAjax", listeAjax);
        
       
      
        return "/WEB-INF/fragment/detailsRepartition.jsp";
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
