
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Analista extends Persona{
    private String tipo_analisis;
    private String especialidad;
    private String titulo;
    private int nro_id;

    public String getTipo_analisis() {
        return tipo_analisis;
    }

    public void setTipo_analisis(String tipo_analisis) {
        this.tipo_analisis = tipo_analisis;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNro_id() {
        return nro_id;
    }

    public void setNro_id(int nro_id) {
        this.nro_id = nro_id;
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

    public Analista(String tipo_analisis, String especialidad, String titulo, int nro_id, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(nombre, apellido, dni, email, numero_telefono);
        this.tipo_analisis = tipo_analisis;
        this.especialidad = especialidad;
        this.titulo = titulo;
        this.nro_id = nro_id;
    }
    
    @Override
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "El nombre es: " + getNombre()
                + "\n Su apellido es: " + getApellido()
                + "\n Su DNI es: " + getDni()
                + "\n Su Email es: " + getEmail()
                + "\n Su numero de telefono es: " + getNumero_telefono()
                + "\n Su tipo de analisis es: " + getTipo_analisis()
                + "\n Su especialidad es: " + getEspecialidad()
                + "\n Su titulo es: " + getTitulo()
                + "\n Su numero de identificacion es: " + getNro_id()
        );
    }
    
    @Override
    public ArrayList<String> DatosExclusivos(){
         String textNro_id = String.valueOf(nro_id);
         ArrayList<String> aux=new ArrayList<>();
         aux.add("Analista");
         aux.add(textNro_id);
         return aux;
    }
}
