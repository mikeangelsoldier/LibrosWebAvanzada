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
        <form action="">
            
            <table border="1" align="center">
            <tr>
                <td>Clave:</td> 
                <td><input type="text" name="txtClave"></td>
            </tr>
             
                <tr>
                <td>Titulo:</td>
                <td><input type="text" name="txtNombre"></td>
            </tr>
            
                <tr>
                <td>Autor:</td>
                <td><input type="text" name="txtTipo"></td>
            </tr>
            
                <tr>
                <td>Editorial:</td>
                <td><input type="text" name="txtSatca"></td>
            </tr>
            
                <tr>
                <td>Genero:</td>
                <td><input type="text" name="txtSemestre"></td>
            </tr>
            
                <tr>
                    <td>Fecha de publicaci&oacute;n:</td>
                    <td><input type="datetime" name="txtPlan"></td>
            </tr>
            
                <tr>
                <td>Lugar de publicaci&oacute;n:</td>
                <td><input type="text" name="txtUnidades"></td>
            </tr>
            
                <tr>
                    <td>Edici&oacute;n:</td>
                <td><input type="text" name="txtDescripcion"></td>
            </tr>
            
                <tr>
                    <td>N&uacute;mero de paginas:</td>
                <td><input type="text" name="txtCarrera"></td>
            </tr>
            
               <tr>
                    <td>Estado:</td>
                <td><input type="text" name="txtCarrera"></td>
            </tr>
            
                <tr align="center">
                    <td colspan="2"><input type="submit" name="btnGuardar" value="Añadir libro"></td>
            </tr>
            
           </table>
            
        </form>
    </body>
</html>
