DELIMITER //

CREATE TRIGGER validar_nombre_almacen
BEFORE INSERT ON Almacenes
FOR EACH ROW
BEGIN
    IF NEW.nombre IS NULL OR TRIM(NEW.nombre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del almacen no puede estar vacio';
    END IF;
END //
DELIMITER;

DELIMITER //

CREATE TRIGGER validar_direccion_almacen
BEFORE INSERT ON Almacenes
FOR EACH ROW
BEGIN
    IF NEW.direccion IS NULL OR TRIM(NEW.direccion) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La direccion no puede estar vacia';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER validar_nombre_almacen_update
BEFORE UPDATE ON Almacenes
FOR EACH ROW
BEGIN
    IF NEW.nombre IS NULL OR TRIM(NEW.nombre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del almacen no puede estar vacio';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER validar_direccion_almacen_update
BEFORE UPDATE ON Almacenes
FOR EACH ROW
BEGIN
    IF NEW.direccion IS NULL OR TRIM(NEW.direccion) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La direccion no puede estar vacia';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER validar_ciudad_almacen
BEFORE INSERT ON Almacenes
FOR EACH ROW
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM Ciudades
        WHERE ID_Ciudad = NEW.ciudad
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La ciudad indicada no existe';
    END IF;
END //

DELIMITER ;

drop trigger if exists verificar_sector_transporte; 
DELIMITER // 
create trigger verificar_sector_transporte 
before insert on empleados 
for each row 
begin 
if new.Cargo != "Transportista" and new.Cargo != "Repartidor" and new.Cargo != "Supervisor de transporte" and new.Sector = "Transporte" then 
signal sqlstate '45000' 
set message_text = "Error. El cargo no corresponde al sector asignado.";
end if ; 
end // 
DELIMITER ;

drop trigger if exists verificar_sector_deposito; 
DELIMITER // 
create trigger verificar_sector_deposito 
before insert on empleados 
for each row 
begin 
if new.Cargo != "Operario" and new.Cargo != "Repositor" and new.Sector = "Deposito" then 
signal sqlstate '45000' 
set message_text = "Error. El cargo no corresponde al sector asignado.";
end if ; 
end // 
DELIMITER ;

drop trigger if exists verificar_sector_administracion; 
DELIMITER // 
create trigger verificar_sector_administracion 
before insert on empleados 
for each row 
begin 
if new.Cargo != "Administrativo" and new.Cargo != "Gerente" and new.Cargo != "Director" and new.Sector = "Administracion" then 
signal sqlstate '45000' 
set message_text = "Error. El cargo no corresponde al sector asignado.";
end if ; 
end // 
DELIMITER ;

drop trigger if exists verificar_sector_aac; 
DELIMITER // 
create trigger verificar_sector_aac 
before insert on empleados 
for each row 
begin 
if new.Cargo != "Comunicador" and new.Cargo != "Registrador de reclamos" and new.Sector = "Atencion al cliente" then 
signal sqlstate '45000' 
set message_text = "Error. El cargo no corresponde al sector asignado.";
end if ; 
end // 
DELIMITER ;

drop trigger if exists verificar_sector_finanzas; 
DELIMITER // 
create trigger verificar_sector_finanzas 
before insert on empleados 
for each row 
begin 
if new.Cargo != "Contador" and new.Cargo != "Administrador de ingresos" and new.Sector = "Finanzas" then 
signal sqlstate '45000' 
set message_text = "Error. El cargo no corresponde al sector asignado.";
end if ; 
end // 
DELIMITER ;

drop trigger if exists verificar_sector_mantenimiento; 
DELIMITER // 
create trigger verificar_sector_mantenimiento 
before insert on empleados 
for each row 
begin 
if new.Cargo != "Mecanico" and new.Cargo != "Tecnico" and new.Sector = "Mantenimiento" then 
signal sqlstate '45000' 
set message_text = "Error. El cargo no corresponde al sector asignado.";
end if ; 
end // 
DELIMITER ;

drop trigger if exists precio_negativo;
DELIMITER //
create trigger precio_negativo
before insert on vehiculos
for each row
begin
if new.precio < 0 then
signal sqlstate '45000'
set message_text = "Error. El precio no puede ser negativo";
end if;
end //
DELIMITER ;

drop trigger if exists año_imposible;
DELIMITER //
create trigger año_imposible
before insert on vehiculos
for each row
begin
if new.anio < 2006 or new.anio > year(curdate()) then
signal sqlstate '45000'
set message_text = "Error. El año de fabricacion no es valido";
end if;
end //
DELIMITER ;

drop trigger if exists chequear_empleado; 
DELIMITER // 
create trigger chequear_empleado 
before insert on vehiculos 
for each row 
begin 
declare existe_empleado int default null; 
if new.ID_Empleado is not null then
	select ID_Empleado into existe_empleado from Empleados 
	where ID_Empleado = new.ID_Empleado; 

	if existe_empleado is null then 
	signal sqlstate '45000' 
	set message_text = "Error. El empleado asignado al vehiculo no existe."; 
	end if; 
end if;
end // 
DELIMITER ; 

drop trigger if exists chequear_sector; 
DELIMITER // 
create trigger chequear_sector 
before insert on vehiculos 
for each row 
begin 
declare existe_empleado int default null;
declare sector_emp varchar(100);
if new.ID_Empleado is not null then
	select sector into sector_emp from Empleados 
	where ID_Empleado = new.ID_Empleado; 

	if sector_emp != "Transporte" then 
	signal sqlstate '45000' 
	set message_text = "Error. El empleado asignado no corresponde al sector 'Transporte'."; 
	end if;
end if;
end // 
DELIMITER ; 

drop trigger if exists limitar_eliminar_vehiculo;
DELIMITER //
create trigger limitar_eliminar_vehiculo
before delete on Vehiculos
for each row
begin
if old.ID_Empleado is not null then
signal sqlstate '45000'
set message_text = "Error. No se puede eliminar el vehiculo ya que tiene empleados asociados.";
end if ;
end //
DELIMITER ;

delimiter // 
create trigger bloquear_cambios_pedidos_finalizados
before update
on envios
begin 
if old.estado = "cancelado" and "entregado" then 
     SIGNAL SQLSTATE '45000'
     SET MESSAGE_TEXT = 'El pedido ya fue finalizado. No se pueden alterar los datos.';

end if ;
end //
delimiter ;

delimiter //
create trigger pasar_direccion_a_minusculas
before insert on empresa_adherida
for each ROW
BEGIN
	set new.direccion = lower(new.direccion);
END //
delimiter ;

DELIMITER //
create trigger guardar_empresas_borradas
AFTER delete on empresa_adherida
for each ROW
BEGIN
insert into empresa_adherida_eliminada (ID_empresa_eliminada, nombre_eliminado, cuit_eliminado, direccion_eliminada, telefono_eliminado, rubro_eliminado, duenio_eliminado) 

values (old.ID_empresa, old.nombre, old.cuit, old.direccion, old.telefono, old.rubro, old.duenio);
end //
DELIMITER ;


DELIMITER //

CREATE TRIGGER ticketFecha
BEFORE INSERT ON Tickets
FOR EACH ROW
BEGIN
    IF NEW.fecha IS NULL THEN
        SET NEW.fecha = CURDATE();
    END IF;
    

    END IF;
END//

DELIMITER ;

delimiter //
CREATE TRIGGER montoNegativo
BEFORE INSERT ON Tickets
FOR EACH ROW
BEGIN
    IF NEW.total < 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El total del ticket no puede ser un valor negativo.';
    END IF;
END//

DELIMITER ;

DELIMITER//
CREATE TRIGGER limpiarTabla
AFTER DELETE ON Tickets
FOR EACH ROW
BEGIN
    DELETE FROM Reportes_Ticket WHERE ID_Ticket = OLD.ID_Ticket;
END//

DELIMITER ;

delimiter //

CREATE TRIGGER verificarExist
BEFORE INSERT ON Reportes_Ticket
FOR EACH ROW
BEGIN
    DECLARE v_existe_ticket INT;
    
    SELECT COUNT(*) INTO v_existe_ticket 
    FROM Tickets 
    WHERE ID_Ticket = NEW.ID_Ticket;
    
    IF v_existe_ticket = 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: No se puede asociar el reporte porque el Ticket indicado no existe.';
    END IF;
END//

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_devolver_stock_productos
AFTER DELETE ON Productos_Paquetes
FOR EACH ROW
BEGIN
    UPDATE Productos 
    SET stock = stock + OLD.cantidad
    WHERE ID_Producto = OLD.ID_Producto;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_productos_antes_insertar
BEFORE INSERT ON Productos
FOR EACH ROW
BEGIN

    IF NEW.stock < 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El stock inicial del producto no puede ser negativo.';
    END IF;

    IF NEW.precio <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El precio del producto debe ser mayor a cero.';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_productos_antes_actualizar
BEFORE UPDATE ON Productos
FOR EACH ROW
BEGIN
    IF NEW.stock < 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: La actualización dejaría el stock en negativo.';
    END IF;
    IF NEW.precio <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El precio modificado debe ser mayor a cero.';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_paquetes_antes_insertar
BEFORE INSERT ON Paquetes
FOR EACH ROW
BEGIN
    IF NEW.peso <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El peso del paquete debe ser mayor a cero.';
    END IF;

    IF NEW.volumen <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El volumen del paquete debe ser mayor a cero.';
    END IF;

    IF NEW.fecha_ensamble > CURDATE() THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: La fecha de ensamble no puede ser una fecha futura.';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_paquetes_antes_actualizar
BEFORE UPDATE ON Paquetes
FOR EACH ROW
BEGIN
    IF NEW.peso <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El peso modificado debe ser mayor a cero.';
    END IF;

    IF NEW.volumen <= 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: El volumen modificado debe ser mayor a cero.';
    END IF;

    IF NEW.fecha_ensamble > CURDATE() THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Error: No se puede asignar una fecha de ensamble futura.';
    END IF;
END //

DELIMITER ;

DELIMITER //
create trigger auxiliar_envios
	BEFORE
    UPDATE
    on envios
    for each ROW
    BEGIN
    	if old.Origen!=new.Origen THEN
        	insert into envios_origenes(id_envio,origen)values(old.ID_Envio,old.Origen);
            end if;
            end//
            delimiter;


delimiter //
create trigger cambio
delimiter //
create trigger actualizar_stock
	BEFORE
    INSERT
    on productos_paquetes
    for each ROW
    	BEGIN
        	declare stocks int;
            	select productos.stock into stocks from productos where productos.ID_Producto=new.ID_Producto;
                if stocks>new.cantidad THEN
                	update productos
                    set productos.stock=productos.stock-new.cantidad
                    where productos.ID_Producto=new.ID_Producto;
                ELSE
                	 SIGNAL SQLSTATE '45000'
             			SET MESSAGE_TEXT = ' El stock es menor a la cantidad por tomar';
				end if;
                end//
                delimiter;

delimiter //
create trigger actualizar_stock3
	BEFORE
    delete
    on productos_paquetes
    for each ROW
    	BEGIN
        	update productos
                    set productos.stock=productos.stock+old.cantidad
                    where productos.ID_Producto=old.ID_Producto;
                end//
                delimiter;

DELIMITER //

CREATE TRIGGER tr_clientes_normalizar_nombre
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    SET NEW.Nombre = CONCAT(UPPER(SUBSTRING(NEW.Nombre, 1, 1)), LOWER(SUBSTRING(NEW.Nombre, 2)));
    SET NEW.Apellido = CONCAT(UPPER(SUBSTRING(NEW.Apellido, 1, 1)), LOWER(SUBSTRING(NEW.Apellido, 2)));
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_clientes_email_minusculas
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    SET NEW.email = LOWER(TRIM(NEW.email));
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_clientes_auditoria_borrado
AFTER DELETE ON Clientes
FOR EACH ROW
BEGIN
    INSERT INTO Clientes_Historico_Borrados (ID_Cliente, Nombre, Apellido, DNI, Fecha_Baja)
    VALUES (OLD.ID_Cliente, OLD.Nombre, OLD.Apellido, OLD.DNI, CURDATE());
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_clientes_validar_dni
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
    IF NEW.DNI <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El DNI ingresado no es válido.';
    END IF;
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_ciudades_normalizar_texto
BEFORE INSERT ON Ciudades
FOR EACH ROW
BEGIN
    SET NEW.Nombre = CONCAT(UPPER(SUBSTRING(NEW.Nombre, 1, 1)), LOWER(SUBSTRING(NEW.Nombre, 2)));
    SET NEW.Provincia = CONCAT(UPPER(SUBSTRING(NEW.Provincia, 1, 1)), LOWER(SUBSTRING(NEW.Provincia, 2)));
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_ciudades_evitar_duplicados
BEFORE INSERT ON Ciudades
FOR EACH ROW
BEGIN
    DECLARE total_coincidencias INT;
    
    SELECT COUNT(*) INTO total_coincidencias 
    FROM Ciudades 
    WHERE Nombre = NEW.Nombre AND Provincia = NEW.Provincia;
    
    IF total_coincidencias > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Esta ciudad ya se encuentra registrada en esa provincia.';
    END IF;
END;
//

DELIMITER ;

DELIMITER //

CREATE TRIGGER tr_ciudades_auditoria_cambio
AFTER UPDATE ON Ciudades
FOR EACH ROW
BEGIN
    INSERT INTO Ciudades_Historico_Cambios (
        ID_Ciudad, Nombre_Viejo, Nombre_Nuevo, Provincia_Vieja, Provincia_Nueva, Fecha_Modificacion
    )
    VALUES (
        OLD.ID_Ciudad, OLD.Nombre, NEW.Nombre, OLD.Provincia, NEW.Provincia, CURDATE()
    );
END;
//

DELIMITER ;

