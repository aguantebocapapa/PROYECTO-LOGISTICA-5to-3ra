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
public class Empresas_Adheridas {
     int id_empresa;
     String nombre;
     String cuil;
     String direccion;
     String telefono;
     String rubro;
     String duenio;

    public Empresas_Adheridas(int id_empresa, String nombre, String cuil, String direccion, String telefono, String rubro, String duenio) {
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        this.cuil = cuil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rubro = rubro;
        this.duenio = duenio;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }
    
    public void mostrarEmpreesa(){
        JOptionPane.showMessageDialog(null,
                "ID empresa"+id_empresa+"/n"+
                "nombre"+nombre+"/n"+
                "cuil"+cuil+"/n"+
                "direccion"+direccion+"/n"+
                "telefono"+telefono+"/n"+
                "rubro"+rubro+"/n"+
                "duenio"+duenio+"/n");
    }
}
