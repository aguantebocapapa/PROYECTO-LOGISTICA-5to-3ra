/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Redes-20
 */
public class Avion extends Vehiculo{
    int millas;
    int volumen;

    public Avion(int millas, int volumen, String modelo, String marca, int precio, int anio) {
        super(modelo, marca, precio, anio);
        this.millas = millas;
        this.volumen = volumen;
    }
    @Override
    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Modelo:" + modelo + "Marca:" + marca + "Precio:"  + precio + "Año:" + anio+ "Cantidad  de millas " + millas+"Volumen: " + volumen);
    }
    @Override
    public ArrayList<String> exclu(){
        String mmm=String.valueOf(millas);
        String mmm2=String.valueOf(volumen);
        ArrayList<String> a=new ArrayList<>();
        a.add("Avion");
        a.add(mmm);
        a.add(mmm2);
        return a;
    }
    
}
