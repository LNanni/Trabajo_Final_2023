<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar orador</title>
    </head>
    <body>
        <h1>Modificar orador</h1>
        <form action="ControllerU" method="POST" autocomplete="off">
            <p>Id: <input id="id" name="id" type="number"/></p>
            <p>Nombre: <input id="nombre" name="nombre" type="text"/></p>
            <p>Apellido: <input id="apellido" name="apellido" type="text"/></p>
            <p>Tema: <input id="tema" name="tema" type="text"/></p>
            <p>Mail: <input id="mail" name="mail" type="text"/></p>
            <button id="btnModificar" name="btnModificar" type="submit"> Modificar orador</button>
        </form>
    </body>
</html>
