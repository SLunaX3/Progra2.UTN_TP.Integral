
package Interfaces;

import Recursos.RecursoAcademico;

@FunctionalInterface
public interface FiltroRecurso {
    
    boolean evaluar(RecursoAcademico recurso);
    
}
