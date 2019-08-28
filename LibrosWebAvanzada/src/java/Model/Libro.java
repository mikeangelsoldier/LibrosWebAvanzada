/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author
 */
public class Libro{
    /*Clase para crear los objetos de tipo Libro con sus respectivos parámetros*/
    private String claveISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private String fechaPublicacion;
    private String lugarPublicacion;
    private String numEdicion;
    private int numeroDePaginas; 
    
            

    public Libro() {
    }

    public Libro(String claveISBN, String titulo, String autor, String editorial, String genero, String fechaPublicacion, String lugarPublicacion, String numEdicion, int numeroDePaginas) {
        this.claveISBN = claveISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.lugarPublicacion = lugarPublicacion;
        this.numEdicion = numEdicion;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getClaveISBN() {
        return claveISBN;
    }

    public void setClaveISBN(String claveISBN) {
        this.claveISBN = claveISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getLugarPublicacion() {
        return lugarPublicacion;
    }

    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }

    public String getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(String numEdicion) {
        this.numEdicion = numEdicion;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    
    

    
}
