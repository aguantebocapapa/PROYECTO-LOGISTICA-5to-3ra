
package ejercicio;

import javax.swing.JOptionPane;


public class Empleado extends Persona{
    private int idempleado;
    private String sector;
    private String cargo;
    private String rol;

    public Empleado(int idempleado, String sector, String cargo, String rol, int idPersona, String nombre, String apellido, String dni, String email, String numero_telefono) {
        super(idPersona, nombre, apellido, dni, email, numero_telefono);
        this.idempleado = idempleado;
        this.sector = sector;
        this.cargo = cargo;
        this.rol = rol;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    @Override
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "El nombre es: " + getNombre()
                + "\n Su apellido es: " + getApellido()
                + "\n Su DNI es: " + getDni()
                + "\n Su Email es: " + getEmail()
                + "\n Su numero de telefono es: " + getNumero_telefono()
                +"El id del empleado es:"+idempleado
                + "\n Es sector " + sector
                + "\n Su cargo es: " + cargo
                + "\n Su rol es: " + rol
        );}
}
