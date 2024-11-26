
package Gestores;


import Excepciones.CriterioInvalidoException;
import Interfaces.FiltroRecurso;
import Recursos.Articulo;
import Recursos.Libro;
import Recursos.RecursoAcademico;
import Recursos.TrabajoInvestigacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GestorRecursos {

    private List<RecursoAcademico> recursos;

    public GestorRecursos(List<RecursoAcademico> recursos) {
        this.recursos = recursos;
    }

    public List<RecursoAcademico> filtrarRecursos(FiltroRecurso filtro) {
        return recursos.stream()
                .filter(recurso -> filtro.evaluar(recurso))
                .collect(Collectors.toList());
    }

    public void ordenarRecursos(CriterioOrdenacion criterio) throws CriterioInvalidoException {

        if (criterio == null) {
            throw new CriterioInvalidoException("\n *** El criterio de ordenación no puede ser nulo. *** ");
        }
        
        Comparator<RecursoAcademico> comparator;        

        switch (criterio) {
            case TITULO:
                comparator = (r1, r2) -> r1.getTitulo().compareTo(r2.getTitulo());
                break;
            case AUTOR:
                comparator = (r1, r2) -> r1.getAutor().compareTo(r2.getAutor());
                break;
            case FECHA_CREACION:
                comparator = (r1, r2) -> r1.getFechaCreacion().compareTo(r2.getFechaCreacion());
                break;
            case ID:
                comparator = (r1, r2) -> r1.getId().compareTo(r2.getId());
                break;
            default:
                throw new CriterioInvalidoException("\n *** Criterio de ordenación no válido: " + criterio);
        }

        recursos.sort(comparator);
    }
    
    public void aplicarTransformaciones() {
        
        recursos.forEach(r -> r.setTitulo(r.getTitulo().toUpperCase()));
    }
        
    public void generarInforme() {
        if (recursos.isEmpty()) {
            System.out.println("\n *** No hay recursos registrados. ***");
        } else {
            System.out.println("----- Informe de Recursos -----");
            System.out.println("Total de recursos: " + recursos.size());
        for (RecursoAcademico recurso : recursos) {
            recurso.mostrarDetalles();  // Esto llama al método 'mostrarDetalles' de cada recurso
        }
        }
    }
    
    // Guardar los recursos en un archivo de texto
    public void guardarRecursos(String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (RecursoAcademico recurso : recursos) {
                writer.write(recurso.toString()); // Convertir el objeto a texto
                writer.newLine();
            }
        }
    }


    // Cargar los recursos desde un archivo de texto
    public void cargarRecursosDesdeArchivo(String archivo) throws IOException {
        List<RecursoAcademico> recursosCargados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            // parsear cada línea y reconstruir el objeto
            String[] datos = linea.split(" \\| ");
            String tipo = datos[0];
            String id = datos[1];
            String titulo = datos[2];
            LocalDate fechaCreacion = LocalDate.parse(datos[3]);
            String autor = datos[4];
            List<String> categorias = List.of(datos[7].split(", ")); // lee categorías como lista

            if (tipo.equals("Libro")) {
                int numeroPaginas = Integer.parseInt(datos[5]);
                String editorial = datos[6];
                Libro libro = new Libro(numeroPaginas, editorial, id, titulo, fechaCreacion, autor);
                libro.setCategorias(categorias); // Asignar las categorías
                recursosCargados.add(libro);
            } else if (tipo.equals("Articulo")) {
                List<String> palabrasClave = List.of(datos[5].split(", "));
                String revista = datos[6];
                Articulo articulo = new Articulo(palabrasClave, revista, id, titulo, fechaCreacion, autor);
                articulo.setCategorias(categorias); // Asignar las categorías
                recursosCargados.add(articulo);
            } else if (tipo.equals("TrabajoInvestigacion")) {
                List<String> autores = List.of(datos[5].split(", "));
                String lineaInvestigacion = datos[6];
                TrabajoInvestigacion trabajo = new TrabajoInvestigacion(autores, lineaInvestigacion, id, titulo, fechaCreacion, autor);
                trabajo.setCategorias(categorias); // Asignar las categorías
                recursosCargados.add(trabajo);
                }
            }
        }
        this.recursos = recursosCargados;
    }

}
