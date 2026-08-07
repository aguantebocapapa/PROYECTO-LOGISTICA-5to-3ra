
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Cliente extends Persona{
    private String habitual;
    private int cantcomp;
    private double presupuesto;

    public Cliente(String habitual, int cantcomp, double presupuesto, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(nombre, apellido, dni, email, numero_telefono);
        this.habitual = habitual;
        this.cantcomp = cantcomp;
        this.presupuesto = presupuesto;
    }

    public String getHabitual() {
        return habitual;
    }

    public void setabitual(String habitual) {
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
                + "\n Es cliente habitual? " + getHabitual()
                + "\n Su cantidad de compras es: " + getCantcomp()
                + "\n Su presupuesto es: " + getPresupuesto()
        );
    }
    
    @Override
    public ArrayList<String> DatosExclusivos(){
         
         String textCantcomp = String.valueOf(cantcomp);
         String textPresupuesto = String.valueOf(presupuesto);
         ArrayList<String> aux=new ArrayList<>();
         aux.add("Cliente");
         aux.add(habitual);
         aux.add(textCantcomp);
         aux.add(textPresupuesto);
         return aux;
    }

   
}
