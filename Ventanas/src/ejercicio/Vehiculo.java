/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import javax.swing.JOptionPane;

/**
 *
 * @author Redes-20
 */
public  class Vehiculo {
    private int idvehiculo;
   private String modelo;
   private String marca;
   private int precio;
   private int anio;
   private String tipo;

    public Vehiculo(int idvehiculo, String modelo, String marca, int precio, int anio, String tipo) {
        this.idvehiculo = idvehiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.anio = anio;
        this.tipo = tipo;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
  
   
   public  void mostrar(){
       JOptionPane.showMessageDialog(null,"El vehiculo del id "+idvehiculo+" con el modelo "+modelo+" con la marca"
               + ""+marca+" con el precio "+precio+" con el año "+anio+" con el tipo "+tipo);
   }
   
}
