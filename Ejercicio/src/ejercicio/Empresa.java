/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Redes-20
 */
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


}
