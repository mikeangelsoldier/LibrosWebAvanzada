package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LibroDAO {

    /*Esta es una simple clase de Java, su objetivo es brindar métodos de 
    inserción, modificación, eliminación, etc para cada objeto que se almacene 
    en una o más tablas de la Base de Datos. Es util cuando se tienen 
    varios objetos diferentes con un numero diferente de atributos para leer 
    o insertar en la BD */
    private Connection conexion;
    private ResultSet rs;
    private Statement st;

    public LibroDAO() {
        conexion = ConectaBD.obtenerConexion();
    }

    public Libro getLibro(int id) {
        /*Devuelve un objeto de tipo libro de acuerdo a su llave primaria */
        conexion = ConectaBD.obtenerConexion();
        Libro libro = new Libro();
        try {
            PreparedStatement ps = conexion.prepareStatement("call getLibro(?);");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            libro.setClaveISBN(rs.getString(1));
            libro.setTitulo(rs.getString(2));
            libro.setAutor(rs.getString(3));
            libro.setEditorial(rs.getString(4));
            libro.setGenero(rs.getString(5));
            libro.setFechaPublicacion(rs.getString(6));
            libro.setLugarPublicacion(rs.getString(7));
            libro.setNumEdicion(rs.getString(8));
            libro.setNumeroDePaginas(rs.getInt(9));

            rs.close();
            ps.close();
            conexion.close();
            return libro;
        } catch (Exception e) {
            e.printStackTrace();

            return libro;
        }
    }

    public List<Libro> getLibros() {
        /*Devuelve una lista con todos los usuarios 
         leidos de la base de datos*/
        conexion = ConectaBD.obtenerConexion();
        List<Libro> listaLibros = new ArrayList<>();

        try {
            st = conexion.createStatement();
            rs = st.executeQuery("call getLibros();");
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setClaveISBN(rs.getString(1));
                libro.setTitulo(rs.getString(2));
                libro.setAutor(rs.getString(3));
                libro.setEditorial(rs.getString(4));
                libro.setGenero(rs.getString(5));
                libro.setFechaPublicacion(rs.getString(6));
                libro.setLugarPublicacion(rs.getString(7));
                libro.setNumEdicion(rs.getString(8));
                libro.setNumeroDePaginas(rs.getInt(9));

                listaLibros.add(libro);

            }
            rs.close();
            st.close();
            conexion.close();
            return listaLibros;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public void addLibro(Libro libro) {
        /*Almacena un objeto en la base de datos, 
         cada atributo se utiliza en la posición que le corresponde 
         de la instrucción SQL */
        conexion = ConectaBD.obtenerConexion();
        try {
            PreparedStatement st = conexion.prepareStatement("call insertarLibro (?, ?, ?, ?, ?);");
            st.setString(1, libro.getClaveISBN());
            st.setString(2, libro.getTitulo());
            st.setString(3, libro.getAutor());
            st.setString(4, libro.getEditorial());
            st.setString(5, libro.getGenero());
            st.setString(6, libro.getFechaPublicacion());
            st.setString(7, libro.getLugarPublicacion());
            st.setString(8, libro.getNumEdicion());
            st.setInt(9, libro.getNumeroDePaginas());

            st.execute();
            st.close();
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateLibro(Libro libro) {
        /*Modifica un objeto en la base de datos, 
         cada atributo se utiliza en la posición que le corresponde 
         de la instrucción SQL */
        conexion = ConectaBD.obtenerConexion();
        try {
            PreparedStatement st = conexion.prepareStatement(
                    "call updateLibro (?,?,?,?,?,?);");
            st.setString(1, libro.getClaveISBN());
            st.setString(2, libro.getTitulo());
            st.setString(3, libro.getAutor());
            st.setString(4, libro.getEditorial());
            st.setString(5, libro.getGenero());
            st.setString(6, libro.getFechaPublicacion());
            st.setString(7, libro.getLugarPublicacion());
            st.setString(8, libro.getNumEdicion());
            st.setInt(9, libro.getNumeroDePaginas());
            st.execute();
            st.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteLibro(int id) {
        /*Elimina un registro en la base de datos de acuerdo a su llave primaria */
        conexion = ConectaBD.obtenerConexion();
        try {
            PreparedStatement st = conexion.prepareStatement(
                    "call deleteLibro(?);");
            st.setInt(1, id);
            st.execute();
            st.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<Libro> getFiltroLibros(String filtro) {
        /*Devuelve una lista con todos los usuarios 
         leidos de la base de datos*/
        conexion = ConectaBD.obtenerConexion();
        List<Libro> listaLibros = new ArrayList<>();

        try {
            PreparedStatement prest = conexion.prepareStatement("call getFiltroLibros(?);");

            prest.setString(1, filtro);

            rs = prest.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setClaveISBN(rs.getString(1));
                libro.setTitulo(rs.getString(2));
                libro.setAutor(rs.getString(3));
                libro.setEditorial(rs.getString(4));
                libro.setGenero(rs.getString(5));
                libro.setFechaPublicacion(rs.getString(6));
                libro.setLugarPublicacion(rs.getString(7));
                libro.setNumEdicion(rs.getString(8));
                libro.setNumeroDePaginas(rs.getInt(9));

                listaLibros.add(libro);

            }
            rs.close();
            prest.close();
            conexion.close();
            return listaLibros;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
