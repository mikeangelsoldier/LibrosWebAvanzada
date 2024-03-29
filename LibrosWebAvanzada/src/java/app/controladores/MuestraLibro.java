package app.controladores;

import app.dao.LibroDAO;
import app.dominio.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@WebServlet(name = "muestraLibro", urlPatterns = {"/muestraLibro"})

public class MuestraLibro extends HttpServlet { 

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Collection<Libro> libros = new ArrayList<Libro>();
            LibroDAO gestorLibroBD = new LibroDAO();
            libros = gestorLibroBD.getLibros();

            if (libros != null) {

                request.setAttribute("Libros", libros);//Se coloca la lista de videojuegos con el nombre de parámetro "Videojuego"
                request.getRequestDispatcher("/index.jsp").forward(request, response);//Se envia

                request.setAttribute("Libros", libros);//Se coloca la lista de libros con el nombre de parámetro "Libros"
                request.getRequestDispatcher("/lista_libros.jsp").forward(request, response);//Se envia
            } else {
                request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
            } 
        } finally {
            out.close();
        }
    }
}
