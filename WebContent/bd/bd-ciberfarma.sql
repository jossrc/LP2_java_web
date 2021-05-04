-- borra la bd si existe
DROP DATABASE IF EXISTS ciberfarmaweb;
-- creamos la bd
CREATE DATABASE ciberfarmaweb;
-- activamos la bd
USE ciberfarmaweb;

create table tb_tipos(
idtipo		int not null primary key,
descripcion varchar(15)
);

create table tb_estados(
idestado    int not null primary key,
descripcion varchar(15)
);

CREATE TABLE tb_usuarios(
codigo  int auto_increment,
nombre varchar(40),
apellido varchar(40),
usuario  char(45) NOT NULL unique,
clave    char(5),
fnacim  date  null,
tipo    int DEFAULT 2,
estado  int(1) DEFAULT 1,
primary key (codigo),
foreign key (tipo) references tb_tipos(idtipo),
foreign key (estado) references tb_estados(idestado)
);
        
create table tb_categorias(
idcategoria	int not null primary key,
descripcion varchar(45)
);

create table tb_productos(
idprod char(5) not null,
descripcion varchar(45),
stock int,
precio decimal(8,2),
idcategoria int,
estado boolean,
primary key (idprod), 
foreign key (idcategoria) references tb_categorias(idcategoria)
);

-- inserts
insert into tb_tipos values (1, 'administrativo');
insert into tb_tipos values (2, 'cliente');

insert into tb_estados values (1, 'activo');
insert into tb_estados values (2, 'eliminado');
insert into tb_estados values (3, 'suspendido');

insert into tb_usuarios values (null,'Tito', 'Ciber','U001@gmail.com', '10001', curdate(),1,1);
insert into tb_usuarios values (null,'Zoila', 'Baca','U002@gmail.com', '10002', curdate(),2,1);
insert into tb_usuarios values (null,'Willy', 'Wonka','U003@gmail.com', '10003', curdate(),2,3);
insert into tb_usuarios values (null,'jose', 'Atuncar','U004@hotmail.com', '10004', curdate(),2,2);

insert into tb_categorias values (1, 'Pastillas');
insert into tb_categorias values (2, 'Jarabe');
insert into tb_categorias values (3, 'Cremas');
insert into tb_categorias values (4, 'Tocador');
insert into tb_categorias values (5, 'Cuidado');
insert into tb_categorias values (6, 'Otros');

insert into tb_productos values ('P0001','Panadol cj 10',20,1.85,1,1);
insert into tb_productos values ('P0002','Curitas unidad',100,1.0,3,1);
insert into tb_productos values ('P0003','Kita tos',80,15.0,2,1);
insert into tb_productos values ('P0004','Achiz',120,1.0,1,1);
insert into tb_productos values ('P0005','Jaboncillo cj',120,1.0,3,1);
insert into tb_productos values ('P0006','Termometro',80,2.8,5,1);
insert into tb_productos values ('P0007','Panadol jarabe pq',40,10.5,2,1);
insert into tb_productos values ('P0008','Antalgina',55,1.8,1,1);
insert into tb_productos values ('P0009','Ibuprofeno',60,15.0,4,1);
insert into tb_productos values ('P0010','Mejoralito NiÃ±os',10,1.5,1,1);
insert into tb_productos values ('P0011','Panadol jarabe',10,1.5,2,1);
insert into tb_productos values ('P0012','Jabon Neko',40,8.5,4,1);
insert into tb_productos values ('P0013','Pañales x 24u',10,1.5,5,1);
insert into tb_productos values ('P0014','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0015','Champu Amigo',50,0.99,5,1);
insert into tb_productos values ('P0016','Mejoralito',10,1.5,4,1);
insert into tb_productos values ('P0017','SinDolor',23,1.5,6,1);
insert into tb_productos values ('P0018','Mejoralito Forte',10,1.5,2,1);
insert into tb_productos values ('P0019','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0020','Mejoralito Forte',10,1.5,3,1);
insert into tb_productos values ('P0021','Mejoralito Forte',10,1.5,2,1);
insert into tb_productos values ('P0022','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0023','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0024','Mejoralito Forte',10,1.5,2,1);
insert into tb_productos values ('P0025','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0026','Mejoralito Forte',10,1.5,3,1);
insert into tb_productos values ('P0027','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0028','Mejoralito Forte',10,1.5,4,1);
insert into tb_productos values ('P0029','Mejoralito Forte',10,1.5,1,1);
insert into tb_productos values ('P0030','Mejoralito Forte',10,1.5,5,1);
insert into tb_productos values ('P0031','Mejoralito UForte',10,0.99,5,1);

-- consultas
SELECT * FROM tb_usuarios;
SELECT * FROM tb_productos;
select * from tb_categorias;


-- ejemplo de procedimientos almancenados de consulta
DELIMiTER $$
create procedure usp_validaAcceso (usr char(45), pas char(5))
begin
select * from tb_usuarios where usuario = usr and clave = pas;
end$$
DELIMiTER ;

