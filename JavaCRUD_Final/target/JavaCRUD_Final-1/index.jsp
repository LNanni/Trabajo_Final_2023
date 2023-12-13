<%-- 
    Document   : index
    Created on : 12 dic 2023, 09:51:11
    Author     : leanm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Oradores</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Oradores</h1>
        <a href="Alta.jsp" style="margin: 2%"> Nuevo Orador </a>
        <a href="Eliminar.jsp" style="margin: 2%"> Eliminar Orador </a>
        <a href="Modificar.jsp" style="margin: 2%"> Modificar Orador </a>
        <form action="ControllerU" method="GET">
            <p>Ingres nombre del/los oradores: <input id="nombreBuscado" name="nombreBuscado" type="text"/></p>
            <button type="submit"> Buscar oradores </button>    
        </form>
        <br/>
        <form action="ControllerCR" method="GET">
            <button type="submit" style="margin: 2%"> Listado oradores </button>    
        </form>
    </body>
</html>
