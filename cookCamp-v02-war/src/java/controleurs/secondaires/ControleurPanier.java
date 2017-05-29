package controleurs.secondaires;

import Outil.CustomException;
import Transient.LigneDePanierMenu;
import Transient.LigneDePanierProduit;
import com.cookcamp.entite.Emplacement;
import com.cookcamp.entite.Menu;
import com.cookcamp.metier.GestionPanierLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import utilitaire.PanierWar;

public class ControleurPanier implements SousControleurInterface, Serializable {

    GestionPanierLocal gestionPanier = lookupGestionPanierLocal();

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String url = "/WEB-INF/fragment/panier.jsp";

//         if(session.getAttribute("panierwar") == null){
//            session.setAttribute("panierwar", new PanierWar());
//        }
//        
//        PanierWar gestionPanier = (PanierWar) session.getAttribute("panierwar");
        String action = request.getParameter("action");

        if ("ajouter".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.ajouterProduit(idProduit);

                Collection<LigneDePanierProduit> panier = gestionPanier.getPanier();
                session.setAttribute("panierServeur", panier);

//                url = "/WEB-INF/jsp/accueilClient.jsp";
                url = "/WEB-INF/jsp/serveur.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                session.setAttribute("problemePanier", hashMapErreur.get("problemePanier"));

//                url = "/WEB-INF/jsp/accueilClient.jsp";
                url = "/WEB-INF/fragment/panier.jsp";
            }

        }

        if ("choisirEmplacementServeur".equalsIgnoreCase(action)) {

            String idEmplacement = request.getParameter("idEmplacement");
            try {

                gestionPanier.addHashMapTotalServeur(idEmplacement);
                session.setAttribute("EmplacementServeur", idEmplacement);
                url = "/WEB-INF/jsp/serveur.jsp";
                //-------------------------
//                String empl =(String) session.getAttribute("idEmplacement");
//                System.out.println("emplacement:" + empl);
//                 Collection<LigneDePanierProduit>collecPanier = (Collection<LigneDePanierProduit>) session.getAttribute("panier");
//                 for (LigneDePanierProduit collecPanier1 : collecPanier) {
//                     System.out.println(collecPanier1.getProduit().getNom()+"/n");
//                }
            } catch (CustomException ex) {
                HashMap<String, String> hashMapErr = ex.getHashMapErreur();
                session.setAttribute("problemeEmplacement", hashMapErr.get("problemeEmplacement"));
            }

        }

        if ("plusQuantiteProduit".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.plusQuantiteProduit(idProduit);
                url = "/WEB-INF/jsp/serveur.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                for (String key : hashMapErreur.keySet()) {

                    session.setAttribute(key, hashMapErreur.get(key));

                }

            }

        }

        if ("minusQuantiteProduit".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.minusQuantiteProduit(idProduit);
                url = "/WEB-INF/jsp/serveur.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                for (String key : hashMapErreur.keySet()) {

                    session.setAttribute(key, hashMapErreur.get(key));

                }
            }

        }

        if ("delete".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.deleteLignePanier(idProduit);
                url = "/WEB-INF/jsp/serveur.jsp";
            } catch (CustomException ce) {

            }

        }

        session.setAttribute("prixTotal", gestionPanier.getPrixTotal());

        if ("voirPanierServeur".equalsIgnoreCase(action)) {

            url = "/WEB-INF/fragment/panier.jsp";
        }

        if ("voirPanierClient".equalsIgnoreCase(action)) {

            url = "/WEB-INF/fragment/panierClient.jsp";
        }

        //====================//////Panier Client\\\\\======================
        //-------------------------------------------------------------------
        if ("ajouterPanierClient".equalsIgnoreCase(action)) {

            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.ajouterProduitClient(idProduit);

                Collection<LigneDePanierProduit> panier = gestionPanier.getPanierClient();
                session.setAttribute("panierClient", panier);

                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                session.setAttribute("problemePanier", hashMapErreur.get("problemePanier"));

                url = "/WEB-INF/jsp/accueilClient.jsp";
            }

        }

