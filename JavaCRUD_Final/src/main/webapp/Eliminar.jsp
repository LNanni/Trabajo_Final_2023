<%-- 
    Document   : Eliminar
    Created on : 13 dic 2023, 12:34:03
    Author     : leanm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar orador</title>
    </head>
    <body>
        <h1>Eliminar orador</h1>
        <form action="ControllerD" method="POST">
            <p>Id: <input id="id" name="id" type="number">
            <button type="submit"> Eliminar usuario </button>
        </form>
    </body>
</html>
