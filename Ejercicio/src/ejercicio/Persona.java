
package ejercicio;

import java.util.ArrayList;
public abstract class Persona {
   protected String nombre;
   protected String apellido;
   protected String dni;
   protected String email;
   protected String numero_telefono;

    public Persona(String nombre, String apellido, String dni, String email, String numero_telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.numero_telefono = numero_telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
    
    public abstract void mostrarPersona();
    
    public abstract ArrayList<String> DatosExclusivos();
}
