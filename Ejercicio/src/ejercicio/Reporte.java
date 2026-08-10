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
 * @author Benjamin
 */
public class Reporte {
    int idReporte;
    String detalle;
    ArrayList<Ticket>tickets;

    public Reporte(int idReporte, String detalle) {
        this.idReporte = idReporte;
        this.detalle = detalle;
        tickets=new ArrayList<>();
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public void agregarTicket(Ticket t){
        tickets.add(t);
    }
    public void mostrar(){
        JOptionPane.showMessageDialog(null,"El reporte con el id "+idReporte+" con el detalle "+detalle);
        for (Ticket t:tickets){
            t.mostrarticket();
        }
    }
}
