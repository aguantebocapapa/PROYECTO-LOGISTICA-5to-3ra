
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
                }
            }
}



    public void mostrar_empresa(){
        JOptionPane.showMessageDialog(null, "Nombre : " + nombre+" Direccion " + direccion+" Numero de telefono " + num_tele);
        for(Cliente p:clientes){
            p.mostrarPersona();
        }
        for(Empleado d:empleados){
            d.mostrarPersona();
        }
        for(Reporte rr:reportes){
            rr.mostrar();
        }
        for(Envio e:envios){
            e.Mostrar_envio();
        }
        for(Paquete q:paquetes){
            q.MostrarPaquete();
        }
        for(Producto r:productos){
            r.mostrarDatos();
        }
        for(Vehiculo v:vehiculos){
            v.mostrar();
        }
        for(Empresas_Adheridas s:amiguis){
            s.mostrarEmpreesa();
        }
    }
    
    public void editar_universal(int id, int opcion){
        int indice=buscador_universal(id,opcion);
        if (indice>-1){
               switch(opcion){
                   //EDITOR DE CLIENTES
                case 1:
                    Cliente cliente =clientes.get(indice);
                    if(cliente == null){
                        JOptionPane.showMessageDialog(null, "No se encontro una persona con ese indice");
                    break;
                    }
                    // Editar datos del cliente
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                    String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido");
                    String nuevoDni = JOptionPane.showInputDialog("Ingrese el nuevo DNI");
                    String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo mail");
                    String nuevoNumero = JOptionPane.showInputDialog("Ingrese el nuevo numero de telefono");
                    String nuevoHabitual = JOptionPane.showInputDialog("Es cliente habitual?");
                    int nuevoCantComp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de compras"));
                    double nuevoPresupuesto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo presupuesto"));
                    cliente.setNombre(nuevoNombre);
                    cliente.setApellido(nuevoApellido);
                    cliente.setDni(nuevoDni);
                    cliente.setEmail(nuevoEmail); 
                    cliente.setNumero_telefono(nuevoNumero);
                    cliente.setHabitual(nuevoHabitual);
                    cliente.setCantcomp(nuevoCantComp);
                    cliente.setPresupuesto(nuevoPresupuesto);
                    //El cliente.set sirve para establecer los nuevos valores agregados (nuevoNombre x ejemplo)
                    //Dentro del valor original (Nombre). 
                break;
                
                // EDITOR DE EMPLEADOS
                case 2:
                    Empleado empleado =empleados.get(indice);
                    if(empleado == null){
                        JOptionPane.showMessageDialog(null, "No se encontro una persona con ese indice");
                    break;
                    }
                    // Editar datos del EMPLEADO
                    String nuevoNombre2 = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                    String nuevoApellido2 = JOptionPane.showInputDialog("Ingrese el nuevo apellido");
                    String nuevoDni2 = JOptionPane.showInputDialog("Ingrese el nuevo DNI");
                    String nuevoEmail2 = JOptionPane.showInputDialog("Ingrese el nuevo mail");
                    String nuevoNumero2 = JOptionPane.showInputDialog("Ingrese el nuevo numero de telefono");
                    String nuevoSector = JOptionPane.showInputDialog("Ingrese el nuevo sector");
                    String nuevoCargo = JOptionPane.showInputDialog("Ingrese el nuevo cargo");
                    String nuevoRol = JOptionPane.showInputDialog("Ingrese el nuevo rol");
                    empleado.setNombre(nuevoNombre2);
                    empleado.setApellido(nuevoApellido2);
                    empleado.setDni(nuevoDni2);
                    empleado.setEmail(nuevoEmail2); 
                    empleado.setNumero_telefono(nuevoNumero2);
                    empleado.setSector(nuevoSector);
                    empleado.setCargo(nuevoCargo);
                    empleado.setRol(nuevoRol);
                    
                    //EDITOR DE REPORTES
                    break;
                case 3:
                      Reporte reporte = reportes.get(indice);
                      if(reporte == null){
                          JOptionPane.showMessageDialog(null, "No se encontro un reporte con ese indice");
                          break;
                      }
                      // EDITAR DATOS DEL REPORTES
                      String nuevoDetalle = JOptionPane.showInputDialog("Ingrese los nuevos detalles.");
                      reporte.setDetalle(nuevoDetalle);
                
                      //EDITOR DE ENVIO
                      break;
                case 4:
                      Envio envio = envios.get(indice);
                      if(envio == null){
                          JOptionPane.showMessageDialog(null, "No se encontro un envio con ese indice.");
                          break;
                      }
                      //EDITAR DATOS DEL ENVIO
                      String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha.");
                      String nuevoOrigen = JOptionPane.showInputDialog("Ingrese el nuevo origen.");
                      String nuevoDestino = JOptionPane.showInputDialog("Ingrese los nuevos detalles.");
                      envio.setDestino(nuevoDestino);
                      envio.setFecha(nuevaFecha);
                      envio.setOrigen(nuevoOrigen);
                      
                      // EDITOR DE PAQUETES
                      break;
                case 5:
                    Paquete paquete = paquetes.get(indice);
                    if(paquete == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un paquete con ese indice.");
                          break;
                    }
                    
                    //EDITAR DATOS DEL PAQUETE
                    double nuevoPeso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo peso."));
                    double nuevoVolumen = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo volumen."));
                    String nuevoFecha_ensamble = JOptionPane.showInputDialog("Ingrese el nuevo peso.");
                    paquete.setFecha_ensamble(nuevoFecha_ensamble);
                    paquete.setPeso(nuevoPeso);
                    paquete.setVolumen(nuevoVolumen);
                    break;
                case 6:
                    Producto producto = productos.get(indice);
                    if(producto == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un producto con ese indice.");
                          break;
                    }
                    String nuevoNombreMarca = JOptionPane.showInputDialog("Ingrese el nuevo nombre de marca.");
                    String nuevoDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripcion.");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio."));
                    int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de stock"));
                    String nuevoTipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo.");
                    producto.setDescripcion(nuevoDescripcion);
                    producto.setNombremarca(nuevoNombreMarca);
                    producto.setPrecio(nuevoPrecio);
                    producto.setStock(nuevoStock);
                    producto.setTipo(nuevoTipo);
                    break;
                    
                case 7:
                    Vehiculo vehiculo = vehiculos.get(indice);
                    if(vehiculo == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un vehiculo con ese indice.");
                          break;
                    }
                    String nuevoModelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo.");
                    String nuevaMarca = JOptionPane.showInputDialog("Ingrese la nueva marca.");
                    int nuevoPrecio2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                    int nuevoAnio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año"));
                    String nuevoTipo2 = JOptionPane.showInputDialog("Ingrese el nuevo tipo.");
                    vehiculo.setAnio(nuevoAnio);
                    vehiculo.setMarca(nuevaMarca);
                    vehiculo.setModelo(nuevoModelo);
                    vehiculo.setPrecio(nuevoPrecio2);
                    vehiculo.setTipo(nuevoTipo2);
                    break;
                    
                case 8:
                    Empresas_Adheridas empresa = amiguis.get(indice);
                    if(empresa == null){
                        JOptionPane.showMessageDialog(null, "No se encontro un vehiculo con ese indice.");
                          break;
                    }
                    /*String nombre;
                    String cuil;
                    String direccion;
                    String telefono;
                    String rubro;
                    String duenio;*/
                    String nuevoNombre3 = JOptionPane.showInputDialog("Ingrese el nuevo nombre.");
                    String nuevaCuil = JOptionPane.showInputDialog("Ingrese el nuevo cuil.");
                    String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva direccion.");
                    String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo numero telefonico.");
                    String nuevoRubro = JOptionPane.showInputDialog("Ingrese el nuevo rubro.");
                    String nuevoDuenio = JOptionPane.showInputDialog("Ingrese el nuevo dueño.");
                    empresa.setNombre(nuevoNombre3);
                    empresa.setCuil(nuevaCuil);
                    empresa.setDireccion(nuevaDireccion);
                    empresa.setTelefono(nuevoTelefono);
                    empresa.setRubro(nuevoRubro);
                    empresa.setDuenio(nuevoDuenio);
                    break;
               }
                
               
                    
    }}


}
