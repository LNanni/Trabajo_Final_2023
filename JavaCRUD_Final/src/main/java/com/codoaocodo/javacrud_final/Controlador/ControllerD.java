package com.codoaocodo.javacrud_final.Controlador;

import com.codoaocodo.javacrud_final.Modelo.OradorDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerD", urlPatterns = {"/ControllerD"})
public class ControllerD extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        OradorDAO orador_dao = new OradorDAO();
        if(orador_dao.eliminarOrador(id)){
            response.sendRedirect("QueryExitosa.jsp");
        }
        else response.sendRedirect("QueryFalla.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
