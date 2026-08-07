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
public class Barco extends Vehiculo{
    int millas;
    int containers;

    public Barco(int millas, int containers, String modelo, String marca, int precio, int anio) {
        super(modelo, marca, precio, anio);
        this.millas = millas;
        this.containers = containers;
    }
    @Override
    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Modelo:" + modelo + "Marca:" + marca + "Precio:"  + precio + "Año:" + anio+ "Cantidad  de millas " + millas+"Cantidad de containers: " + containers);
    }
    @Override
    public ArrayList<String> exclu(){
        String mmm=String.valueOf(millas);
        String mmm2=String.valueOf(containers);
        ArrayList<String> a=new ArrayList<>();
        a.add("Barco");
        a.add(mmm);
        a.add(mmm2);
        return a;
    }
}
