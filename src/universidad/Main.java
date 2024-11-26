
package universidad;
/**
 *
 * @author LUNA, SONIA
 */

import Gestores.GestorRecursos;
import Recursos.Libro;
import Recursos.Articulo;
import Recursos.TrabajoInvestigacion;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            Libro libro = new Libro(300, "Pearson", "001", "El Lenguaje de Programación Java", LocalDate.now(), "James Gosling");
            Articulo articulo = new Articulo(List.of("Java", "Programación"), "Revista Muy Interesante", "002", "Introducción a Java", LocalDate.now(), "Ana Gómez");
            TrabajoInvestigacion trabajo = new TrabajoInvestigacion(List.of("Carlos Sánchez", "Elena Ruiz"), "Inteligencia Artificial", "003", "Avances en IA", LocalDate.now(), "Luis Díaz");

            // Asignar categorías a los recursos
            libro.asignarCategoria("Educación");
            articulo.asignarCategoria("Programación");
            trabajo.asignarCategoria("IA");
            
            // Agregar recursos al gestor
            GestorRecursos gestor = new GestorRecursos(List.of(libro, articulo, trabajo));

            // Guardar en un archivo
            gestor.guardarRecursos("recursos.txt");

            // Cargar desde el archivo
            gestor.cargarRecursosDesdeArchivo("recursos.txt");

            // Generar informe
            gestor.generarInforme();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
