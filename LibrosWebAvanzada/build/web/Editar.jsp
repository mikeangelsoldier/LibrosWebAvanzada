

<%@page import="app.dominio.Libro"%>
<%@page import="app.dao.LibroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            LibroDAO gestor = new LibroDAO();

            Libro libro = gestor.getLibro(Integer.parseInt(request.getParameter("id")));
        %>
        <h2 align="center">Modifique la informaci&oacute;n necesaria</h2>
        <form action="actualizar">

            <table border="1" align="center">
                <tr>
                    <td>Clave:</td> 
                    <td><input type="text" name="clave_isbn" value="<%= libro.getClaveISBN()%>"></td>
                </tr>

                <tr>
                    <td>Titulo:</td>
                    <td><input type="text" name="titulo" value="<%= libro.getTitulo()%>"></td>
                </tr>

                <tr>
                    <td>Autor:</td>
                    <td><input type="text" name="autor" value="<%= libro.getAutor()%>"></td>
                </tr>

                <tr>
                    <td>Editorial:</td>
                    <td><input type="text" name="editorial" value="<%= libro.getEditorial()%>"></td>
                </tr>

                <tr>
                    <td>Genero:</td>
                    <td><input type="text" name="genero" value="<%= libro.getGenero()%>"></td>
                </tr>

                <tr>
                    <td>Fecha de publicaci&oacute;n:</td>
                    <td><input type="date" name="fecha_publicacion" value="<%= libro.getFechaPublicacion()%>"></td>
                </tr>

                <tr>
                    <td>Lugar de publicaci&oacute;n:</td>
                    <td><input type="text" name="lugar_publicacion" value="<%= libro.getLugarPublicacion()%>"></td>
                </tr>

                <tr>
                    <td>Edici&oacute;n:</td>
                    <td><input type="text" name="numero_edicion" value="<%= libro.getNumEdicion()%>"></td>
                </tr>

                <tr>
                    <td>N&uacute;mero de paginas:</td>
                    <td><input type="text" name="numero_de_paginas" value="<%= libro.getNumeroDePaginas()%>"></td>
                </tr>


                <tr align="center">
                    <td colspan="2"><input type="submit" name="btnGuardar" value="Guardar cambios"></td>
                </tr>

            </table>

        </form>
    </body>
</html>
