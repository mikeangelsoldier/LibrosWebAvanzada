<%-- 
    Document   : Agregar
    Created on : 28/08/2019, 10:26:09 PM
    Author     : jcerver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center">Proporcione la informaci&oacute;n del libro a registrar</h2>
        <form action="registrar" method="POST">

            <table border="1" align="center">
                <tr>
                    <td>Clave:</td> 
                    <td><input type="text" name="clave_isbn"></td>
                </tr>

                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo"></td>
                </tr>

                <tr>
                    <td>Autor:</td>
                    <td><input type="text" name="autor"></td>
                </tr>

                <tr>
                    <td>Editorial:</td>
                    <td><input type="text" name="editorial"></td>
                </tr>

                <tr>
                    <td>Genero:</td>
                    <td><input type="text" name="genero"></td>
                </tr>

                <tr>
                    <td>Fecha de publicaci&oacute;n:</td>
                    <td><input type="date" name="fecha_publicacion"></td>
                </tr>

                <tr>
                    <td>Lugar de publicaci&oacute;n:</td>
                    <td><input type="text" name="lugar_publicacion"></td>
                </tr>

                <tr>
                    <td>Edici&oacute;n:</td>
                    <td><input type="text" name="numero_edicion"></td>
                </tr>

                <tr>
                    <td>N&uacute;mero de paginas:</td>
                    <td><input type="text" name="numero_de_paginas"></td>
                </tr>

               

                <tr align="center">
                    <td colspan="2"><input type="submit" name="btnGuardar" value="Añadir libro"></td>
                </tr>

            </table>

        </form>
    </body>
</html>
