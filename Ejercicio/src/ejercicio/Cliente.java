
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Cliente extends Persona{
    private int idCliente;
    private String habitual;
    private int cantcomp;
    private double presupuesto;

    public Cliente(int idCliente, String habitual, int cantcomp, double presupuesto, int idPersona, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(idPersona, nombre, apellido, dni, email, numero_telefono);
        this.idCliente = idCliente;
        this.habitual = habitual;
        this.cantcomp = cantcomp;
        this.presupuesto = presupuesto;
    }

   

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getHabitual() {
        return habitual;
    }

    public void setHabitual(String habitual) {
        this.habitual = habitual;
    }

    public int getCantcomp() {
        return cantcomp;
    }

    public void setCantcomp(int cantcomp) {
        this.cantcomp = cantcomp;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

   
    
    @Override
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "El nombre es: " + getNombre()
                + "\n Su apellido es: " + getApellido()
                + "\n Su DNI es: " + getDni()
                + "\n Su Email es: " + getEmail()
                + "\n Su numero de telefono es: " + getNumero_telefono()
                +"El id del cliente es:"+idCliente
                + "\n Es cliente habitual? " + getHabitual()
                + "\n Su cantidad de compras es: " + getCantcomp()
                + "\n Su presupuesto es: " + getPresupuesto()
        );
    }
    
    
    
   
}
