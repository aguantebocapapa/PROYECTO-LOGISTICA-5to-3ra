create view vehiculo_empleado as select vehiculos.ID_Vehiculo, vehiculos.Marca, vehiculos.Modelo, empleados.Nombre,empleados.Apellido,empleados.Dni from vehiculos left join empleados on empleados.ID_Empleado = vehiculos.ID_Empleado;

create view envios_noentregados as select * from envios
where estado = "NO ENTREGADO";

create view envios_cancelados as select * from envios
where estado = "CANCELADO";

create view administradores as select * from empleados
where empleados.rol = "ADMINISTRADOR";

create view Productos_critico as select * from productos
where productos.stock <10;

create view Paquetes_pesados as select * from paquetes
where paquetes.peso <100;
