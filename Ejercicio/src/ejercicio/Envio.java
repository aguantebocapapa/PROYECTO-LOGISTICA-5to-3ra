
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Envio {
    
    private int numEnvio;
    private String fecha;
    private String origen;
    private String destino;
    ArrayList<Paquete> paquetes;
    ArrayList<Vehiculo> vehiculos;

    public Envio(int numEnvio, String fecha, String origen, String destino) {
        this.numEnvio = numEnvio;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        paquetes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        
    }
    public void AgregarPaquete(Paquete p){
        paquetes.add(p);
    }
    public void AgregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }
    public void Mostrar_envio(){
        JOptionPane.showMessageDialog(null,"Numero de envio: "+ numEnvio+"Fecha: "+fecha+"Origen: "+origen+"Destino: "+destino) ;
        for(Paquete p: paquetes){
            p.MostrarPaquete();
        }
        for(Vehiculo v : vehiculos){
            v.mostrar();
        }
    }
    
}
