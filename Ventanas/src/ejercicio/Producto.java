package ejercicio;

import javax.swing.JOptionPane;



public  class Producto {
    private int idproducto;
    private String Nombremarca;
    private String Descripcion;
    private double precio;
    private int stock;
    private String tipo;

    public Producto(int idproducto, String Nombremarca, String Descripcion, double precio, int stock, String tipo) {
        this.idproducto = idproducto;
        this.Nombremarca = Nombremarca;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombremarca() {
        return Nombremarca;
    }

    public void setNombremarca(String Nombremarca) {
        this.Nombremarca = Nombremarca;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    public  void mostrarDatos(){
        JOptionPane.showMessageDialog(null,"El id del producto "+idproducto+" el nombre de la marca"+Nombremarca
        +" la descripcion "+Descripcion+" el precio "+precio+" el stock "+stock+" y el tipo "+tipo);
    }
    
}
