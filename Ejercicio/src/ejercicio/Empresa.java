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
public class Empresa {
    String nombre;
    String direccion;
    String num_tele;
    ArrayList<Persona>personas;
    ArrayList<Envio> envios;
    ArrayList<Paquete> paquetes;
    ArrayList<Producto> productos;
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Empresas_Adheridas> amiguis;

    public Empresa(String nombre, String direccion, String num_tele) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.num_tele = num_tele;
        personas=new ArrayList<>();
        envios=new ArrayList<>();
        paquetes=new ArrayList<>();
        productos=new ArrayList<>();
        vehiculos=new ArrayList<>();
        amiguis=new ArrayList<>();
    }
    public void agregraPersona(Persona p){
        personas.add(p);
    }
    public void agregarEnvio(Envio e){
        envios.add(e);    
    }
    public void agregarPaquete(Paquete p){
        paquetes.add(p);
    }
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }
    public void agregarAdheridos(Empresas_Adheridas a){
        amiguis.add(a);
    }
    public void mostrar_empresa(){
        JOptionPane.showMessageDialog(null, "Nombre : " + nombre+" Direccion " + direccion+" Numero de telefono " + num_tele);
        for(Persona p:personas){
            p.mostrarPersona();
        }
        for(Envio e:envios){
            e.Mostrar_envio();
        }
        for(Paquete q:paquetes){
            q.MostrarPaquete();
        }
        for(Producto r:productos){
            r.mostrarDatos();
        }
        for(Vehiculo v:vehiculos){
            v.mostrar();
        }
        for(Empresas_Adheridas s:amiguis){
            s.mostrarEmpreesa();
        }
    }

}
