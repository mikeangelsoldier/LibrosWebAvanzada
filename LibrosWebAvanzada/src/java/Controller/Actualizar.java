package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
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
            //Se obtienen los valores modificados que se enviaron en el request
           
            String titulo = request.getParameter("titulo");

            //Se crear el objeto pasando los parametros modificados
           Libro libro = new Libro(id);

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
