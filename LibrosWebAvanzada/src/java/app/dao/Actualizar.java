package app.dao;

import app.dominio.LibroDAO;
import app.dominio.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "actualizar", urlPatterns = {"/actualizar"})

public class Actualizar extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //Datos recibidos desde la pagina jsp
            String clave_isbn = request.getParameter("clave_isbn");
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String editorial = request.getParameter("editorial");
            String genero = request.getParameter("genero");
            String fecha_publicacion = request.getParameter("fecha_publicacion");
            String lugar_publicacion = request.getParameter("lugar_publicacion");
            String numero_edicion = request.getParameter("numero_edicion");
            int numero_de_paginas = Integer.parseInt(request.getParameter("numero_de_paginas"));
           

            //Se crear el objeto pasando los parametros modificados
            Libro libro = new Libro(clave_isbn, titulo, autor, editorial, genero, fecha_publicacion, lugar_publicacion, numero_edicion, numero_de_paginas);

            //Se crea un objeto gestor del videojuego para usar el método 
            //que contiene la consulta para actualizar en la base de datos
            LibroDAO gestor = new LibroDAO();
            gestor.updateLibro(libro);
            request.setAttribute("resInsert", "Se ha actuaizado el registro correctamente");

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } finally {
            out.close();
        }
    }
}
