<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta orador</title>
    </head>
    <body>
        <h1>Alta orador</h1>
        <form action="ControllerCR" method="POST" autocomplete="off">
            <p>Nombre: <input id="nombre" name="nombre" type="text"/></p>
            <p>Apellido: <input id="apellido" name="apellido" type="text"/></p>
            <p>Tema: <input id="tema" name="tema" type="text"/></p>
            <p>Mail: <input id="mail" name="mail" type="text"/></p>
            <button id="btnAlta" name="btnAlta" type="submit"> Crear nuevo orador</button>
        </form>
    </body>
</html>
