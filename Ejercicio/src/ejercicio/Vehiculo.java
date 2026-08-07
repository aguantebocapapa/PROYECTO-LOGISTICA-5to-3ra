/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.ArrayList;

/**
 *
 * @author Redes-20
 */
public abstract class Vehiculo {
   protected String modelo;
   protected String marca;
   protected int precio;
   protected int anio;

    public Vehiculo(String modelo, String marca, int precio, int anio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.anio = anio;
    }
   
   public abstract void mostrar();
   public abstract ArrayList<String> exclu();
   
}
