/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;


import controleurs.secondaires.SousControleurInterface;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleurMain extends HttpServlet {
    
    

    private HashMap<String, SousControleurInterface> mp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        mp = new HashMap<>();
        Enumeration<String> noms = config.getInitParameterNames();
        while(noms.hasMoreElements()){
            String nomParam = noms.nextElement();
            String valeurParam = config.getInitParameter(nomParam);
            try {
                SousControleurInterface ssi = (SousControleurInterface) Class.forName(valeurParam).newInstance();
                mp.put(nomParam, ssi);
            } catch (InstantiationException ex) {
                
            } catch (IllegalAccessException ex) {
                
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String section = request.getParameter("section");
        String url = "/WEB-INF/fragment/authentification.jsp";
  
        if(section != null && mp.containsKey(section)){
            SousControleurInterface cp = mp.get(section);
            url = cp.executer(request, response, this);
        }
   
        getServletContext().getRequestDispatcher(url).include(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
