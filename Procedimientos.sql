delimiter //
create procedure Productos_paquete(in ID_paque int)
BEGIN
	select productos.marca,productos.descripcion, productos.stock from productos 
    inner join productos_paquetes on 
productos_paquetes.ID_Producto=productos.ID_Producto
   	where ID_paque=productos_paquetes.ID_Paquete;
    end//
delimiter;

delimiter //
create procedure Tickets_reporte(in ID_repor int)
BEGIN
	select tickets.detalle,tickets.total,tickets.metodospago , clientes.Nombre, clientes.Apellido
    from tickets
    inner join clientes on clientes.ID_Cliente=tickets.ID_Ticket
    inner join reportes_ticket on reportes_ticket.ID_Ticket=tickets.ID_Ticket
    where reportes_ticket.ID_Reporte=ID_repor;
    end//
delimiter;

delimiter //
create procedure Vehiculos_envio(in ID_envi int)
BEGIN
	select vehiculos.Marca,vehiculos.Modelo,vehiculos.ID_Vehiculo
    from vehiculos
    inner join envio_vehiculos on envio_vehiculos.ID_Vehiculo=vehiculos.ID_Vehiculo
    where envio_vehiculos.ID_Envio=ID_envi;
    end//
delimiter;

delimiter //
create procedure paqutes_envio(in ID_envi int)
BEGIN
	select paquetes.ID_Paquete, paquetes.peso,paquetes.volumen
    from paquetes
    inner join envio_paquetes on envio_paquetes.ID_Paquete=paquetes.ID_Paquete
    where envio_paquetes.ID_Envio=ID_envi;
    end//
delimiter;
