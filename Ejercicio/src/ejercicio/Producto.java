package ejercicio;

import java.util.ArrayList;

public abstract class Producto {
    protected int idproducto;
    protected String Nombremarca;
    protected String Descripcion;
    protected double precio;
    protected int stock;

    public Producto(int idproducto, String Nombremarca, String Descripcion, double precio, int stock) {
        this.idproducto = idproducto;
        this.Nombremarca = Nombremarca;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.stock = stock;
    }
    
    public abstract void mostrarDatos();
    
    public abstract ArrayList<String> exclusivos();
}
