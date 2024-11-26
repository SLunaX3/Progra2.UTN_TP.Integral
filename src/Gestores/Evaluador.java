
package Gestores;


public class Evaluador {
    
    private String nombre;
    private String especialidad;

    public Evaluador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Evaluador {" + " Nombre: " + nombre + " | Especialidad: " + especialidad + '}';

        
        
    }
    
    
    
    
}
