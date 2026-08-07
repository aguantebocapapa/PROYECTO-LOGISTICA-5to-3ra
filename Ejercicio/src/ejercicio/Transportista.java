
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Transportista extends Persona{
    private int envios_entregados;
    private int envios_fallidos;
    private int envios_total;
    private int nro_id;
    private double peso_paquete;

    public int getEnvios_entregados() {
        return envios_entregados;
    }

    public void setEnvios_entregados(int envios_entregados) {
        this.envios_entregados = envios_entregados;
    }

    public int getEnvios_fallidos() {
        return envios_fallidos;
    }

    public void setEnvios_fallidos(int envios_fallidos) {
        this.envios_fallidos = envios_fallidos;
    }

    public int getEnvios_total() {
        return envios_total;
    }

    public void setEnvios_total(int envios_total) {
        this.envios_total = envios_total;
    }

    public int getNro_id() {
        return nro_id;
    }

    public void setNro_id(int nro_id) {
        this.nro_id = nro_id;
    }

    public double getPeso_paquete() {
        return peso_paquete;
    }

    public void setPeso_paquete(double peso_paquete) {
        this.peso_paquete = peso_paquete;
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

    public Transportista(int envios_entregados, int envios_falldos, int envios_total, int nro_id, double peso_paquete, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(nombre, apellido, dni, email, numero_telefono);
        this.envios_entregados = envios_entregados;
        this.envios_fallidos = envios_fallidos;
        this.envios_total = envios_total;
        this.nro_id = nro_id;
        this.peso_paquete = peso_paquete;
    }
    
     @Override
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "El nombre es: " + getNombre()
                + "\n Su apellido es: " + getApellido()
                + "\n Su DNI es: " + getDni()
                + "\n Su Email es: " + getEmail()
                + "\n Su numero de telefono es: " + getNumero_telefono()
                + "\n Su cantidad de envios totales es: " + getEnvios_total()
                + "\n Su cantidad de envios entregados es: " + getEnvios_entregados()
                + "\n Su cantidad de envios fallidos es: " + getEnvios_fallidos()
                + "\n Su numero de identificacion es: " + getNro_id()
        );
    }
    
    @Override
    public ArrayList<String> DatosExclusivos(){
         String textEnvios_total = String.valueOf(envios_total);
         String textEnvios_entregados = String.valueOf(envios_entregados);
         String textEnvios_fallidos = String.valueOf(envios_fallidos);
         String textNro_id = String.valueOf(nro_id);
         ArrayList<String> aux=new ArrayList<>();
         aux.add("Transportista");
         aux.add(textEnvios_total);
         aux.add(textEnvios_entregados);
         aux.add(textEnvios_fallidos);
         aux.add(textNro_id);
         return aux;
    }
}
