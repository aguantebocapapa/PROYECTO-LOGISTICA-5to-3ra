package ejercicio;

import javax.swing.JOptionPane;

public class Ejercicio {
    public static void main(String[] args) {
        String empresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa: ");
        String direccion_emp = JOptionPane.showInputDialog("Ingrese la direccion de la empresa: ");
        String telefono_emp = JOptionPane.showInputDialog("Ingrese el numero de telefono de la empresa: ");
        Empresa e = new Empresa (empresa, direccion_emp, telefono_emp);
        int contador=0;
        int id_persona = 0;
        while (contador==0){
            JOptionPane.showMessageDialog(null, "MENU DE OPCIONES:"
                + "\n 1) Agregar cliente."
                + "\n 2) Agregar empleado."
                + "\n 3) Agregar reporte."
                + "\n 4) Agregar paquete."
                + "\n 5) Agregar producto." 
                + "\n 6) Agregar vehiculo."
                + "\n 7) Agregar adheridos."
                + "\n 8) Buscador universal."
                + "\n 9) Eliminador universal."
                + "\n 10) Editor universal."
                + "\n 11) Mostrar empresa."
                    );
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la opcion que desea realizar:"));
            switch(opcion){
                case 1:
                    int cant_clientes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clientes que desea ingresar: "));
                    int id_cl = 0;
                    for (int i = 0; i < cant_clientes; i++) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente: ");
                        String dni = JOptionPane.showInputDialog("Ingrese el DNI del cliente: ");
                        String email = JOptionPane.showInputDialog("Ingrese el email del cliente: ");
                        String telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
                        id_cl = id_cl+1;
                        String habitual = JOptionPane.showInputDialog("¿Es cliente habitual? Ingrese si o no: ");
                        int cant_compras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de compras del cliente del cliente: "));
                        double presupuesto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el presupuesto del cliente: "));
                        Cliente c = new Cliente (id_cl, habitual, cant_compras, presupuesto,(id_persona + 1), nombre, apellido, dni, email, telefono);
                        e.agregarCliente(c);
                    }
                case 2:
                    int cant_empleados = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de empleados que desea ingresar"));
                    int id_em = 0;
                    for (int i = 0; i < cant_empleados; i++) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente: ");
                        String dni = JOptionPane.showInputDialog("Ingrese el DNI del cliente: ");
                        String email = JOptionPane.showInputDialog("Ingrese el email del cliente: ");
                        String telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
                        id_em = id_em+1;
                        String sector = JOptionPane.showInputDialog("ingrese el sector en donde trabaja el empleado");
                        String cargo = JOptionPane.showInputDialog("ingrese el cargo");
                        String rol = JOptionPane.showInputDialog("ingrese el rol del empleado");
                        Empleado empl = new Empleado (id_em,sector, cargo, rol,(id_persona + 1), nombre, apellido, dni, email, telefono);
                        e.agregarEmpleado(empl);
                    }
           
            }
        
    }
    
    }
}
