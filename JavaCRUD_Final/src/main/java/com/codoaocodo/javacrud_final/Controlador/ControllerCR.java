package com.codoaocodo.javacrud_final.Controlador;

import com.codoaocodo.javacrud_final.Modelo.Orador;
import com.codoaocodo.javacrud_final.Modelo.OradorDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerCR", urlPatterns = {"/ControllerCR"})
public class ControllerCR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        OradorDAO orador_dao = new OradorDAO();
        List<Orador> listado = orador_dao.listarOradores();
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaOradores", listado);
        response.sendRedirect("Listado.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nom = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String tema = request.getParameter("tema");
        String mail = request.getParameter("mail");
        
        OradorDAO orador_dao = new OradorDAO();
        if(orador_dao.crearOrador(nom, ape, tema, mail)){
            response.sendRedirect("QueryExitosa.jsp");
        }
        else response.sendRedirect("QueryFalla.jsp");
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
