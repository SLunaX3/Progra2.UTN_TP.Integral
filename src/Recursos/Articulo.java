
package Recursos;

import Interfaces.Clasificable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Articulo extends RecursoAcademico implements Clasificable {
    private List<String> palabrasClave;
    private String revista;
    private List<String> categorias;

    public Articulo(List<String> palabrasClave, String revista, String id, String titulo, LocalDate fechaCreacion, String autor) {
        super(id, titulo, fechaCreacion, autor);
        this.palabrasClave = palabrasClave;
        this.revista = revista;
         this.categorias = new ArrayList<>();
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    
    

    @Override
    public double calcularRelevancia() {
        return palabrasClave.size() * 5; // asigna un peso fijo a cada palabra clave
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\n - Articulo: " + getTitulo() + 
                " \n - Autor: " + getAutor() + 
                " \n - Revista: " + getRevista() + 
                " \n - Palabras Clave: " + getPalabrasClave() +  
                " \n - Categorias: " + categorias+
                       "\n - ID: " + getId() + 
                       "\n - Fecha de Creación: " + getFechaCreacion());
    }
    
    public int contarPalabrasClave(){
        return palabrasClave.size();
    }
    
    
    @Override
    public String toString() {
        return "Articulo | " + getId() + " | " + getTitulo() + " | " + getFechaCreacion() + " | " + getAutor() + " | " + String.join(", ", palabrasClave) + " | " + revista+ " | " + String.join(", ", categorias);
    }


    @Override
    public String[] obtenerCategoriasClasificacion() {
        return categorias.toArray(new String[0]);
    }

    @Override
    public void asignarCategoria(String categoria) {
        categorias.add(categoria);
    }    
    
}
