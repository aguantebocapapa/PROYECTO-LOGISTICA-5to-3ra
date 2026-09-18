
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Empresa {
    String nombre;
    String direccion;
    String num_tele;
    ArrayList<Cliente>clientes;
    ArrayList<Empleado>empleados;
    ArrayList<Reporte>reportes;
    ArrayList<Envio> envios;
    ArrayList<Paquete> paquetes;
    ArrayList<Producto> productos;
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Empresas_Adheridas> amiguis;
    ArrayList<Ticket> tickets;

    public Empresa(String nombre, String direccion, String num_tele) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.num_tele = num_tele;
        clientes=new ArrayList<>();
        empleados=new ArrayList<>();
        reportes=new ArrayList<>();
        envios=new ArrayList<>();
        paquetes=new ArrayList<>();
        productos=new ArrayList<>();
        vehiculos=new ArrayList<>();
        amiguis=new ArrayList<>();
        tickets=new ArrayList<>();
    }
    public void agregarCliente(Cliente c){
        clientes.add(c);
    }
    public void agregarEmpleado(Empleado e){
        empleados.add(e);
    }
    public void agregarReporte(Reporte r){
        reportes.add(r);
    }
    public void agregarEnvio(Envio e){
        envios.add(e);    
    }
    public void agregarPaquete(Paquete p){
        paquetes.add(p);
    }
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }
    public void agregarAdheridos(Empresas_Adheridas a){
        amiguis.add(a);
    }
    public void agregar_tickets(Ticket a){
        tickets.add(a);
    }
    public int buscador_universal(int id,int opcion){
        int contador=0;
        switch(opcion){
            case 1:
                for(Cliente c:clientes){
                    if(c.getIdCliente()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
            case 2:
                for(Empleado e:empleados){
                    if(e.getIdempleado()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
            case 3:
                for (Reporte r:reportes){
                    if(r.getIdReporte()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
            case 4:
                for(Envio e :envios){
                    if(e.getNumEnvio()==id){
                        return contador;
                    }
                    contador++;
                }
            case 5:
                for(Paquete p:paquetes){
                    if(p.getId_paquete()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
            case 6:
                for(Producto pp:productos){
                    if(pp.getIdproducto()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
            case 7:
                for(Vehiculo v:vehiculos){
                    if(v.getIdvehiculo()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
            case 8:
                for(Empresas_Adheridas ee:amiguis){
                    if(ee.id_empresa==id){
                        return contador;
                    }
                    contador++;
                }
                break;
                
            case 9:
            for(Ticket ee:tickets){
                    if(ee.getIdticket()==id){
                        return contador;
                    }
                    contador++;
                }
                break;
        }
        return -1;
        }
    
    public void eliminado_universal(int id,int opcion){
            int indice=buscador_universal(id,opcion);
            if (indice>-1){
                switch(opcion){
                    case 1:
                        clientes.remove(indice);
                        break;
                    case 2:
                       empleados.remove(indice);
                       break;
                    case 3:
                        reportes.remove(indice);
                        break;
                    case 4:
                        envios.remove(indice);
                        break;
                    case 5:
                        paquetes.remove(indice);
                        break;
                    case 6:
                        productos.remove(indice);
                        break;
                    case 7:
                        vehiculos.remove(indice);
                        break;
                    case 8:
                        amiguis.remove(indice);
                        break;
                    case 9:
                        tickets.remove(indice);
                        break;
                }
            }
}
    public void editar_cliente(int id,String nuevoNombre, String nuevoApellido,String nuevoDni,String nuevoEmail,String nuevoNumero,String nuevoHabitual,int nuevoCantComp,double nuevoPresupuesto ){
        int indice=buscador_universal(id,1);
        Cliente cliente =clientes.get(indice);
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "No se encontro una persona con ese indice");
            return;
            }
        cliente.setNombre(nuevoNombre);
        cliente.setApellido(nuevoApellido);
        cliente.setDni(nuevoDni);
        cliente.setEmail(nuevoEmail); 
        cliente.setNumero_telefono(nuevoNumero);
        cliente.setHabitual(nuevoHabitual);
        cliente.setCantcomp(nuevoCantComp);
        cliente.setPresupuesto(nuevoPresupuesto);
                
    }
    public void editar_empleado(int id,String nuevoNombre2,String nuevoApellido2 ,String nuevoDni2,String nuevoEmail2,String nuevoNumero2,String nuevoSector,String nuevoCargo,String nuevoRol){
        int indice=buscador_universal(id,2);
        Empleado empleado =empleados.get(indice);
                    if(empleado == null){
                        JOptionPane.showMessageDialog(null, "No se encontro una persona con ese indice");
                    return;
                    }
        empleado.setNombre(nuevoNombre2);
                    empleado.setApellido(nuevoApellido2);
                    empleado.setDni(nuevoDni2);
                    empleado.setEmail(nuevoEmail2); 
                    empleado.setNumero_telefono(nuevoNumero2);
                    empleado.setSector(nuevoSector);
                    empleado.setCargo(nuevoCargo);
                    empleado.setRol(nuevoRol);
    }
    public void editar_reporte(int id, String nuevoDetalle){
        int indice=buscador_universal(id,3);
        Reporte reporte = reportes.get(indice);
                      if(reporte == null){
                          JOptionPane.showMessageDialog(null, "No se encontro un reporte con ese indice");
                          return;
                      }
        reporte.setDetalle(nuevoDetalle);
    }
    public void editar_envio(int id, String nuevaFecha, String nuevoOrigen, String nuevoDestino){
       int indice=buscador_universal(id,4);
        Envio envio = envios.get(indice);
                      if(envio == null){
                          JOptionPane.showMessageDialog(null, "No se encontro un envio con ese indice.");
                          return;
                      } 
        envio.setDestino(nuevoDestino);
                      envio.setFecha(nuevaFecha);
                      envio.setOrigen(nuevoOrigen);
    }
    public void editar_paquete(int id,double nuevoPeso,double nuevoVolumen,String nuevoFecha_ensamble ){
        int indice=buscador_universal(id,5);
        Paquete paquete = paquetes.get(indice);
                    if(paquete == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un paquete con ese indice.");
                          return;
                    }
        paquete.setFecha_ensamble(nuevoFecha_ensamble);
                    paquete.setPeso(nuevoPeso);
                    paquete.setVolumen(nuevoVolumen);
        
    }
    public void editar_producto(int id,String nuevoNombreMarca,String nuevoDescripcion,double nuevoPrecio,int nuevoStock,String nuevoTipo){
        int indice=buscador_universal(id,6);
        Producto producto = productos.get(indice);
                    if(producto == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un producto con ese indice.");
                          return;
                    }
        producto.setDescripcion(nuevoDescripcion);
                    producto.setNombremarca(nuevoNombreMarca);
                    producto.setPrecio(nuevoPrecio);
                    producto.setStock(nuevoStock);
                    producto.setTipo(nuevoTipo);
    }
    public void editar_vehiculo(int id,String nuevoModelo,String nuevaMarca,int nuevoPrecio2,int nuevoAnio,String nuevoTipo2){
        int indice=buscador_universal(id,7);
        Vehiculo vehiculo = vehiculos.get(indice);
                    if(vehiculo == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un vehiculo con ese indice.");
                          return;
                    }
        vehiculo.setAnio(nuevoAnio);
                    vehiculo.setMarca(nuevaMarca);
                    vehiculo.setModelo(nuevoModelo);
                    vehiculo.setPrecio(nuevoPrecio2);
                    vehiculo.setTipo(nuevoTipo2);
    }
    public void editar_adherida(int id,String nuevoNombre3,String nuevaCuil,String nuevaDireccion,String nuevoTelefono,String nuevoRubro,String nuevoDuenio){
        int indice=buscador_universal(id,8);
        Empresas_Adheridas empresa = amiguis.get(indice);
        if(empresa == null){
                        JOptionPane.showMessageDialog(null, "No se encontro una empresa_adherida con ese indice.");
                          return;
                    }
        empresa.setNombre(nuevoNombre3);
                    empresa.setCuil(nuevaCuil);
                    empresa.setDireccion(nuevaDireccion);
                    empresa.setTelefono(nuevoTelefono);
                    empresa.setRubro(nuevoRubro);
                    empresa.setDuenio(nuevoDuenio);
    }
    public void editar_ticket(int id, String nueva_fecha, int Nuevototal,String nuevoPago){
        int indice=buscador_universal(id,9);
        Ticket ticket=tickets.get(indice);
        if(ticket==null){
            JOptionPane.showMessageDialog(null,"No se encontro un ticket con ese indice");
            return;
        }
        ticket.setPago(nuevoPago);
        ticket.setFecha(nueva_fecha);
        ticket.setTotal(Nuevototal);
    }
    
    
                
               
                    
    
    

}
