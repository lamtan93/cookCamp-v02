package controleurs.secondaires;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SousControleurInterface {
    public String executer(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet);
}
