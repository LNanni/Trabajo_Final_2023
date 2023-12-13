<%@page import="java.util.List"%>
<%@page import="com.codoaocodo.javacrud_final.Modelo.Orador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Oradores encontrados</h1>
        <%
            List<Orador> listado = (List)request.getSession().getAttribute("listaOradores");
            if(listado.isEmpty()){ %>
            <h3>No se han encontrado oradores con el nombre buscado</h3>
        <%    
            }
            else { for(Orador orador : listado){
        %>
        <p><b>ID: <%=orador.getId() %></b></p>
        <p>Nombre: <%=orador.getNombre() %><p>
        <p>Apellido: <%=orador.getApellido() %><p>
        <p>Tema: <%=orador.getTema()%><p>
        <p>Mail: <%=orador.getMail() %><p>
        <p>Fecha: <%=orador.getFechaAlta() %><p>
        <P>--------------------------------------------</P>
        <% } } %>
    </body>
</html>
