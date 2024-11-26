
package Recursos;

import Interfaces.Clasificable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Libro extends RecursoAcademico implements Clasificable {
    
    private int numeroPaginas;
    private String editorial;
    private List<String> categorias;
    
    public Libro(int numeroPaginas, String editorial, String id, String titulo, LocalDate fechaCreacion, String autor) {
        super(id, titulo, fechaCreacion, autor);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.categorias = new ArrayList<>();     
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    
    

    @Override
    public double calcularRelevancia() {
        return numeroPaginas * 0.1; // asigna una relevancia mayor a los libros con más páginas.
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\n - Libro: " + getTitulo() + " [ " + getNumeroPaginas() + " paginas ]" +
                " \n - Autor: " + getAutor() + " \n - Editorial: " + getEditorial() + 
                 " \n - Categorias: " + categorias +
                       "\n - ID: " + getId() + 
                       "\n - Fecha de Creación: " + getFechaCreacion());
    }
    
    public boolean esLibroDigital(){
        return numeroPaginas < 500; // si tiene más de 500 es Digital
    }
    
    @Override
    public String toString() {
        return "Libro | " + getId() + " | " + getTitulo() + " | " + getFechaCreacion() + " | " + getAutor() + " | " + numeroPaginas + " | " + editorial+ " | " + String.join(", ", categorias);
    }
    
        @Override
    public String[] obtenerCategoriasClasificacion() {
        return categorias.toArray(new String[0]); // Devuelve las categorías como un array de Strings
    }

    @Override
    public void asignarCategoria(String categoria) {
        categorias.add(categoria); // Agrega una nueva categoría a la lista
    }
}
