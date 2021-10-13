create database Grupo31_Equipo_4;
use Grupo31_Equipo_4;

CREATE TABLE clientes 
(
  cedula_cliente bigint(20) PRIMARY KEY,
  direccion_cliente varchar(255) NOT NULL,
  email_cliente varchar(255) NOT NULL,
  nombre_cliente varchar(255) NOT NULL,
  telefono_cliente varchar(255) NOT NULL
) ;

CREATE TABLE usuarios 
(
  cedula_usuario bigint(20) PRIMARY KEY,
  email_usuario varchar(255) NOT NULL,
  nombre_usuario varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  usuario varchar(255) NOT NULL
);

CREATE TABLE proveedores 
(
  nitproveedor bigint(20) PRIMARY KEY,
  ciudad_proveedor varchar(255) NOT NULL,
  direccion_proveedor varchar(255) NOT NULL,
  nombre_proveedor varchar(255) NOT NULL,
  telefono_proveedor varchar(255) NOT NULL
);

CREATE TABLE productos
(
  codigo_producto bigint(20) auto_increment PRIMARY KEY,
  ivacompra double NOT NULL,
  nitproveedor bigint(20) NOT NULL,
  nombre_producto varchar(255) NOT NULL,
  precio_compra double NOT NULL,
  precio_venta double NOT NULL
);
alter table productos add foreign key (nitproveedor) references proveedores(nitproveedor);

CREATE TABLE ventas
(
  codigo_venta bigint(20) auto_increment PRIMARY KEY,
  cedula_cliente bigint(20) NOT NULL,
  cedula_usuario bigint(20) NOT NULL,
  ivaventa double NOT NULL,
  total_venta double NOT NULL,
  valor_venta double NOT NULL
);
alter table ventas add foreign key (cedula_cliente) references clientes(cedula_cliente);
alter table ventas add foreign key (cedula_usuario) references usuarios(cedula_usuario);
CREATE TABLE detalle_ventas
(
  codigo_detalle_venta bigint(20) auto_increment PRIMARY KEY,
  cantidad_producto int(11) NOT NULL,
  codigo_producto bigint(20) NOT NULL,
  codigo_venta bigint(20) NOT NULL,
  valor_total double NOT NULL,
  valor_venta double NOT NULL,
  valoriva double NOT NULL
);

alter table detalle_ventas add foreign key (codigo_producto) references productos(codigo_producto);
alter table detalle_ventas add foreign key (codigo_venta) references ventas(codigo_venta);