
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Redes-20
 */
public class Camion extends Vehiculo {
    int patente;
    boolean refrigeracion;

    public Camion(int patente, boolean refrigeracion, String modelo, String marca, int precio, int anio) {
        super(modelo, marca, precio, anio);
        this.patente = patente;
        this.refrigeracion = refrigeracion;
    }
    @Override
    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Modelo:" + modelo + "Marca:" + marca + "Precio:"  + precio + "Año:" + anio+ "Patente: " + patente +"¿Tiene refrigeracion? " + refrigeracion);
    }
    @Override
    public ArrayList<String> exclu(){
        String mmm=String.valueOf(patente);
        String mmm2=String.valueOf(refrigeracion);
        ArrayList<String> a=new ArrayList<>();
        a.add("Camion");
        a.add(mmm);
        a.add(mmm2);
        return a;
    }
    
}
