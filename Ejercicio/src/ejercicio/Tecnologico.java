package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tecnologico extends Producto {
   String modelo;
   int garantia;
   int aniolanzamiento;
   int consumo;

    public Tecnologico(String modelo, int garantia, int aniolanzamiento, int consumo, int idproducto, String Nombremarca, String Descripcion, double precio, int stock) {
        super(idproducto, Nombremarca, Descripcion, precio, stock);
        this.modelo = modelo;
        this.garantia = garantia;
        this.aniolanzamiento = aniolanzamiento;
        this.consumo = consumo;
    }
   
   @Override
   public void mostrarDatos(){
        JOptionPane.showMessageDialog(null, 
               "TECNOLOGICO\n"+
                       "ID producto: "+idproducto+"\n"+
                       "Nombre marca: "+Nombremarca+"\n"+
                       "Descripcion: "+Descripcion+"\n"+
                       "Precio: "+precio+"\n"+
                       "Stock: "+stock+"\n"+
                       "Modelo: "+modelo+"\n"+
                       "Garantia: "+garantia+"\n"+
                       "Año lanzamiento: "+aniolanzamiento+"\n"+
                       "Consumo: "+consumo
        );
    }
   
   @Override
    public ArrayList<String> exclusivos(){
       String textGarantia = String.valueOf(garantia);
       String textAniolanzamiento = String.valueOf(aniolanzamiento);
       String textConsumo = String.valueOf(consumo);
       
       ArrayList <String> aux = new ArrayList<>();
       aux.add("Tecnologico");
       aux.add(modelo);
       aux.add(textGarantia);
       aux.add(textAniolanzamiento);
       aux.add(textConsumo);
       return aux;
    }
    
}
