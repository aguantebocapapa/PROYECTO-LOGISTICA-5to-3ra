/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import javax.swing.JOptionPane;

/**
 *
 * @author Benjamin
 */
public class Ticket {
    private int idticket;
    private String fecha;
    Cliente cliente;
    private int total;
    private String pago;

    public Ticket(int idticket, String fecha, Cliente cliente, int total, String pago) {
        this.idticket = idticket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.pago = pago;
    }

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    public void mostrarticket(){
        JOptionPane.showMessageDialog(null,"El ticket de id "+idticket+" con la fecha "+fecha+" con el total "
        +total+"metodo de pago "+pago);
        cliente.mostrarPersona();
    }
}
