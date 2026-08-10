
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

    public int getNumEnvio() {
        return numEnvio;
    }

    public void setNumEnvio(int numEnvio) {
        this.numEnvio = numEnvio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
