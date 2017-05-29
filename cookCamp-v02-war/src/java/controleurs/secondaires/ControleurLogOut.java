
package controleurs.secondaires;

import java.io.Serializable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControleurLogOut implements SousControleurInterface, Serializable{

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
    
        session.removeAttribute("sessionEmploye");
        request.setAttribute("message", "Connectez vous !");
       
        String url = "/WEB-INF/fragment/authentification.jsp";
        return url;
    }
    
    
    
}
