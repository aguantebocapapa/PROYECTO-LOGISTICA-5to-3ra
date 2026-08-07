
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Proveedor extends Persona{
    private int cantEnvios;
    private int nro_id;

    public int getCantEnvios() {
        return cantEnvios;
    }

    public void setCantEnvios(int cantEnvios) {
        this.cantEnvios = cantEnvios;
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

    public Proveedor(int cantEnvios, int nro_id, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(nombre, apellido, dni, email, numero_telefono);
        this.cantEnvios = cantEnvios;
        this.nro_id = nro_id;
    }
    
    
    
    @Override
    public ArrayList<String> DatosExclusivos(){
         String textCantEnvios = String.valueOf(cantEnvios);
         String textNro_id = String.valueOf(nro_id);
         ArrayList<String> aux=new ArrayList<>();
         aux.add("Proveedor");
         aux.add(textCantEnvios);
         aux.add(textNro_id);
         return aux;
    }
    
    @Override
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "El nombre es: " + getNombre()
                + "\n Su apellido es: " + getApellido()
                + "\n Su DNI es: " + getDni()
                + "\n Su Email es: " + getEmail()
                + "\n Su numero de telefono es: " + getNumero_telefono()
                + "\n Su cantidad de envios realizados es: " + getCantEnvios()
                + "\n Su numero de identificacion es: " + getNro_id()
        );
    }
}
