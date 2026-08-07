package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Accesorio extends Producto{
    String tematica;
    String utilidad;
    String material;

    public Accesorio(String tematica, String utilidad, String material, int idproducto, String Nombremarca, String Descripcion, double precio, int stock) {
        super(idproducto, Nombremarca, Descripcion, precio, stock);
        this.tematica = tematica;
        this.utilidad = utilidad;
        this.material = material;
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
                        "Tematica: "+tematica+"\n"+
                        "Utilidad: "+utilidad+"\n"+
                        "Material: "+material+"\n"
        );
    }
    
    @Override
    public ArrayList<String> exclusivos(){
       ArrayList <String> aux = new ArrayList<>();
       aux.add("Accesorio");
       aux.add(tematica);
       aux.add(utilidad);
       aux.add(material);
       return aux;
    }
}
