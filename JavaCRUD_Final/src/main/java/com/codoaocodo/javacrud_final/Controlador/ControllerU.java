package com.codoaocodo.javacrud_final.Controlador;

import com.codoaocodo.javacrud_final.Modelo.Orador;
import com.codoaocodo.javacrud_final.Modelo.OradorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerU", urlPatterns = {"/ControllerU"})
public class ControllerU extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreBuscado = request.getParameter("nombreBuscado");
        OradorDAO orador_dao = new OradorDAO();
        List<Orador> listado = orador_dao.buscarPorNombre(nombreBuscado);
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaOradores", listado);
        response.sendRedirect("Buscar.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String tema = request.getParameter("tema");
        String mail = request.getParameter("mail");
        
        OradorDAO orador_dao = new OradorDAO();
        if(orador_dao.actualizarOrador(id, nom, ape, tema, mail)){
            response.sendRedirect("QueryExitosa.jsp");
        }
        else response.sendRedirect("QueryFalla.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
