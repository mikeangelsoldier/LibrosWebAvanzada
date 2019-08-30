package app.controladores;

import app.dao.LibroDAO;
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

@WebServlet(name = "borrar", urlPatterns = {"/borrar"})

public class Borrar extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String id = request.getParameter("id");
            LibroDAO gestor = new LibroDAO();
            gestor.deleteLibro(id);

            request.setAttribute("resInsert", "Se ha borrado el registro correctamente");

             request.getRequestDispatcher("/index.jsp").forward(request, response);
        } finally {
            out.close();
        }
    }
}
