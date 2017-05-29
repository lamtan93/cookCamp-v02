package controleurs.secondaires;

import com.cookcamp.metier.TestBDDLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInsertionBDD implements SousControleurInterface, Serializable {

    TestBDDLocal testBDD = lookupTestBDDLocal();

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        testBDD.creerBase();
        String url = "/WEB-INF/fragment/authentification.jsp";
        return url;

    }

    private TestBDDLocal lookupTestBDDLocal() {
        try {
            Context c = new InitialContext();
            return (TestBDDLocal) c.lookup("java:global/cookCamp-v02/cookCamp-v02-ejb/TestBDD!com.cookcamp.metier.TestBDDLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
