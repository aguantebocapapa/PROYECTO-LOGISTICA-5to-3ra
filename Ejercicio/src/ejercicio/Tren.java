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
public class Tren extends Vehiculo{
    int vagones;

    public Tren(int vagones, String modelo, String marca, int precio, int anio) {
        super(modelo, marca, precio, anio);
        this.vagones = vagones;
    }
    @Override
    public void mostrar(){
        JOptionPane.showMessageDialog(null,"Modelo:" + modelo + "Marca:" + marca + "Precio:"  + precio + "Año:" + anio+"Cantidad de vagones" + vagones);
    }
    @Override
    public ArrayList<String> exclu(){
        String mmm=String.valueOf(vagones);
        ArrayList<String> a=new ArrayList<>();
        a.add("Tren");
        a.add(mmm);
        return a;
    }
}
