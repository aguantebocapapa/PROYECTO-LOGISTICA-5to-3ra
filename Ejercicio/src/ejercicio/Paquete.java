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
public class Paquete {
    int id_paquete;
    double peso;
    double volumen;
    String fecha_ensamble;
    ArrayList<Producto>productos;

    public Paquete(int id_paquete, double peso, double volumen, String fecha_ensamble) {
        this.id_paquete = id_paquete;
        this.peso = peso;
        this.volumen = volumen;
        this.fecha_ensamble = fecha_ensamble;
        productos=new ArrayList<>();
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getFecha_ensamble() {
        return fecha_ensamble;
    }

    public void setFecha_ensamble(String fecha_ensamble) {
        this.fecha_ensamble = fecha_ensamble;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    public void AgregarProducto(Producto p){
        productos.add(p);
    }
    public void MostrarPaquete(){
        JOptionPane.showMessageDialog(null,"id paquete: "+id_paquete+"Peso: "+peso+"Volumen: "+volumen+"Fecha ensamble: "+fecha_ensamble);
        for(Producto p:productos){
            p.mostrarDatos();
        }
    }
   
    
    
    
}
