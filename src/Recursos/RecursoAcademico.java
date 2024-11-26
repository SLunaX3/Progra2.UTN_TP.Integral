
package Recursos;

import java.time.LocalDate;

public abstract class RecursoAcademico {

    private String id;
    private String titulo;
    private LocalDate fechaCreacion;
    private String autor;

    public RecursoAcademico(String id, String titulo, LocalDate fechaCreacion, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    
    public abstract double calcularRelevancia();
    
    public abstract void mostrarDetalles();    

    @Override
    public abstract String toString();
    

    
}