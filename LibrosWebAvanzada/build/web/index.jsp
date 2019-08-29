

<%@page import="app.dao.LibroDAO"%>
<%@page import="app.dominio.Libro"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center" style="color:#FFFFFF">Listado de Libros</h1>
        <table border="1" width="1200" align="center"bgcolor="#FFFFFF"> 
            <tr bgcolor="skyblue"> 
                <th colspan="10">Registro de libros</th>
                <th colspan="1"><a href="Agregar.jsp"> <img src="Resources/images/add.png"></a></th>
            </tr>

            <%
                List<Libro> libros = new ArrayList<Libro>();
                LibroDAO gestorLibroBD = new LibroDAO();
                libros = gestorLibroBD.getLibros();

            %>

            <tr bgcolor="skyblue"> 
                <th>Clave</th>   
                <th>Titulo</th> 
                <th>Autor</th>   
                <th>Editorial</th>  
                <th>Genero</th> 
                <th>Fecha de publicaci&oacute;n</th> 
                <th>Lugar de publicaci&oacute;n</th> 
                <th>Edici&oacute;n</th> 
                <th>N&uacute;mero de paginas</th>

                <th>Acci&oacute;n</th>
            </tr>

            <%                    for (Libro librosDisponibles : libros) {
 
            %>
            <tr>

                <td><%= librosDisponibles.getClaveISBN()%> </td>
                <td><%= librosDisponibles.getTitulo()%></td>
                <td><%= librosDisponibles.getAutor()%></td>
                <td><%= librosDisponibles.getEditorial()%></td>
                <td><%= librosDisponibles.getGenero()%></td>
                <td><%= librosDisponibles.getFechaPublicacion()%></td>
                <td><%= librosDisponibles.getLugarPublicacion()%></td>
                <td><%= librosDisponibles.getNumEdicion()%></td>
                <td><%= librosDisponibles.getNumeroDePaginas()%></td>

                <td>   
                    <a href="Editar.jsp"> <img src="Resources/images/edit.png"></a>


                    <a href=""> <img src="Resources/images/delete.png"></a>
                </td>

            </tr>

            <% } %>

        </table>
    </body>
</html>
