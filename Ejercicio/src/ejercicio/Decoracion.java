package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Decoracion extends Producto{
    String material;
    String color;
    String estilo;
    double alto;
    double ancho;

    public Decoracion(String material, String color, String estilo, double alto, double ancho, int idproducto, String Nombremarca, String Descripcion, double precio, int stock) {
        super(idproducto, Nombremarca, Descripcion, precio, stock);
        this.material = material;
        this.color = color;
        this.estilo = estilo;
        this.alto = alto;
        this.ancho = ancho;
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
                       "Material: "+material+"\n"+
                        "Color: "+color+"\n"+
                        "Estilo: "+estilo+"\n"+
                        "Alto: "+alto+"\n"+
                        "Ancho: "+ancho+"\n"
                );
    }
    
    @Override
    public ArrayList<String> exclusivos(){
       String textAlto = String.valueOf(alto);
       String textAncho = String.valueOf(ancho);
       
       ArrayList <String> aux = new ArrayList<>();
       aux.add("Decoracion");
       aux.add(material);
       aux.add(color);
       aux.add(estilo);
       aux.add(textAlto);
       aux.add(textAncho);
       return aux;
    }
}