//        //--------------Radio button--------------------------------
//        String[] produitRadios =request.getParameterValues("produitRadio") ;
//        
//        
//            System.out.println(produitRadios);
        //---------------------------------------------------------
        if ("ajouterMenu".equalsIgnoreCase(action)) {

            try {
                Long idMenu = Long.parseLong(request.getParameter("idMenu"));
                gestionPanier.ajouterMenuClient(idMenu);
                Collection<LigneDePanierMenu> panierMenuClient = gestionPanier.getMenuClient();
                session.setAttribute("panierMenuClient", panierMenuClient);

                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ex) {
                HashMap<String, String> hashMapErreur = ex.getHashMapErreur();
                session.setAttribute("problemePanier", hashMapErreur.get("problemePanier"));
            }

        }

        if ("choisirEmplacementClient".equalsIgnoreCase(action)) {

            String idEmplacement = request.getParameter("idEmplacement");
            try {

                gestionPanier.addHashMapTotalClient(idEmplacement);
                session.setAttribute("EmplacementClient", idEmplacement);
                url = "/WEB-INF/jsp/accueilClient.jsp";
                //-------------------------
//                String empl =(String) session.getAttribute("idEmplacement");
//                System.out.println("emplacement:" + empl);
//                 Collection<LigneDePanierProduit>collecPanier = (Collection<LigneDePanierProduit>) session.getAttribute("panier");
//                 for (LigneDePanierProduit collecPanier1 : collecPanier) {
//                     System.out.println(collecPanier1.getProduit().getNom()+"/n");
//                }
            } catch (CustomException ex) {
                HashMap<String, String> hashMapErr = ex.getHashMapErreur();
                session.setAttribute("problemeEmplacement", hashMapErr.get("problemeEmplacement"));
            }

        }

        if ("plusQuantiteProduitClient".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.plusQuantiteProduitClient(idProduit);
                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                for (String key : hashMapErreur.keySet()) {

                    session.setAttribute(key, hashMapErreur.get(key));

                }

            }

        }

        if ("minusQuantiteProduitClient".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.minusQuantiteProduitClient(idProduit);
                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                for (String key : hashMapErreur.keySet()) {

                    session.setAttribute(key, hashMapErreur.get(key));

                }
            }

        }

        if ("deleteProduitClient".equalsIgnoreCase(action)) {
            Long idProduit = Long.parseLong(request.getParameter("idProduit"));
            try {
                gestionPanier.deleteLignePanierClient(idProduit);
                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ce) {

            }

        }
        session.setAttribute("prixTotalClient", gestionPanier.getPrixTotalClient());

        //============================---Menu===================================   
        if ("plusQuantiteMenuClient".equalsIgnoreCase(action)) {

            try {
                Long idMenu = Long.parseLong(request.getParameter("idMenu"));
                gestionPanier.plusQuantiteMenuClient(idMenu);
                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ex) {
                HashMap<String, String> hashMapErreur = ex.getHashMapErreur();
                for (String key : hashMapErreur.keySet()) {

                    session.setAttribute(key, hashMapErreur.get(key));

                }
            }

        }

        if ("minusQuantiteMenuClient".equalsIgnoreCase(action)) {

            try {
                Long idMenu = Long.parseLong(request.getParameter("idMenu"));
                gestionPanier.minusQuantiteMenuClient(idMenu);
                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ce) {
                HashMap<String, String> hashMapErreur = ce.getHashMapErreur();
                for (String key : hashMapErreur.keySet()) {

                    session.setAttribute(key, hashMapErreur.get(key));

                }
            }

        }

        if ("deleteMenuClient".equalsIgnoreCase(action)) {
            Long idMenu = Long.parseLong(request.getParameter("idMenu"));
            try {
                gestionPanier.deleteLignePanierMenuClient(idMenu);
                url = "/WEB-INF/jsp/accueilClient.jsp";
            } catch (CustomException ce) {

            }

        }

        if ("validerPanier".equalsIgnoreCase(action)) {

            session.removeAttribute("panierServeur");
            session.removeAttribute("EmplacementServeur");
            url = "/WEB-INF/jsp/serveur.jsp";
        }

        String ok = request.getParameter("ok");
        String recup = request.getParameter("recuperer");

        ServletContext context = request.getSession().getServletContext();

        if ("recup".equals(recup)) {
            context.removeAttribute("CommandePrete");
        }
        if ("ok".equals(ok)) {
            context.removeAttribute("aide");
        }

        return url;

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
