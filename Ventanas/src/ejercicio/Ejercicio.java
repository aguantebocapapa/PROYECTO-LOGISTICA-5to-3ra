package ejercicio;
import javax.swing.JOptionPane;
public class Ejercicio {
    public static void main(String[] args) {
        Empresa em=new Empresa("Logistica 32","Teodoro Garcia","+54-911-0111-0111");
        int contador=0;
        Inicio ventana_nueva=new Inicio(contador,em);
        ventana_nueva.setVisible(true);
        ventana_nueva.setLocationRelativeTo(null);
        
               
    }
}


