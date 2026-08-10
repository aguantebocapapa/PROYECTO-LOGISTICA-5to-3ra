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
    public Cliente buscarCliente(int id){
        for(Cliente c:clientes){
            if(c.getIdCliente()==id){
                return c;
            }
        }
        return null;
    }
    public Empleado buscarEmpleado(int id){
        for(Empleado c:empleados){
            if(c.getIdempleado()==id){
                return c;
            }
        }
        return null;
    }
    public Reporte buscarReporte(int id){
        for(Reporte c:reportes){
            if(c.getIdReporte()==id){
                return c;
            }
        }
        return null;
    }
    public Envio buscarEnvio(int id){
        for(Envio c:envios){
            if(c.getNumEnvio()==id){
                return c;
            }
        }
        return null;
    }
    public Paquete buscarPaquete(int id){
        for(Paquete c:paquetes){
            if(c.getId_paquete()==id){
                return c;
            }
        }
        return null;
    }
    public Producto buscarProducto(int id){
        for(Producto c:productos){
            if(c.getIdproducto()==id){
                return c;
            }
        }
        return null;
    }
    public Vehiculo buscarVehiculo(int id){
        for(Vehiculo c:vehiculos){
            if(c.getIdvehiculo()==id){
                return c;
            }
        }
        return null;
    }
    public Empresas_Adheridas buscarAdheridos(int id){
        for(Empresas_Adheridas c:amiguis){
            if(c.id_empresa==id){
                return c;
            }
        }
        return null;
    }
    public void eliminar_Cliente(int id){
        Cliente c=buscarCliente(id);
        if(c!=null){
            clientes.remove(c);
        }
    }
    public void eliminar_Empleado(int id){
        Empleado c=buscarEmpleado(id);
        if(c!=null){
            empleados.remove(c);
        }
    }
    public void eliminar_Reporte(int id){
        Reporte c=buscarReporte(id);
        if(c!=null){
            reportes.remove(c);
        }
    }
    public void eliminar_Envio(int id){
        Envio c=buscarEnvio(id);
        if(c!=null){
            envios.remove(c);
        }
    }
    public void eliminar_Paquete(int id){
        Paquete c=buscarPaquete(id);
        if(c!=null){
            paquetes.remove(c);
        }
    }
    public void eliminar_Producto(int id){
        Producto c=buscarProducto(id);
        if(c!=null){
            productos.remove(c);
        }
    }
    public void eliminar_Vehiculo(int id){
        Vehiculo c=buscarVehiculo(id);
        if(c!=null){
            vehiculos.remove(c);
        }
    }
    public void eliminar_Adhe(int id){
        Empresas_Adheridas c=buscarAdheridos(id);
        if(c!=null){
            amiguis.remove(c);
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
