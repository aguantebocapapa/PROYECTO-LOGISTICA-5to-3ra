package ejercicio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Indumentaria extends Producto {
    String Prenda;
    String talle;
    String color;
    String material;
    String temporada;

    public Indumentaria(String Prenda, String talle, String color, String material, String temporada, int idproducto, String Nombremarca, String Descripcion, double precio, int stock) {
        super(idproducto, Nombremarca, Descripcion, precio, stock);
        this.Prenda = Prenda;
        this.talle = talle;
        this.color = color;
        this.material = material;
        this.temporada = temporada;
    }
    
    @Override
    public void mostrarDatos(){
        JOptionPane.showMessageDialog(null, 
                "DECORACION\n"+
                       "ID producto: "+idproducto+"\n"+
                       "Nombre marca: "+Nombremarca+"\n"+
                       "Descripcion: "+Descripcion+"\n"+
                       "Precio: "+precio+"\n"+
                       "Stock: "+stock+"\n"+
                        "Prenda: "+Prenda+"\n"+
                        "Talle: "+talle+"\n"+
                        "Color: "+color+"\n"+
                        "Material: "+material+"\n"+
                        "Temporada: "+temporada+"\n"
        );
    }
    
    @Override
    public ArrayList<String> exclusivos(){
       ArrayList <String> aux = new ArrayList<>();
       aux.add("Indumentaria");
       aux.add(Prenda);
       aux.add(talle);
       aux.add(color);
       aux.add(material);
       aux.add(temporada);
       return aux;
    }
}
