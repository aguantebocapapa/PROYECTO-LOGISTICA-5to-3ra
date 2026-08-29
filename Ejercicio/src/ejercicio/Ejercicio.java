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
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la opcion que desea realizar:"
            + "\n 1) Agregar cliente."
                + "\n 2) Agregar empleado."
                + "\n 3) Agregar reporte."
                + "\n 4) Agregar envio."
                + "\n 5) Agregar paquete."
                + "\n 6) Agregar producto." 
                + "\n 7) Agregar vehiculo."
                + "\n 8) Agregar adheridos."
                + "\n 9) Buscador universal."
                + "\n 10) Eliminador universal."
                + "\n 11) Editor universal."
                + "\n 12) Mostrar empresa."));
            switch(opcion){
                case 1:
                    int cant_clientes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clientes que desea ingresar: "));
                    for (int i = 0; i < cant_clientes; i++) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente: ");
                        String dni = JOptionPane.showInputDialog("Ingrese el DNI del cliente: ");
                        String email = JOptionPane.showInputDialog("Ingrese el email del cliente: ");
                        String telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
                        int id_cl = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del cliente: "));
                        String habitual = JOptionPane.showInputDialog("¿Es cliente habitual? Ingrese si o no: ");
                        int cant_compras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de compras del cliente del cliente: "));
                        double presupuesto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el presupuesto del cliente: "));
                        Cliente c = new Cliente (id_cl, habitual, cant_compras, presupuesto,(id_persona + 1), nombre, apellido, dni, email, telefono);
                        e.agregarCliente(c);
                    }
                     break;
                case 2:             
                    int cant_empleados = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de empleados que desea ingresar"));
                    for (int i = 0; i < cant_empleados; i++) {
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente: ");
                        String dni = JOptionPane.showInputDialog("Ingrese el DNI del cliente: ");
                        String email = JOptionPane.showInputDialog("Ingrese el email del cliente: ");
                        String telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono del cliente: ");
                        int id_em =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del empleado: "));
                        String sector = JOptionPane.showInputDialog("ingrese el sector en donde trabaja el empleado");
                        String cargo = JOptionPane.showInputDialog("ingrese el cargo");
                        String rol = JOptionPane.showInputDialog("ingrese el rol del empleado");
                        Empleado empl = new Empleado (id_em,sector, cargo, rol,(id_persona + 1), nombre, apellido, dni, email, telefono);
                        e.agregarEmpleado(empl);
                    }
                     break;
                case 3:
                    int cant_reportes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de reportes que desea ingresar"));
                    for (int i = 0; i < cant_reportes; i++) {
                        int id_rep = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del reporte: "));
                        String detalle = JOptionPane.showInputDialog("ingrese el detalle del reporte: ");
                        Reporte rep = new Reporte (id_rep, detalle);
                        int cant_ticket=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de tickets a añadir :"));
                        for(int x=0;<cant_ticket;x++){
                            int idx=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del ticket :"));
                            String fechas=JOptionPane.showInputDialog("Ingrese la fecha del pago .");
                            int totalx=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total del pago :"));
                            String pagos=JOptionPane.showInputDialog("Ingrese el metodo de pago :");
                            int idxx=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente del ticket :"));
                            int indice=e.buscador_universal(idxx,1);
                            Cliente c=e.clientes.get(indice);
                            Ticket t=new Ticket(idx,fechas,c,totalx,pagos);
                            rep.agregarTicket(t);
                        }
                        e.agregarReporte(rep);
                    }
                     break;
                
                case 4:
                    int cant_envios = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de envios que desea ingresar"));
                    for (int i = 0; i < cant_envios; i++) {
                        String fecha = JOptionPane.showInputDialog("ingrese la fecha que se realizó el envio: ");
                        String origen =JOptionPane.showInputDialog("ingrese el origen del envío");
                        String destino = JOptionPane.showInputDialog("ingrese a donde irá el envío");
                        int id_env= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del envio: "));
                        Envio env = new Envio (id_env, fecha, origen, destino);
                        e.agregarEnvio(env);
                    }
                     break;
                case 5:
                    int cant_paq = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de paquetes que desea ingresar: "));
                    for (int i = 0; i < cant_paq; i++) {
                        double peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese el peso del paquete (en kg): "));
                        double volumen = Double.parseDouble(JOptionPane.showInputDialog("ingrese el volumen del paquete: "));
                        String fecha_ensamble = JOptionPane.showInputDialog("ingrese la fecha de ensamblado del paquete: ");
                        int id_paq = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del paquete: "));
                        Paquete paq = new Paquete (id_paq, peso, volumen, fecha_ensamble);
                        e.agregarPaquete(paq);
                        
                    }
                    break;
                case 6:
                    int cant_productos = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de productos que desea ingresar: "));
                    for (int i = 0; i < cant_productos; i++) {
                        String Nombremarca = JOptionPane.showInputDialog("ingrese el nombre de la marca del producto: ");
                        String Descripcion = JOptionPane.showInputDialog("ingrese la descripcion del producto: ");
                        double precio = Double.parseDouble(JOptionPane.showInputDialog("ingrese el precio del producto: "));
                        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de stock del producto ")); 
                        String  tipo = JOptionPane.showInputDialog("ingrese que tipo de producto es : ");
                        int id_pro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del producto: "));
                        Producto pro = new Producto (id_pro, Nombremarca, Descripcion, precio, stock, tipo );
                        e.agregarProducto(pro);
                    }
                    break;
                case 7:
                    int cant_vehiculos = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de vehiculos que desea ingresar: "));
                    for (int i = 0; i < cant_vehiculos; i++) {
                        String modelo = JOptionPane.showInputDialog("ingrese el modelo del vehiculo: ");
                        String marca = JOptionPane.showInputDialog("ingrese la marca del vehiculo: ");
                        int precio = Integer.parseInt(JOptionPane.showInputDialog("ingrese el precio del vehiculo: "));
                        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del vehiculo: ")); 
                        String  tipo = JOptionPane.showInputDialog("ingrese que tipo de vehiculo es : ");
                        int id_veh = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del vehiculo: "));
                        Vehiculo veh = new Vehiculo (id_veh, modelo, marca, precio, anio, tipo );
                        e.agregarVehiculo(veh);
                    }
                    break;
                case 8:
                    int cant_adheridos = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de empresas adheridas que desea ingresar: "));
                    for (int i = 0; i < cant_adheridos; i++) {
                        String Nombre   = JOptionPane.showInputDialog("ingrese el nombre de la empresa adherida: ");
                        String cuil     = JOptionPane.showInputDialog("ingrese el cuil de la empresa adherida : ");
                        String direccion  = JOptionPane.showInputDialog("ingrese la direccion de la empresa adherida: ");
                        String telefono  = JOptionPane.showInputDialog("ingrese el telefono de la empresa adherida: ");
                        String rubro  = JOptionPane.showInputDialog("ingrese el rubro de la empresa adherida: ");
                        String duenio  = JOptionPane.showInputDialog("ingrese el dueño de la empresa adherida: ");
                        int id_ad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador de la empresa adherida: "));
                        Empresas_Adheridas ad = new Empresas_Adheridas (id_ad, Nombre, cuil, direccion, telefono, rubro, duenio);
                        e.agregarAdheridos(ad);
                    }
                    break;
                
                case 9:
                    /*
                    int  indice=e.buscador_universal(1, 1);
                    Cliente  c =e.clientes.get(indice);
                    c.mostrarPersona();
                    */
                    int opcion_buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero correspondiente a la opcion que desea buscar "
                        + "\n 1) Clientes." 
                        + "\n 2) Empleados." 
                        + "\n 3) Reportes." 
                        + "\n 4) Envios." 
                        + "\n 5) Paquetes." 
                        + "\n 6) Productos." 
                        + "\n 7) Vehiculos." 
                        + "\n 8) Empresas adheridas.")); 
                    int id_buscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id que desea buscar: "));
                    int coco=e.buscador_universal(id_buscar, opcion_buscar);
                    switch(opcion_buscar){
                        case 1:
                            Cliente c=e.clientes.get(coco);
                            c.mostrarPersona();
                            break;
                        case 2:
                            Empleado  es=e.empleados.get(coco);
                            es.mostrarPersona();
                            break;
                        case 3:
                            Reporte r=e.reportes.get(coco);
                            r.mostrar();
                            break;
                        case 4:
                             Envio ess=e.envios.get(coco);
                             ess.Mostrar_envio();
                             break;
                        case  5:
                            Paquete pp=e.paquetes.get(coco);
                            pp.MostrarPaquete();
                            break;
                        case 6:
                            Producto ppp=e.productos.get(coco);
                            ppp.mostrarDatos();
                            break;
                        case 7:
                            Vehiculo v=e.vehiculos.get(coco);
                            v.mostrar();
                            break;
                        case 8:
                            Empresas_Adheridas emm=e.amiguis.get(coco);
                            emm.mostrarEmpreesa();
                            break;
                    }
                    
                    break;
                case 10:
                    int opcion_eliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero correspondiente a la opcion que desea eliminar "
                        + "\n 1) Clientes." 
                        + "\n 2) Empleados." 
                        + "\n 3) Reportes." 
                        + "\n 4) Envios." 
                        + "\n 5) Paquetes." 
                        + "\n 6) Productos." 
                        + "\n 7) Vehiculos." 
                        + "\n 8) Empresas adheridas.")); 
                    int id_eliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id que desea eliminar: "));
                    e.eliminado_universal(id_eliminar, opcion_eliminar);
                    break;
                case 11:
                    int opcion_editar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero correspondiente a la opcion que desea editar "
                        + "\n 1) Clientes." 
                        + "\n 2) Empleados." 
                        + "\n 3) Reportes." 
                        + "\n 4) Envios." 
                        + "\n 5) Paquetes." 
                        + "\n 6) Productos." 
                        + "\n 7) Vehiculos." 
                        + "\n 8) Empresas adheridas.")); 
                    int id_editar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id que desea editar: "));
                    e.editar_universal(id_editar, opcion_editar);
                    break;
                case 12:
                    e.mostrar_empresa();
                    break;
            }   
                 
            
        
    }
    
    }
}
