drop database MVC_POO;

Create database MVC_POO;
use MVC_POO;

create table cliente (
id int(3) primary key auto_increment, 		-- 1
nombre varchar (40) not null,  				-- 2
p_apellido varchar (15)  not null, 			-- 3
s_apellido varchar (15),   		-- 4
direccion varchar (30) not null, 			-- 5
telefono varchar (10) not null,  			-- 6
clave varchar(20),			-- 7
cedula varchar(12) not null unique			-- 8
);

insert into cliente values(1,'n1','p1','p11','d1','t1','c1','cc1'),
(2,'n2','p2','p22','d2','t2222','c2','cc2'),
(3,'n3','p3','p33','d3','t3','c3','cc3'),
(4,'n4','p4','p44','d4','t4','c4','cc4'),
(5,'n5','p5','p55','d5','t5','c5','cc5');

create table administrador (
id int(5) primary key not null auto_increment, 		-- 1
nombre varchar (40) not null,  						-- 2
apellido varchar (15)  not null,					-- 3
direccion varchar (30) not null, 					-- 4
telefono varchar (10) not null,  					-- 5
clave varchar(20) unique not null,					-- 6
cedula varchar(12) unique not null					-- 7	
);

insert into administrador (nombre,apellido,direccion,telefono,clave,cedula) values ('adrian','isidro','weno si se','telefono','AA','12345'),
('felipe', 'bejarano', 'no se', 'nose', 'bejarano','54321'),
('an3','aa3','ad3','at3','ac3','acc3'),
('an4','aa4','ad4','at4','ac4','acc4'),
('an5','aa5','ad5','at5','ac5','acc5');

create table cuenta (
id int(3) primary key not null auto_increment, 	-- 1
numero_tarjeta varchar (16), 					-- 2
saldo float (8,2),								-- 3
id_cliente int(3) not null,				-- 4
estado int(1) default 1,				-- 5
constraint foreign key FK_id_cliente (id_cliente) references cliente(id)
);

insert into cuenta values
(1,'101010',1200.98,1,1),
(2,'2020202',76000.00,2,1),
(3,'303030',189000.00,3,1),
(4,'404040',43799.00,3,2),
(5,'5050505',111222.22,4,2);

create table categoria(
id int(3) primary key auto_increment,
descripcion varchar(30) not null,
estado int(1) default 1,
constraint chk_estado_categoria check(estado in(1,0))
);

insert into categoria values
(1,'verduras',1),
(2,'frutas',1),
(3,'bebidas alcoholicas',1),
(4,'dulces',1),
(5,'huevos',1),
(6,'ropa',1),
(7,'calzado',1),
(8,'electrodomesticos',1),
(9,'otro',1);

create table producto(
cod_producto int(5) primary key auto_increment,
nombre varchar(15) not null,
stock int (100), 
precio_venta double (8,2) not null,
descripcion varchar (200) not null,
iva int(4) not null,
id_categoria int(3) not null,
constraint foreign key Fk_id_categoria(id_categoria) references categoria(id)
);
insert into producto values
(1,'tomate',400,340.15,'tomates frescos',12,1),
(2,'cebolla',350,500.00,'cebolla cabezona',14,1),
(3,'chocorramo',65,1500.00,'chocorramo de chocolate',7,4),
(4,'aguila',500,3500.00,'aguila original',7,3),
(5,'camisa',344,54000.00,'camisa roja gucci',14,6),
(6,'manzana',100,1200.00,'manzana roja dulce',14,2),
(7,'pc',10,120000.00,'pc dacell gaming',12,8),
(8,'zapato',10,27000.00,'zapatos nike original,',7,7);

create table cabecera(
id int(3) primary key auto_increment,
idCliente int(3) not null,
constraint foreign key Fk_idCliente_cabecera(idCliente) references cliente(id),
valorPago double(8,2) not null,
fecha date not null,
estado int (1) not null
);

create table carrito(
id int(3) primary key auto_increment,
idCliente int (2) not null,
constraint foreign key Fk_idCliente_carrito(idCliente) references cliente(id),
fecha date not null,
totalCompra double(10,2) not null,
estado int(1) not null,
cant int(5) not null
);

insert into carrito values (1,1,'2023-06-01',48000.00,1),
(2,1,'2023-03-01',76000.00,1),
(3,2,'2023-06-01',4000.00,1);


 -- select max(id) from carrito where idCliente=1;
 
 
create table pedido(
id int(3) primary key auto_increment,
idProducto int(5) not null,
constraint foreign key Fk_idProducto_detalle(idProducto) references producto(cod_producto),
idCliente int(3) not null,
constraint foreign key Fk_idCliente(idCliente) references cliente(id),
cantidad int (2) not null,
precio double(8,2) not null,
subtotal double(10,2) not null,
descuento double(8,2) not null,
iva double(8,2) not null,
totalProducto double(10,2) not null,
estado int(1) not null,-- 1 = por pagar ; 2= pagado
idCarrito int(3) not null,
constraint foreign key fk_idCarrito_pedido(idCarrito) references carrito(id)
);
insert into pedido values (1 ,  3,  1,  5,  1500.00,  4800.00, 120.00,  7,  40000.00, 2, 1);
insert into pedido values (2 ,  3,  1,  3,   500.00,   800.00, 120.00,  7,   8000.00, 1, 1);

create table ventas(
id int(3) primary key auto_increment,
idCarrito int(3) not null,
constraint foreign key Fk_idCarrito_ventas(idCarrito) references Carrito(id),
fecha date not null,
idCuenta int(3) not null,
constraint foreign key Fk_idCuenta_ventas(idCuenta) references cuenta(id)
);
insert into ventas values (1,1,'2023-6-05',1);