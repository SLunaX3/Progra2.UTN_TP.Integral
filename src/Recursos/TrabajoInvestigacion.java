
package Recursos;

import Interfaces.Clasificable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrabajoInvestigacion extends RecursoAcademico implements Clasificable {
    
    private List<String> autores;
    private String lineaInvestigacion;
    private List<String> categorias;

    public TrabajoInvestigacion(List<String> autores, String lineaInvestigacion, String id, String titulo, LocalDate fechaCreacion, String autor) {
        super(id, titulo, fechaCreacion, autor);
        this.autores = autores;
        this.lineaInvestigacion = lineaInvestigacion;
        this.categorias = new ArrayList<>();
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
    
    

    @Override
    public double calcularRelevancia() {
        return autores.size() * 0.5;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("\n - Trabajo de Investigación: " + getTitulo() + 
                " \n - Autores: " + getAutores() + 
                " \n - Línea de Investigación: " + getLineaInvestigacion() +
                 " \n - Categorias: " + categorias+
                       "\n - ID: " + getId() + 
                       "\n - Fecha de Creación: " + getFechaCreacion());
                }
    
    public boolean tieneFinanciamiento() {
        return autores.size() > 3; // lo tiene si son más de 3 autores
    }


    @Override
    public String toString() {
        return "TrabajoInvestigacion | " + getId() + " | " + getTitulo() + " | " + getFechaCreacion() + " | " + getAutor() + " | " + String.join(", ", autores) + " | " + lineaInvestigacion+ " | " + String.join(", ", categorias);
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
