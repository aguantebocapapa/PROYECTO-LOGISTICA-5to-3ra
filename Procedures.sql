drop procedure agregar_productos_paquetes;
agregar_productos_paquetes DELIMITER //
CREATE PROCEDURE agregar_productos(
    IN marca VARCHAR(100),
    in descripcion varchar(200),
    in precio decimal (10,2),
    in stock int,
    in categoria varchar (50),
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET mensaje = 'Error: operación revertida';
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO productos( marca, descripcion,precio , stock,categoria )
    VALUES ( marca, descripcion, precio, stock, categoria);

    COMMIT;
    SET mensaje = 'Hecho con éxito';
END//
DELIMITER ;
delimiter //
create procedure borrar_producto(in p_producto int , out mensaje varchar(100))
	BEGIN
    	DECLARE v_producto int default 0;
        start transaction;
        select count(id_producto) into v_producto
        from productos_paquetes
        where productos_paquetes.ID_Producto = p_producto;
        
        if v_producto > 0 THEN
        	set mensaje="El producto esta en un paquete";
            ROLLBACK;
        else
        	delete from productos
            where id_producto = p_producto;
            COMMIT;
            set mensaje = 'Producto Eliminado con Éxito.';
        end if;
end//
delimiter;
DELIMITER //

CREATE PROCEDURE editar_productos(
    IN p_id_producto INT,
    IN p_Marca VARCHAR(200),
    IN p_Descripcion VARCHAR(200),
    IN p_Precio DECIMAL(10,2),
    IN p_Stock INT,
    IN p_Categoria VARCHAR(200),
    OUT p_mensaje VARCHAR(200)
)
BEGIN
    DECLARE auxiliar VARCHAR(100);
    
    START TRANSACTION;
        SELECT productos.Marca INTO auxiliar FROM productos WHERE productos.ID_Producto = p_id_producto;
        
        IF auxiliar IS NULL THEN
            SET p_mensaje = 'No existe el producto';
            ROLLBACK;
        ELSE 
            UPDATE productos
            SET 
                Marca = IFNULL(p_Marca, Marca),
                Descripcion = IFNULL(p_Descripcion, Descripcion),
                Precio = IFNULL(p_Precio, Precio),
                Stock = IFNULL(p_Stock, Stock),
                Categoria = IFNULL(p_Categoria, Categoria)
            WHERE ID_Producto = p_id_producto;
            
            COMMIT;
            SET p_mensaje = 'Producto actualizado correctamente';
        END IF;
END //

DELIMITER ;
DELIMITER //
CREATE PROCEDURE agregar_productos_paquetes(
    IN ID_Productos int,
    in ID_Paquetes int,
    in cantidads int,
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET mensaje = 'Error: operación revertida';
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO productos_paquetes ( ID_Producto, ID_Paquete ,cantidad)
    VALUES (ID_Productos, ID_Paquetes ,cantidads);

    COMMIT;
    SET mensaje = 'Hecho con éxito';
END//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE borrar_producto_paquete(IN p_id_propa INT, OUT mensaje VARCHAR(100))
BEGIN
                DELETE FROM Productos_Paquetes
                WHERE ID_Propa = p_id_propa;
                SET mensaje = 'Producto eliminado del paquete correctamente.';
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE borrar_producto_paquete2(IN p_id_propa INT)
BEGIN
   delete from productos_paquetes where ID_Paquete=p_id_propa;
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE agregar_paquetes(
    IN peso decimal(9,2),
    in volumen decimal(9,2),
    in fecha_ensamble date,
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET mensaje = 'Error: operación revertida';
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO paquetes ( peso, volumen, fecha_ensamble)
    VALUES (peso, volumen, fecha_ensamble);

    COMMIT;
    SET mensaje = 'Hecho con éxito';
END//
DELIMITER ;
DELIMITER //

CREATE PROCEDURE editar_paquetes(
    IN id_paquetes INT,
    IN peso DECIMAL(9,2),
    IN volumen DECIMAL(9,2),
    IN fecha_ensamble DATE,
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE auxiliar DECIMAL(9,2); 
    
    START TRANSACTION;
        SELECT paquetes.Peso INTO auxiliar FROM paquetes WHERE paquetes.ID_Paquete= id_paquetes;
        
        IF auxiliar IS NULL THEN
            SET mensaje = 'No existe el paquete';
            ROLLBACK;
        ELSE 
            IF peso IS NOT NULL THEN
                UPDATE paquetes SET paquetes.Peso = peso WHERE paquetes.ID_Paquete = id_paquetes;
            END IF;
            
            IF volumen IS NOT NULL THEN
                UPDATE paquetes SET paquetes.Volumen = volumen WHERE paquetes.ID_Paquete = id_paquetes;
            END IF;
            
            IF fecha_ensamble IS NOT NULL THEN
                UPDATE paquetes SET paquetes.Fecha_Ensamble = fecha_ensamble WHERE paquetes.ID_Paquete = id_paquetes;
            END IF;
            
            COMMIT;
            SET mensaje = 'Paquete actualizado correctamente';
        END IF;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE borrar_paquete(IN id_paquete_aborrar INT, OUT mensaje VARCHAR(100))
BEGIN
    DECLARE contador_envio_paquetes INT DEFAULT 0;
    DECLARE contador_productos_paquetes INT DEFAULT 0;
    
    START TRANSACTION;
        SELECT COUNT(Envio_Paquetes.ID_ep) INTO contador_envio_paquetes 
        FROM Envio_Paquetes 
        WHERE Envio_Paquetes.ID_Paquete = id_paquete_aborrar;
        SELECT COUNT(Productos_Paquetes.ID_Propa) INTO contador_productos_paquetes 
        FROM Productos_Paquetes 
        WHERE Productos_Paquetes.ID_Paquete = id_paquete_aborrar;
        IF contador_envio_paquetes > 0 THEN
            SET mensaje = 'No se puede eliminar el paquete ya está asignado a un envío.';
            ROLLBACK;
        ELSEIF contador_productos_paquetes > 0 THEN
            SET mensaje = 'No se puede eliminar: el paquete todavía contiene productos.';
            ROLLBACK;
        ELSE
            DELETE FROM Paquetes
            WHERE Paquetes.ID_Paquete = id_paquete_aborrar;
            
            COMMIT;
            SET mensaje = 'Paquete eliminado con éxito.';
        END IF;
END //

DELIMITER ;

DELIMITER //
create procedure buscar_paquetes(in id_ing int)
begin
select * from paquetes  
where paquetes.ID_Paquete = id_ing;
end // 
DELIMITER ;

DELIMITER //
create procedure buscar_producto_paquete(in id_ing int)
begin
select * from producto_paquete
where producto_paquete.ID_producto_paquete = id_ing;
end // 
DELIMITER ;
DELIMITER //
create procedure buscar_productos(in id_ing int)
begin
select * from productos 
where productos.ID_producto = id_ing;
end // 
DELIMITER ;

delimiter //
create procedure mostrar_productos()
	BEGIN
    	select * from productos;
END//
DELIMITER ;


delimiter //
create procedure mostrar_productos_paquetes()
	BEGIN
    	select * from productos_paquetes;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE Buscar_productoID(in id_producto int)
BEGIN
    	select * from productos where productos.ID_Producto=id_producto;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE Buscar_paquetesID(in id_paquetes int)
BEGIN
    	select * from paquetes where paquetes.ID_Paquetes=id_paquetes;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE Buscar_productos_paquetesID(in id_productos_paquetes int)
BEGIN
    	select *
 from productos_paquetes
 where productos_paquetes.ID_productos_paquetes=id_productos_paquetes;
END //
DELIMITER ;

DELIMITER // 

CREATE PROCEDURE buscar_paquetes_peso(IN p_peso VARCHAR(10)) 
BEGIN
    SELECT * FROM Paquetes 
    WHERE INSTR(peso, p_peso) > 0; 
END // 

DELIMITER ;

drop procedure if exists buscar_producto_por_marca;
DELIMITER //
create procedure buscar_producto_por_marca(in marca_ing varchar(100))
begin
select * from producto
where Marca = marca_ing;
end // 
DELIMITER ;
drop procedure if exists buscar_producto_por_precio;
DELIMITER //
create procedure buscar_producto_por_precio(in precio_ing varchar(100))
begin
select * from producto
where Precio = precio_ing;
end // 
DELIMITER ;
 

drop procedure if exists buscar_producto_fecha_ensamble;
DELIMITER //
create procedure buscar_producto_fecha_ensamble(in fecha_ensamble_ing varchar(100))
begin
select * from fecha_ensamble
where Precio = fecha_ensamble_ing ;
end // 
DELIMITER ;


drop procedure if exists buscar_producto_paquete;
DELIMITER //
create procedure buscar_producto_paquete(in id_ing int)
begin
select * from productos_paquetes 
where cantidad = cantidad_ing;
end // 
DELIMITER ;

drop procedure if exists agregar_empleados;
DELIMITER //
create procedure agregar_empleados(in Nombre varchar(50), in Apellido varchar(50), in Dni int(8), in email varchar(100), in telefono int (10), in sector varchar(100), in cargo varchar(100), in rol varchar(100), out mensaje varchar(75))
begin
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    begin
        SET mensaje = "Error. Operacion cancelada";
        rollback;
    end;
    start transaction;
    insert into empleados(Nombre, Apellido, Dni, email, telefono, sector, cargo, rol)
    values (Nombre, Apellido, Dni, email, telefono, sector, cargo, rol);
    commit;
    set mensaje = "Empleado registrado correctamente.";
end//
DELIMITER ;

drop procedure if exists editar_empleados;
DELIMITER //
create procedure editar_empleados (in ID int, in Nombre_ing varchar(50), in Apellido_ing varchar(50), in Dni_ing int(8), in email_ing varchar(100), in telefono_ing int (10), in sector_ing varchar(100), in cargo_ing varchar(100), in rol_ing varchar(100), out mensaje varchar(75))
begin
declare existe_empleado int default null;
select ID_Empleado into existe_empleado from Empleados
where ID_Empleado = ID;

if existe_empleado is null then
set mensaje = "Error. El empleado ingresado no existe.";
rollback;
else 
	if Nombre_ing is not null then
		update Empleados
        set Nombre = Nombre_ing
        where ID_Empleado = ID;
	end if;
	if Apellido_ing is not null then
		update Empleados
        set Apellido = Apellido_ing
        where ID_Empleado = ID;
	end if;
	if Dni_ing is not null then
		update Empleados
        set Dni = Dni_ing
        where ID_Empleado = ID;
	end if;
	if email_ing is not null then
		update Empleados
        set email = email_ing
        where ID_Empleado = ID;
	end if;
	if telefono_ing is not null then
		update Empleados
        set telefono = telefono_ing
        where ID_Empleado = ID;
	end if;
	if sector_ing is not null then
		update Empleados
        set sector = sector_ing
        where ID_Empleado = ID;
	end if;
	if cargo_ing is not null then
		update Empleados
        set cargo = cargo_ing
        where ID_Empleado = ID;
	end if;
	if rol_ing is not null then
		update Empleados
        set rol = rol_ing
        where ID_Empleado = ID;
	end if;
set mensaje = "Empleado editado correctamente.";
commit;
end if;
end //
DELIMITER ;
drop procedure if exists eliminar_empleado;
DELIMITER //
create procedure eliminar_empleado (in id_ing int, out mensaje varchar(75))
begin 
declare existe_empleado int default null;
declare tiene_vehiculo int default null;
select ID_Empleado into existe_empleado from empleados
where ID_Empleado = id_ing;

select ID_Empleado into tiene_vehiculo from Vehiculos
where ID_Empleado = id_ing;

if tiene_vehiculo is not null then 
set mensaje = "Error. El empleado no puede tener un vehiculo si se lo eliminará.";

elseif existe_empleado is not null then
    delete from empleados
    where ID_Empleado = id_ing;
    commit;
    set mensaje = "Empleado eliminado correctamente.";
else 
	set mensaje = "Error. El empleado ingresado no existe.";
	rollback; 
end if;
end //
DELIMITER ;
drop procedure if exists crear_vehiculo;
DELIMITER //
create procedure crear_vehiculo (in Precio_ing int (11), in anio_ing int (11), in ID_Empleado_ing int, in modelo_ing varchar(100), in marca_ing varchar(100), out mensaje varchar(75))
begin
declare existe_empleado int default null;
select ID_Empleado into existe_empleado from Empleados
where ID_Empleado = ID_Empleado_ing;

if existe_empleado is not null then
insert into vehiculos(Precio, anio, ID_Empleado, Modelo, Marca)
values (Precio_ing, anio_ing, ID_Empleado_ing, modelo_ing, marca_ing);
set mensaje = "Vehiculo registrado correctamente.";
commit;

else
rollback;
set mensaje = "Error. El empleado ingresado no existe.";

end if;
end //
DELIMITER ;

drop procedure if exists eliminar_vehiculo;
DELIMITER //
create procedure eliminar_vehiculo (in id_ing int, out mensaje varchar(75))
begin 
declare existe_vehiculo int default 0;
declare presencia_envio_vehiculos int default 0;

select count(ID_Vehiculo) into existe_vehiculo from vehiculos
where ID_Vehiculo = id_ing;

select count(ID_Vehiculo) into presencia_envio_vehiculos from Envio_vehiculos
where ID_Vehiculo = id_ing;

if presencia_envio_vehiculos != 0 then
rollback;
set mensaje = "Error. No se puede eliminar al vehiculo si tiene presencia en Envio_vehiculos.";

elseif existe_vehiculo != 0 then
    delete from vehiculos
    where ID_Vehiculo = id_ing;
    commit;
    set mensaje = "Vehiculo eliminado correctamente.";
else 
	set mensaje = "Error. El vehiculo ingresado no existe.";
	rollback; 
end if;
end //
DELIMITER ;
drop procedure if exists editar_vehiculos;
DELIMITER //
create procedure editar_vehiculos (in ID_Vehiculo_ing int, in Precio_ing int (11), in anio_ing int (11), in ID_Empleado_ing int, in modelo_ing varchar(100), in marca_ing varchar(100), out mensaje varchar (75))
begin
declare existe_vehiculo int default null;
select ID_Vehiculo into existe_vehiculo from Vehiculos
where ID_Vehiculo = ID_Vehiculo_ing;

if existe_vehiculo is null then
set mensaje = "Error. El vehiculo ingresado no existe.";
rollback;
else 
	if Precio_ing is not null then
		update Vehiculos
        set Precio = Precio_ing
        where ID_Vehiculo = ID_Vehiculo_ing;
	end if;
	if anio_ing is not null then
		update Vehiculos
        set anio = anio_ing
        where ID_Vehiculo = ID_Vehiculo_ing;
	end if;
	if ID_Empleado_ing is not null then
		update Vehiculos
        set ID_Empleado = ID_Empleado_ing
        where ID_Vehiculo = ID_Vehiculo_ing;
	end if;
	if modelo_ing is not null then
		update Vehiculos
        set Modelo = modelo_ing
        where ID_Vehiculo = ID_Vehiculo_ing;
	end if;
	if marca_ing is not null then
		update Vehiculos
        set Marca = marca_ing
        where ID_Vehiculo = ID_Vehiculo_ing;
	end if;
set mensaje = "Vehiculo editado correctamente.";
commit;
end if;
end //
DELIMITER ;
drop procedure if exists crear_enviovehiculos;
DELIMITER //
create procedure crear_enviovehiculos (in ID_Env int, in ID_Vehic int, out mensaje varchar(75))
begin
declare existe_vehiculo int default null;
declare existe_envio int default null;

select ID_Vehiculo into existe_vehiculo from vehiculos
where ID_Vehiculo = ID_Vehic;
select ID_Envio into existe_envio from Envios
where ID_Envio = ID_Env;

if existe_envio is null or existe_vehiculo is null then
set mensaje = "Error. El vehiculo o envio no existe.";
else
insert into Envio_vehiculos(ID_Envio, ID_Vehiculo)
values(ID_Env, ID_Vehic);
set mensaje = "Union Envios-Vehiculos registrada correctamente.";
end if;
end //
DELIMITER ;

drop procedure if exists editar_enviovehiculos;
DELIMITER //
create procedure editar_enviovehiculos (in env_vehic int, in ID_Vehiculo_ing int, in ID_Envio_ing int, out mensaje varchar (75))
begin
declare existe_env_vehic int default null;

select ID_EV into existe_env_vehic from Envio_vehiculos
where ID_EV = env_vehic;

if existe_env_vehic is null then
set mensaje = "Error. La union Envio_vehiculos ingresada no existe.";
rollback;
else 
	if ID_Vehiculo_ing is not null then
		update Envio_vehiculos
        set ID_Vehiculo = ID_Vehiculo_ing
        where ID_EV = env_vehic;
	end if;
	if ID_Envio_ing is not null then
		update Envio_vehiculos
        set ID_Envio = ID_Envio_ing
        where ID_EV = env_vehic;
	end if;
set mensaje = "Vehiculo editado correctamente.";
commit;
end if;
end //
DELIMITER ;
drop procedure if exists eliminar_env_vehic;
DELIMITER //
create procedure eliminar_env_vehic (in env_vehic int, out mensaje varchar(75))
begin 
declare existe_env_vehic int default null;
select ID_EV into existe_env_vehic from Envio_vehiculos
where ID_EV = env_vehic;

if existe_env_vehic is null then
set mensaje = "Error. La union Envio_vehiculos ingresada no existe.";
rollback;
else 
	delete from Envio_vehiculos
    where ID_EV = env_vehic;
    set mensaje = "Union Envio_vehiculos eliminada correctamente.";
end if;
end //
DELIMITER ;
drop procedure if exists eliminar_env_vehic;
DELIMITER //
create procedure eliminar_env_vehic2 (in env_vehic int)
begin 
  delete from Envio_vehiculos where ID_Vehiculo =env_vehic ;
end //
DELIMITER ;

drop procedure if exists mostrar_empleados;
DELIMITER //
create procedure mostrar_empleados()
begin
select * from empleados;
end //
DELIMITER ;
delimiter //
create procedure buscar_empleado(in p_id_empleado int)
	begin
		select * from empleados where ID_Empleado=p_id_empleado;
	end//
delimiter;
drop procedure if exists empleado_mas_viejo;
DELIMITER //
create procedure empleado_mas_viejo()
begin
select * from Empleados
where dni = (select min(dni) from empleados);
end //
DELIMITER ;
drop procedure if exists mostrar_vehiculos;
DELIMITER //
create procedure mostrar_vehiculos()
begin
select * from vehiculos;
end //
DELIMITER ;

drop procedure if exists buscar_vehiculo;
DELIMITER //
create procedure buscar_vehiculo(in id_ing int)
begin
select * from vehiculos 
where ID_Vehiculo = id_ing;
end // 
DELIMITER ;
drop procedure if exists buscar_vehiculo_por_empleado;
DELIMITER //
create procedure buscar_vehiculo_por_empleado(in id_emp_ing int)
begin
select * from vehiculos 
where ID_Empleado = id_emp_ing;
end // 
DELIMITER ;


drop procedure if exists buscar_vehiculo_por_marca;
DELIMITER //
create procedure buscar_vehiculo_por_marca(in marca_ing varchar(100))
begin
select * from vehiculos 
where Marca = marca_ing;
end // 
DELIMITER ;
drop procedure if exists buscar_vehiculo_por_modelo;
DELIMITER //
create procedure buscar_vehiculo_por_modelo(in modelo_ing varchar(100))
begin
select * from vehiculos 
where Modelo = modelo_ing;
end // 
DELIMITER ;
drop procedure if exists vehiculos_modernos;
DELIMITER //
create procedure vehiculos_modernos()
begin
select * from Vehiculos
where anio >= 2020;
end //
DELIMITER ;
drop procedure if exists vehiculos_economicos;
DELIMITER //
create procedure vehiculos_economicos()
begin
select * from Vehiculos
where precio <= 15000000;
end //
DELIMITER ;
drop procedure if exists mostrar_envio_vehiculo;
DELIMITER //
create procedure mostrar_envio_vehiculo()
begin
select * from Envio_Vehiculos;
end //
DELIMITER ;
drop procedure if exists buscar_envio_vehiculo;
DELIMITER //
create procedure buscar_envio_vehiculo(in id_ing int)
begin
select * from Envio_Vehiculos 
where ID_EV = id_ing;
end // 
DELIMITER ;
DELIMITER // 


CREATE PROCEDURE agregarTickett(
    IN idCliente INT, 
    IN fechaN DATE, 
    IN detalleN VARCHAR(100), 
    IN totalN INT, 
    IN metodospagoN VARCHAR(25), 
    OUT mensaje VARCHAR(200) 
)
BEGIN 
    DECLARE v_existe INT DEFAULT 0;
    
    START TRANSACTION;
        SELECT COUNT(*) INTO v_existe 
        FROM Clientes 
        WHERE ID_Cliente = idCliente;
        
        IF v_existe = 0 THEN
            SET mensaje = 'Error: El cliente no existe. Transacción cancelada.';
            ROLLBACK;
        ELSE
            INSERT INTO Tickets (ID_Cliente, fecha, detalle, total, metodospago)
            VALUES (idCliente, fechaN, detalleN, totalN, metodospagoN);
            
            COMMIT;
            SET mensaje = 'Ticket creado con éxito';
        END IF;
END // 


DELIMITER ;
DELIMITER //
CREATE PROCEDURE eliminarTicket (in p_idTicket int, out mensaje varchar(100))
BEGIN
    	DECLARE contador_reportesTickets int;
        START TRANSACTION;
        	SELECT COUNT(reportes_ticket.ID_rt) INTO contador_reportesTickets FROM reportes_ticket WHERE reportes_ticket.ID_Ticket=p_idTicket ;
            IF contador_reportesTickets>0 THEN 
            	SET mensaje='No se puede eliminar un ticket que este en la tabla reportes tickets';
                ROLLBACK;
              ELSE 
                 DELETE FROM tickets
                 WHERE tickets.ID_Ticket =p_idTicket ;
                 COMMIT;
                 SET mensaje='Se ha realizado con exito';
                 END IF;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE eliminarTicket2 (in p_idTicket int)
BEGIN
    	delete  from Tickets where ID_Cliente=p_idTicket;
END //
DELIMITER ;
 DELIMITER //
create procedure editar_ticket(in p_id_ticket int,
    in p_id_cliente int,
    IN p_fechas date,
    in p_detalles varchar(1000),
    in p_ttotal int,
    in p_metodoPago varchar(100),
    OUT mensaje VARCHAR(200)
)
BEGIN
    	declare auxiliar varchar(100);
        start TRANSACTION;
        select tickets.detalle into auxiliar from tickets where tickets.ID_Ticket =p_id_ticket ;
            if auxiliar is null THEN
             	set mensaje='No existe el ticket ';
                rollback;
             else 
             	if p_id_cliente  is not null THEN
                	update tickets
                    set ID_Cliente = p_id_cliente
                    where ID_Ticket=p_id_ticket;
                    end if;
                 if p_fechas  is not null THEN
                	update tickets
                    set fecha=p_fechas
                    where ID_Ticket=p_id_ticket;
                    end if;
                 if p_detalles is not null THEN
                	update tickets
                    set detalle =p_detalles
                    where  ID_Ticket=p_id_ticket;
                    end if;
                  if p_ttotal is not null THEN
                	update tickets
                    set total=p_ttotal
                    where ID_Ticket=p_id_ticket;
                    end if;
                  if p_metodoPago is not null THEN
                	update tickets
                    set metodosPago=p_metodoPago
                    where ID_Ticket=p_id_ticket;
                    end if;
                    set mensaje='Se ha encontrado el ticket, se editaron los campos proporcionados correctamente';
                    commit;
                    end if;
end //
delimiter ;
DELIMITER //
CREATE PROCEDURE ticketes_cliente(in t_id_cliente int)
BEGIN
    	select * from tickets where tickets.ID_Cliente=t_id_cliente;
END //
DELIMITER ;
delimiter //
create procedure mostrar_tickets()
	BEGIN
    	select * from tickets;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE metodoPago_efectivo()
BEGIN
 SELECT * FROM tickets WHERE metodospago = "Efectivo";
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE metodoPago_Mercado()
BEGIN
 SELECT * FROM tickets WHERE metodospago = "Mercado Pago";
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE metodoPago_Debitoo()
BEGIN
 SELECT * FROM tickets WHERE metodospago = "Tarjeta de Débito";
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE metodoPago_credito()
BEGIN
 SELECT * FROM tickets WHERE metodospago = "Tarjeta de Credito";
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE metodoPago_transferencia()
BEGIN
 SELECT * FROM tickets WHERE metodospago = "Transferencia";
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE total_menor50000()
BEGIN 
   SELECT * FROM tickets where total < 50000;
END //
DELIMITER ;
DELIMITER //
create procedure agregar_reportes(in detallee varchar(1000), out mensaje varchar(100))
begin
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    begin
        SET mensaje = "Error. Operacion cancelada";
        rollback;
    end;
    start transaction;
    insert into Reportes( detalle)
    values (detallee);
    commit;
    set mensaje = "Reporte registrado correctamente.";
end //
DELIMITER ;
DELIMITER //

CREATE PROCEDURE eliminarReporte(
    IN p_idReports INT,        
    OUT mensaje VARCHAR(100)
)
BEGIN
    DECLARE contador_reportesTickets INT DEFAULT 0;
    
    START TRANSACTION;
        SELECT COUNT(*) 
        INTO contador_reportesTickets 
        FROM reportes_ticket 
        WHERE reportes_ticket.ID_Reporte = p_idReports;
        
        IF contador_reportesTickets > 0 THEN 
            SET mensaje = 'No se puede eliminar un reporte que este en la tabla reportes tickets';
            ROLLBACK;
        ELSE 
            DELETE FROM reportes
            WHERE reportes.ID_Reporte = p_idReports;
            
            SET mensaje = 'Se ha realizado con exito';
            COMMIT;
        END IF;
END //

DELIMITER ;


 DELIMITER //

CREATE PROCEDURE editar_reporte(
    IN id_Reporte INT,
    IN detallee VARCHAR(1000),
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE existe_reporte INT DEFAULT 0;
    
    START TRANSACTION;
        SELECT COUNT(*) INTO existe_reporte 
        FROM reportes 
        WHERE reportes.ID_Reporte = id_Reporte;
        
        IF existe_reporte = 0 THEN
            SET mensaje = 'No existe el reporte';
            ROLLBACK;
        ELSE 
            IF detallee IS NOT NULL THEN
                UPDATE reportes
                SET detalle = detallee
                WHERE reportes.ID_Reporte = id_Reporte;
            END IF;
            
            SET mensaje = 'Se ha encontrado el reporte, se editaron los campos proporcionados correctamente';
            COMMIT;
        END IF;
END //

DELIMITER ;

DELIMITER //
CREATE PROCEDURE buscar_reportess(in id int)
BEGIN 
   select * from reportes WHERE ID_Reporte = id;
END //
DELIMITER ;

delimiter //
create procedure mostrar_reportes()
	BEGIN
    	select * from reportes;
END //
DELIMITER ;
DELIMITER //
create procedure agregarReportes_Ticket(in idReporte int, in idTicket int, out mensaje varchar(75))
begin
declare existe_Reporte int default null;
declare existe_Ticket int default null;

select ID_Reporte into existe_Reporte from reportes
where ID_Reporte = idReporte;
select ID_Ticket into existe_Ticket from tickets
where ID_Ticket = idTicket;

if existe_Reporte is null or existe_Ticket is null then
set mensaje = "Error. El ticket o reporte no existe.";
else
insert into reportes_ticket(ID_Reporte, ID_Ticket)
values(idReporte, idTicket);
set mensaje = "Union Reportes-Ticket registrada correctamente.";
end if;
end //
DELIMITER ;
DELIMITER //
create procedure eliminar_ReportesTicket (in id_ReporteTicket int, out mensaje varchar(75))
begin 
declare existe_ReporteTicket int default null;
select ID_rt  into existe_ReporteTicket from reportes_ticket
where ID_rt = id_ReporteTicket;

if existe_ReporteTicket is null then
set mensaje = "Error. La union Reportes_ticket ingresada no existe.";
rollback;
else 
	delete from reportes_ticket
    where ID_rt = id_ReporteTicket;
    set mensaje = "Union Reportes_ticket eliminada correctamente.";
end if;
end //
DELIMITER ;
DELIMITER //
create procedure eliminar_ReportesTicket2 (in id_ReporteTicket int)
begin 
  delete from reportes_ticket where ID_Reporte=id_ReporteTicket ;
end //
DELIMITER ;

DELIMITER //
create procedure editar_ReporteTicket (in id_reporteTicket int, in idReporte int, in idTicket int, out mensaje varchar (75))
begin
declare existe_reporteTicket int default null;

select ID_rt into existe_reporteTicket from reportes_ticket
where ID_rt = id_reporteTicket;

if existe_reporteTicket is null then
set mensaje = "Error. La union Reporte_ticket ingresada no existe.";
rollback;
else 
	if idReporte is not null then
		update reportes_ticket
        set ID_Reporte = idReporte
        where ID_rt = id_reporteTicket;
	end if;
	if idTicket is not null then
		update reportes_ticket
        set ID_Ticket = idTicket
        where ID_rt = id_reporteTicket;
	end if;
set mensaje = "Editado correctamente.";
commit;
end if;
end //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE buscar_reportesTickets(in id int)
BEGIN 
   select * from reportes_ticket WHERE ID_rt = id;
END //
DELIMITER ;

delimiter //
create procedure mostrar_reportesTickets()
	BEGIN
    	select * from reportes_ticket;
END //
DELIMITER ;
delimiter //
create procedure validar_login(in p_nombre varchar(100), in p_contra varchar(100)) 
	BEGIN
			select * from usuarios where nombre=p_nombre and contrasenia=p_contra;
            end//
            delimiter;
DELIMITER //

CREATE PROCEDURE editar_usuario(
    IN p_usuario INT, 
    IN p_nombre VARCHAR(100), 
    IN p_apellido VARCHAR(100), 
    IN p_email VARCHAR(100),
    IN p_contrasenia VARCHAR(500)
)
BEGIN
    UPDATE usuarios
    SET nombre = p_nombre,
        apellido = p_apellido,
        email = p_email,
        contrasenia = p_contrasenia
    WHERE id_usuario = p_usuario;
END//

        delimiter;
DELIMITER //

CREATE PROCEDURE crear_usuario(
    IN p_nombre VARCHAR(100), 
    IN p_apellido VARCHAR(100), 
    IN p_email VARCHAR(100),
    IN p_contrasenia VARCHAR(500)
)
BEGIN
    insert into usuarios(nombre,apellido,email,contrasenia)values(p_nombre,p_apellido,p_email,p_contrasenia);
END//

        delimiter;




delimiter //
create procedure Productos_paquete(in ID_paque int)
BEGIN
	select productos_paquetes.ID_Propa, productos.marca,productos.descripcion, productos.stock,productos_paquetes.cantidad from productos 
    inner join productos_paquetes on 
productos_paquetes.ID_Producto=productos.ID_Producto
   	where ID_paque=productos_paquetes.ID_Paquete;
    end//
delimiter;
delimiter //
create procedure Tickets_reporte(in ID_repor int)
BEGIN
	select  reportes_ticket.ID_rt , tickets.detalle,tickets.total,tickets.metodospago , clientes.Nombre, clientes.Apellido
    from tickets
    inner join clientes on clientes.ID_Cliente=tickets.ID_Ticket
    inner join reportes_ticket on reportes_ticket.ID_Ticket=tickets.ID_Ticket
    where reportes_ticket.ID_Reporte=ID_repor;
    end//
delimiter;
delimiter //
create procedure Vehiculos_envio(in ID_envi int)
BEGIN
	select envio_vehiculos.ID_EV , vehiculos.Marca,vehiculos.Modelo,vehiculos.ID_Vehiculo
    from vehiculos
    inner join envio_vehiculos on envio_vehiculos.ID_Vehiculo=vehiculos.ID_Vehiculo
    where envio_vehiculos.ID_Envio=ID_envi;
    end//
delimiter;

delimiter //
create procedure paqutes_envio(in ID_envi int)
BEGIN
	select envio_paquetes.ID_EP,  paquetes.ID_Paquete, paquetes.peso,paquetes.volumen
    from paquetes
    inner join envio_paquetes on envio_paquetes.ID_Paquete=paquetes.ID_Paquete
    where envio_paquetes.ID_Envio=ID_envi;
    end//
delimiter;
DELIMITER //
CREATE PROCEDURE agregar_ciudad(
    IN Nombres VARCHAR(200),
    IN provincias VARCHAR(200),
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET mensaje = 'Error: operación revertida';
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO ciudades(Nombre, Provincia)
    VALUES (Nombres, provincias);

    COMMIT;
    SET mensaje = 'Hecho con éxito';
END//
DELIMITER ;
delimiter //
create procedure borrar_ciudad (in id_de_ciudad int, out mensake varchar(100) )
	BEGIN
    	declare contador_almacenes int;
        declare contador_origen int;
        declare contador_destino int;
        Start TRANSACTION;
        	select count(envios.ID_Envio) into contador_origen from envios where envios.Origen=id_de_ciudad;
            select count(envios.ID_Envio) into contador_destino from envios where envios.Destino=id_de_ciudad;
            select count(almacenes.ID_Almacen) into contador_almacenes from almacenes where almacenes.ciudad=id_de_ciudad;
            if contador_origen>0 then 
            	set mensake='No se puede eliminar una ciudad que sea de origen en envios';
                ROLLBACK;
             ELSEIF contador_destino>0 THEN
             	set mensake='No se puede eliminar una ciudad que sea de destino en envios';
                ROLLBACK;
             ELSEIF contador_almacenes>0 THEN
             	set mensake='No se puede eliminar una ciudad que tenga almacenes' ;
                ROLLBACK;
              else 
              		delete from ciudades
                    where ciudades.ID_Ciudad=id_de_ciudad;
                    COMMIT;
                    set mensake='Se ha realizado con exito';
                    end if;
                    end//
                    delimiter;
delimiter //
create procedure mostrar_ciudades()
	BEGIN
    	select * from ciudades;
        end//
delimiter;
Buscar ciudades(Por nombre):
delimiter //
create procedure buscar_ciudad(in p_nombre varchar(100))
	BEGIN
    	select ID_Ciudad from ciudades where Nombre=p_nombre;
        end//
        delimiter;

delimiter //
create procedure almacenes_ciudad(in p_id_ciudad int)
	BEGIN
    	select * from almacenes where almacenes.ciudad=p_id_ciudad;
    end//
     delimiter;
delimiter //
create procedure origen_ciudad(in p_id_ciudad int)
	BEGIN
    	select * from envios where envios.Origen=p_id_ciudad;
        end//
        delimiter;

delimiter //
create procedure destino_ciudad(in p_id_ciudad int)
	BEGIN
    	select * from envios where envios.Destino=p_id_ciudad;
        end//
        delimiter;
DELIMITER //
create procedure ciudades_provincia(in P_provincia varchar(100))
	BEGIN
    	select * from ciudades WHERE ciudades.Provincia=P_provincia;
        end//
        delimiter;
delimiter //
create procedure clientes_ciudad(in p_id_ciudad int)
	begin 
    	select clientes.ID_Cliente,clientes.Nombre,clientes.Apellido,clientes.DNI,clientes.email,clientes.telefono,clientes.direccion,clientes.cod_postal from clientes inner join envios on envios.ID_Cliente=clientes.ID_Cliente inner join ciudades on ciudades.ID_Ciudad=envios.Destino;
        end//
        delimiter;
delimiter //
create PROCEDURE adheridas_per_ciudad(in p_id_ciudad int)
	BEGIN
    	select empresa_adherida.ID_empresa,empresa_adherida.nombre,empresa_adherida.cuit,empresa_adherida.direccion,empresa_adherida.telefono,empresa_adherida.rubro,empresa_adherida.duenio from empresa_adherida inner join envio on envios.ID_Empresa=empresa_adherida.ID_empresa where envios.Destino=p_id_ciudad;
        end//
        delimiter;
delimiter //
create PROCEDURE total_envios(in p_ciudad int)
	BEGIN
    	declare porigen int;
        declare pdestino int;
        declare ptotal int;
        select count(envios.ID_Envio) into porigen from envios where envios.Origen=p_ciudad;
        select count(envios.ID_Envio) into pdestino from envios where envios.Destino=p_ciudad;
        set ptotal=porigen+pdestino;
        select ptotal;
        end//
        DELIMITER;

DELIMITER //
CREATE PROCEDURE agregar_clientes(
    IN Nombres VARCHAR(200),
    IN Apellidos VARCHAR(200),
    in codigo int,
    in direcciones varchar(200),
    in dnis int,
    in emails varchar(1000),
    in telefonos int,
    OUT mensaje VARCHAR(200)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET mensaje = 'Error: operación revertida';
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO clientes(Nombre, Apellido,cod_postal,direccion,DNI,email,telefono)
    VALUES (Nombres, Apellidos,codigo,direcciones,dnis,emails,telefonos);

    COMMIT;
    SET mensaje = 'Hecho con éxito';
END//
DELIMITER ;
delimiter //
create procedure borrar_cliente(in id_cliente_aborrar int , out mensaje varchar(100))
	BEGIN
    	DECLARE contador_tickets int;
        DECLARE contador_envios int;
        START TRANSACTION;
        	select COUNT(tickets.ID_Ticket) into contador_tickets from tickets where tickets.ID_Cliente=id_cliente_aborrar;
            select COUNT(envios.ID_Envio) into contador_envios from envios where envios.ID_Cliente=id_cliente_aborrar;
            if contador_tickets>0 THEN
            	set mensaje='Hay instancias en tickets';
                ROLLBACK;
             ELSEIF contador_envios>0 THEN
             	set mensaje='Hay instancias en envios';
                ROLLBACK;
	else
		delete from clientes where ID_Cliente=id_cliente_aborrar ;
		commit;
		set mensaje='Exito';
                end if;
                end//
                delimiter;
DELIMITER //

CREATE PROCEDURE editar_cliente(
    IN p_id_cliente INT,
    IN p_Nombres VARCHAR(200),
    IN p_Apellidos VARCHAR(200),
    IN p_codigo INT,
    IN p_direcciones VARCHAR(200),
    IN p_dnis INT,
    IN p_emails VARCHAR(1000),
    IN p_telefonos INT,
    OUT p_mensaje VARCHAR(200)
)
BEGIN
    DECLARE auxiliar VARCHAR(100);
    START TRANSACTION;
    
    SELECT clientes.Nombre INTO auxiliar 
    FROM clientes 
    WHERE clientes.ID_Cliente = p_id_cliente;
    
    IF auxiliar IS NULL THEN
        SET p_mensaje = 'No existe el cliente ';
        ROLLBACK;
    ELSE 
        UPDATE clientes
        SET 
            Nombre = IFNULL(p_Nombres, Nombre),
            Apellido = IFNULL(p_Apellidos, Apellido),
            cod_postal = IFNULL(p_codigo, cod_postal),
            direccion = IFNULL(p_direcciones, direccion),
            email = IFNULL(p_emails, email),
            DNI = IFNULL(p_dnis, DNI),
            telefono = IFNULL(p_telefonos, telefono)
        WHERE ID_Cliente = p_id_cliente;
        
        SET p_mensaje = 'Se ha encontrado cliente, se editaron los campos proporcionados';
        COMMIT;
    END IF;
END//

DELIMITER ;


delimiter //
create procedure mostrar_clientes()
	BEGIN
    	select * from clientes;
        end//
delimiter;
DELIMITER //
create procedure buscar_clientes(in p_id_cliente int)
begin
select * from clientes 
where ID_Cliente=p_id_cliente;
end // 
DELIMITER ;

delimiter //
create procedure tickets_de_cliente(in p_id_cliente int)
	BEGIN
    	select * from clientes inner join tickets on tickets.ID_Cliente=clientes.ID_Cliente where clientes.ID_Cliente=p_id-cliente;
        end//
        delimiter;
delimiter //
create procedure envios_cliente(in p_id_cliente int)
	BEGIN
    	select * from envios inner join clientes on clientes.ID_Cliente=envios.ID_Cliente where clientes.ID_Cliente=p_id_cliente;
        end//
        delimiter;
delimiter //
create procedure reportes_de_cliente(in p_id_cliente int)
	BEGIN	
    	select reportes.ID_Reporte,reportes.detalle from reportes INNER join reportes_ticket on reportes_ticket.ID_Reporte=reportes.ID_Reporte inner join tickets on tickets.ID_Ticket=reportes_ticket.ID_Ticket where tickets.ID_Cliente=p_id_cliente;
        end//
        delimiter;
delimiter //
create procedure cliente_mas_envios()
	BEGIN
    	select clientes.ID_Cliente,clientes.Nombre,clientes.Apellido , max(count(envios.ID_Envio))as cantidad from clientes inner join envios on envios.ID_Cliente=clientes.ID_Cliente GROUP by clientes.ID_Cliente;
        end//
        delimiter;
delimiter //
create procedure cliente_menoss_envios()
	BEGIN
    	select clientes.ID_Cliente,clientes.Nombre,clientes.Apellido , min(count(envios.ID_Envio))as cantidad from clientes inner join envios on envios.ID_Cliente=clientes.ID_Cliente GROUP by clientes.ID_Cliente;
        end//
        delimiter;
delimiter //
create procedure monto_per_cliente()
	BEGIN
    	select clientes.ID_Cliente,clientes.Nombre,clientes.Apellido,sum(tickets.total) from clientes inner join tickets on tickets.ID_Cliente=clientes.ID_Cliente group by clientes.ID_Cliente;
        end//
        delimiter;
DELIMITER //
CREATE PROCEDURE verificar_envio(IN p_fecha date, in p_origen int, in p_destino int,in p_id_empresa int,in p_estado varchar(50) , in p_cliente int , out mensaje varchar(100))
BEGIN
	declare ciudad_origen varchar(100);
    declare ciudad_destino varchar(100);
    declare cliente_envio varchar(100);
    declare adherida_envio varchar(100);

	Start TRANSACTION;
		select ciudades.Nombre into ciudad_origen from ciudades where ciudades.ID_Ciudad=p_origen;
        select ciudades.Nombre into ciudad_destino from ciudades where ciudades.ID_Ciudad=p_destino;
        select clientes.Nombre into cliente_envio from clientes where clientes.ID_Cliente=p_cliente;
        select empresa_adherida.nombre into adherida_envio from empresa_adherida where empresa_adherida.ID_empresa=p_id_empresa;
        if ciudad_origen is null THEN
        	set mensaje="Origen inexistente";
            ROLLBACK;
            ELSEIF ciudad_destino is null THEN
            set mensaje="Destino inexistente";
            ROLLBACK;
            ELSEIF cliente_envio is null THEN
            set mensaje="CLiente inexistente";
            ROLLBACK;
            ELSEIF adherida_envio is null THEN
            set mensaje="Empresa adherida inexistente";
            ROLLBACK;
        ELSE
			insert into envios (fecha, Origen, Destino, id_empresa, estado, id_cliente) 
            values (p_fecha, p_origen, p_destino, p_id_empresa, p_estado, p_cliente);
			set mensaje="Registros ingresados";
			COMMIT;
		end if;
end//
DELIMITER ;
delimiter //
 create procedure editar_envio(
 in p_id_envio int unsigned,
 in p_fecha date,
 in p_origen int unsigned,
 in p_destino int unsigned,
 in p_id_empresa int unsigned,
 in p_estado varchar(50),
 in p_cliente int unsigned,
 out mensaje varchar(200)
 )
 begin
 declare auxiliar int unsigned default null;
 start transaction;
 select ID_Envio into auxiliar from Envios where ID_Envio = p_id_envio;
if auxiliar is null then
    set mensaje = 'No existe el envio';
    rollback;
else
    if p_fecha is not null then
        update Envios set Fecha = p_fecha where ID_Envio = p_id_envio;
    end if;
    if p_origen is not null then
        update Envios set Origen = p_origen where ID_Envio = p_id_envio;
    end if;
    if p_destino is not null then
        update Envios set Destino = p_destino where ID_Envio = p_id_envio;
    end if;
    if p_id_empresa is not null then
        update Envios set ID_Empresa = p_id_empresa where ID_Envio = p_id_envio;
    end if;
    if p_estado is not null then
        update Envios set Estado = p_estado where ID_Envio = p_id_envio;
    end if;
    if p_cliente is not null then
        update Envios set ID_Cliente = p_cliente where ID_Envio = p_id_envio;
    end if;
    set mensaje = 'Se han editado los campos proporcionados';
    commit;
end if;
end //
 delimiter ;
delimiter //
 create procedure eliminar_envio(in p_id_envio int unsigned, out mensaje varchar(150))
 begin
 declare v_envio int unsigned default null;
 declare v_relaciones int default 0;
 start transaction;
 select ID_Envio into v_envio from Envios where ID_Envio = p_id_envio limit 1;
if v_envio is null then
    set mensaje = 'No existe el envio';
    rollback;
else
    select count(*) into v_relaciones from Envio_Paquetes where ID_Envio = p_id_envio;
    if v_relaciones > 0 then
        set mensaje = 'El envio tiene paquetes asociados';
        rollback;
    else
        select count(*) into v_relaciones from Envio_Vehiculos where ID_Envio = p_id_envio;
        if v_relaciones > 0 then
            set mensaje = 'El envio tiene vehiculos asociados';
            rollback;
        else
            delete from Envios where ID_Envio = p_id_envio;
            set mensaje = 'Envio eliminado';
            commit;
        end if;
    end if;
end if;
end //
 delimiter ;


DELIMITER //
create procedure mostrar_envios()
begin
    select *
    from envios;
    end//
DELIMITER ;

DELIMITER //
create procedure buscar_envio(IN id int)
begin
    select *
    from envios
    where id = envios.ID_Envio;
    end//
DELIMITER ;
delimiter //
create PROCEDURE mostrar_fecha_reciente()
BEGIN
	select *
    from envios
    order by Fecha asc;
end //
DELIMITER ;

delimiter //
create PROCEDURE mostrar_estado_entregado(iN estado_actual varchar(100))
BEGIN
	select *
    from envios
    where estado_actual = "Entregado";
	end//
DELIMITER ;
delimiter //
create PROCEDURE mostrar_estado_pendiente(iN estado_actual varchar(100))
BEGIN
	select *
    from envios
    where estado_actual = "Pendiente";
	end//
DELIMITER ;
delimiter //
create PROCEDURE mostrar_estado_cancelado(iN estado_actual varchar(100))
BEGIN
	select *
    from envios
    where estado_actual = "Cancelado";
	end//
DELIMITER ;
DELIMITER //
create procedure mostrar_envios_paquetes()
begin
    select *
    from envio_paquetes;
    end//
DELIMITER ;

DELIMITER //
create procedure buscar_envio_paquetes(IN id int)
begin
    select *
    from envio_paquete
    where id = envios_paquete.ID_EP;
    end//
DELIMITER ;

DELIMITER //
create procedure mostrar_paquetes()
begin
    select *
    from paquetes;
    end//
DELIMITER ;
DELIMITER //
create procedure buscar_paquete(IN id int)
begin
    select *
    from paquetes
    where id = paquetes.ID_Paquete;
    end//
DELIMITER ;

DELIMITER //

CREATE PROCEDURE agregar_envio_paquete(
    IN p_id_envio INT,          
    IN p_id_paquete INT, 
    OUT mensaje VARCHAR(100)
)
BEGIN 
    DECLARE v_estado_envio VARCHAR(100); 
    DECLARE v_id_paquete INT;
    
    START TRANSACTION;
    
    SELECT envios.estado INTO v_estado_envio FROM envios WHERE envios.ID_Envio = p_id_envio;
    
    SELECT paquetes.ID_Paquete INTO v_id_paquete FROM paquetes WHERE paquetes.ID_Paquete = p_id_paquete;
    
    IF v_estado_envio IS NULL THEN
        SET mensaje = "Envio inexistente";
        ROLLBACK;
    ELSEIF v_id_paquete IS NULL THEN
        SET mensaje = "Paquete inexistente";
        ROLLBACK;
    ELSE
        INSERT INTO envio_paquetes VALUES (p_id_envio, p_id_paquete);
        
        SET mensaje = "Registros ingresados con éxito";
        COMMIT;
    END IF;
END //

DELIMITER ;

delimiter //
 create procedure eliminar_envio_paquete(
 in p_id_envio int unsigned,
 in p_id_paquete int unsigned,
 out mensaje varchar(100)
 )
 begin
 declare v_relacion int default 0;
 start transaction;
 select count(*) into v_relacion from Envio_Paquetes
 where ID_Envio = p_id_envio and ID_Paquete = p_id_paquete;
if v_relacion = 0 then
    set mensaje = 'No existe esa relacion envio-paquete';
    rollback;
else
    delete from Envio_Paquetes where ID_Envio = p_id_envio and ID_Paquete = p_id_paquete;
    set mensaje = 'Relacion eliminada';
    commit;
end if;
end //
 delimiter ;
delimiter //
create PROCEDURE eliminar_paquetes2(in id_env int)
	BEGIN
    	delete from envio_paquetes where envio_paquetes.ID_Envio=id_env;
        end//
        delimiter;


-- procedimientos para Empresa_Adherida
delimiter //
 create procedure agregar_empresa_adherida(
 in p_nombre varchar(50),
 in p_cuit varchar(13),
 in p_direccion varchar(100),
 in p_telefono int,
 in p_rubro varchar(100),
 in p_duenio varchar(50),
 out mensaje varchar(100)
 )
 begin
 start transaction;
 insert into Empresa_Adherida (nombre, cuit, direccion, telefono, rubro, duenio)
 values (p_nombre, p_cuit, p_direccion, p_telefono, p_rubro, p_duenio);
 set mensaje = 'Registro ingresado';
 commit;
 end //
 delimiter ;
DELIMITER //
CREATE PROCEDURE editar_empresa_adherida(
    IN p_id_empresa INT UNSIGNED,
    IN p_nombre VARCHAR(50),
    IN p_cuit VARCHAR(13),
    IN p_direccion VARCHAR(100),
    IN p_telefono INT,
    IN p_rubro VARCHAR(100),
    IN p_duenio VARCHAR(50),
    OUT mensaje VARCHAR(150)
)
BEGIN
    DECLARE auxiliar INT UNSIGNED DEFAULT NULL;
    START TRANSACTION;
    
    SELECT ID_empresa INTO auxiliar 
    FROM Empresa_Adherida 
    WHERE ID_empresa = p_id_empresa;
    
    IF auxiliar IS NULL THEN
        SET mensaje = 'No existe la empresa adherida';
        ROLLBACK;
    ELSE
        UPDATE Empresa_Adherida
        SET 
            nombre = IFNULL(p_nombre, nombre),
            cuit = IFNULL(p_cuit, cuit),
            direccion = IFNULL(p_direccion, direccion),
            telefono = IFNULL(p_telefono, telefono),
            rubro = IFNULL(p_rubro, rubro),
            duenio = IFNULL(p_duenio, duenio)
        WHERE ID_empresa = p_id_empresa;
        
        SET mensaje = 'Se han editado los campos proporcionados';
        COMMIT;
    END IF;
END //

DELIMITER ;


delimiter //
 create procedure eliminar_empresa_adherida(in p_id_empresa int unsigned, out mensaje varchar(150))
 begin
 declare v_empresa int unsigned default null;
 declare v_envios int default 0;
 start transaction;
 select ID_empresa into v_empresa from Empresa_Adherida where ID_empresa = p_id_empresa limit 1;
if v_empresa is null then
    set mensaje = 'No existe la empresa adherida';
    rollback;
else
    select count(*) into v_envios from Envios where ID_Empresa = p_id_empresa;
    if v_envios > 0 then
        set mensaje = 'La empresa tiene envios asociados';
        rollback;
    else
        delete from Empresa_Adherida where ID_empresa = p_id_empresa;
        set mensaje = 'Empresa adherida eliminada';
        commit;
    end if;
end if;
end //
 delimiter ;
delimiter //
create procedure mostrar_adheridos()
	begin 
		select * from empresa_adherida;
	end//
delimiter;
delimiter //
create procedure buscar_Adheridos(in p_id_empresa int)
	begin 
		select * from empresa_adherida where ID_empresa=p_id_empresa;
	end//
delimiter;



delimiter //
create procedure empresa_nombre_az()
begin
	select *
    from empresa_adherida
    order by nombre asc;
    end //
delimiter ;


delimiter //
create procedure empresa_nombre_za()
begin
	select *
    from empresa_adherida
    order by nombre desc;
    end //
delimiter ;
delimiter //
create procedure empresa_rubro()
begin
	select *
    from empresa_adherida
    order by rubro asc;
    end //
delimiter ;

delimiter //
create procedure empresa_duenio()
begin
	select *
    from empresa_adherida
    order by duenio asc;
    end //
delimiter ;

delimiter //
create procedure empresa_duenio2()
begin
	select *
    from empresa_adherida
    order by duenio desc;
    end //
delimiter ;
DELIMITER //

CREATE PROCEDURE AgregarAlmacen(
    IN p_direccion VARCHAR(50),
    IN p_ciudad INT,
    IN p_nombre VARCHAR(50)
)
BEGIN
    IF EXISTS (SELECT 1 FROM Ciudades WHERE ID_ciudad = p_ciudad) THEN
        
        INSERT INTO Almacenes (direccion, ciudad, nombre)
        VALUES (p_direccion, p_ciudad, p_nombre);
        
    ELSE
        
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El ID de ciudad no existe';
        
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE EditarAlmacen(
    IN p_id_almacen INT,
    IN p_direccion VARCHAR(50),
    IN p_ciudad INT,
    IN p_nombre VARCHAR(50)
)
BEGIN
    UPDATE Almacenes
    SET direccion = p_direccion,
        ciudad = p_ciudad,
        nombre = p_nombre
    WHERE id_almacen = p_id_almacen;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE BorrarAlmacen(
    IN p_id_almacen INT
)
BEGIN
    DELETE FROM Almacenes
    WHERE id_almacen = p_id_almacen;
END //

DELIMITER ;
DELIMITER //
create procedure mostrar_almacen()
BEGIN
	select *
    from almacenes;
end;
DELIMITER ;


DELIMITER //
create PROCEDURE buscar_almacen(in id int)
BEGIN
	SELECT
    from almacenes
    where id = almacenes.ID_Almacen
    end;
DELIMITER ;



DELIMITER //
CREATE PROCEDURE almacenes_AZ ()
BEGIN
select * from almacenes
order by nombre ASC;
end;
delimiter ;
DELIMITER //
CREATE PROCEDURE almacenes_ZA ()
BEGIN
select * from almacenes
order by nombre DESC;
end;
delimiter ;

