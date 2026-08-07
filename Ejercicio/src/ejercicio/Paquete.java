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
