package app.controladores;

import app.dao.LibroDAO;
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

@WebServlet(name = "registrar", urlPatterns = {"/registrar"})

public class Insertar extends HttpServlet {

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

            //Se crea el objeto y se colocan sus atributos de acuerdo a lo recibido desde la página jsp
            Libro libro = new Libro(clave_isbn, titulo, autor, editorial, genero, fecha_publicacion, lugar_publicacion, numero_edicion, numero_de_paginas);

            //Se utiliza el gestor de videojuegos para realizar la inserción de este objeto en la BD:
            LibroDAO gestor = new LibroDAO();
            gestor.addLibro(libro);

            request.setAttribute("resInsert", "Se ha insertado el registro correctamente");
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } finally {
            out.close();
        }
    }
}
