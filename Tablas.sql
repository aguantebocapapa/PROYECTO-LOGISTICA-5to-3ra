drop database if exists Logistica32;
create database Logistica32;
use Logistica32;

create table Empresa_Adherida(
	ID_empresa int unsigned auto_increment primary key,
    nombre varchar(50),
    cuit varchar(13),
    direccion varchar(100),
    telefono int (10),
    rubro varchar(100),
    duenio varchar(50)    
);

create table Productos(
ID_Producto int unsigned auto_increment primary key,
marca varchar(200),
descripcion varchar(100),
precio decimal(10,2),
stock int,
categoria varchar(50)
);

create table Paquetes(
ID_Paquete int unsigned auto_increment primary key,
peso decimal(9,2),
volumen decimal(9,2),
fecha_ensamble date
);

create table Productos_Paquetes(
ID_Propa int unsigned auto_increment primary key,
ID_Producto int unsigned,
ID_Paquete int unsigned,
foreign key (ID_Producto) references Productos(ID_Producto),
foreign key (ID_Paquete) references Paquetes(ID_Paquete)
);

Create table Ciudades(
ID_Ciudad int unsigned auto_increment primary key,
Nombre varchar(50),
Provincia varchar(50)
);

create table Clientes(
ID_Cliente int unsigned auto_increment primary key,
Nombre varchar(50),
Apellido varchar(50),
DNI int(8),
email varchar(50),
telefono int (10),
direccion varchar(1000),
cod_postal int(4)
);

create table Envios(
ID_Envio int unsigned auto_increment primary key,
Fecha date,
Origen int unsigned,
Destino int unsigned,
ID_Empresa int unsigned,
estado varchar(50),
ID_Cliente int unsigned,
foreign key (Origen) references Ciudades(ID_Ciudad),
foreign key (Destino) references Ciudades(ID_Ciudad),
foreign key (ID_Empresa) references Empresa_Adherida(ID_Empresa),
foreign key (ID_Cliente) references Clientes(ID_Cliente)
);

create table Empleados(
ID_Empleado int unsigned auto_increment primary key,
Nombre varchar(50),
Apellido varchar(50),
Dni int(8),
email varchar(100),
telefono int (10),
sector varchar(100),
cargo varchar(100),
rol varchar(100)
);

create table Vehiculos (
ID_Vehiculo int unsigned auto_increment primary key,
Precio int (11),
anio int (11),
ID_Empleado int unsigned,
foreign key (ID_Empleado) references Empleados (ID_Empleado)
);

Create table Envio_Vehiculos(
ID_EV int unsigned auto_increment primary key,
ID_Envio int unsigned,
ID_Vehiculo int unsigned,
foreign key (ID_Envio) references Envios(ID_Envio),
foreign key (ID_Vehiculo) references Vehiculos(ID_Vehiculo)
);

create table Envio_Paquetes (
ID_ep int unsigned auto_increment primary key,
ID_Envio int unsigned,
ID_Paquete int unsigned,
foreign key (ID_Envio) references Envios(ID_Envio),
foreign key (ID_Paquete) references Paquetes(ID_Paquete)
);

create table Reportes(
ID_Reporte int unsigned auto_increment primary key,
detalle varchar(1000)
);

create table Tickets(
ID_Ticket int unsigned auto_increment primary key,
ID_Cliente int unsigned,
fecha date,
detalle varchar(1000),
total int(11),
metodospago varchar(100),
foreign key (ID_Cliente) references Clientes (ID_Cliente)
);

create table Reportes_Ticket(
ID_rt int unsigned auto_increment primary key,
ID_Reporte int unsigned,
ID_Ticket int unsigned,
foreign key (ID_Reporte) references Reportes (ID_Reporte),
foreign key (ID_Ticket) references Tickets (ID_Ticket)
);

create table Almacenes (
ID_Almacen int unsigned auto_increment primary key,
direccion varchar(50),
ciudad int unsigned,
nombre varchar(50),
foreign key (ciudad) references Ciudades (ID_Ciudad)
);