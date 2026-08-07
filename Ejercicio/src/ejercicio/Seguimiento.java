
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Seguimiento extends Persona{
    private int nro_id;
    private String horario;
    private int cantpaque_per;
    private int reportes;

    public int getNro_id() {
        return nro_id;
    }

    public void setNro_id(int nro_id) {
        this.nro_id = nro_id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCantpaque_per() {
        return cantpaque_per;
    }

    public void setCantpaque_per(int cantpaque_per) {
        this.cantpaque_per = cantpaque_per;
    }

    public int getReportes() {
        return reportes;
    }

    public void setReportes(int reportes) {
        this.reportes = reportes;
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

    public Seguimiento(int nro_id, String horario, int cantpaque_per, int reportes, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(nombre, apellido, dni, email, numero_telefono);
        this.nro_id = nro_id;
        this.horario = horario;
        this.cantpaque_per = cantpaque_per;
        this.reportes = reportes;
    }
    
    @Override
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "El nombre es: " + getNombre()
                + "\n Su apellido es: " + getApellido()
                + "\n Su DNI es: " + getDni()
                + "\n Su Email es: " + getEmail()
                + "\n Su numero de telefono es: " + getNumero_telefono()
                + "\n Su horario es: " + getHorario()
                + "\n Su cantidad de paquetes por persona es: " + getCantpaque_per()
                + "\n Sus reportes son:: " + getReportes()
                + "\n Su numero de identificacion es: " + getNro_id()
        );
    }
    
    @Override
    public ArrayList<String> DatosExclusivos(){
         String textNro_id = String.valueOf(nro_id);
         String textCantpaque_per = String.valueOf(cantpaque_per);
         String textReportes = String.valueOf(reportes);
         ArrayList<String> aux=new ArrayList<>();
         aux.add("Seguimiento");
         aux.add(horario);
         aux.add(textNro_id);
         aux.add(textCantpaque_per);
         aux.add(textReportes);
         return aux;
    }
}
