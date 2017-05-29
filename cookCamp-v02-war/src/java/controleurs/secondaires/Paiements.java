package controleurs.secondaires;

import controleurs.secondaires.SousControleurInterface;
import com.cookcamp.entite.LignedeCommandeProduit;
import com.cookcamp.entite.Paiement;
import com.cookcamp.metier.GestionCaisseLocal;
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

public class Paiements implements SousControleurInterface ,Serializable{
    GestionCaisseLocal gestionCaisse = lookupGestionCaisseLocal();
    
    
    private static final long serialVersionUID = 1L;

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        String url="/WEB-INF/jsp/paiementEmplacement.jsp";
        String action=request.getParameter("action");
        String idCo=request.getParameter("idCo");
        if("payer".equalsIgnoreCase(action)){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>dans le controleur pour action=payer ");
           Paiement p=gestionCaisse.ValiderPaiement(idCo);
            request.setAttribute("paiement", p);
           return url;
        }
      
        String numCo=request.getParameter("numCo");
        request.setAttribute("emp",request.getParameter("numEmp"));
        request.setAttribute("commande", numCo);
        List<LignedeCommandeProduit> ldpc;
             ldpc=gestionCaisse.findCommandeById(numCo);
        
        request.setAttribute("ListeProduits", ldpc);
         
        
        
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
