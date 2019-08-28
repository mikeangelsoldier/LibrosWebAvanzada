/*JSP*/
DROP SCHEMA IF EXISTS libros_web_avanzada;
CREATE DATABASE libros_web_avanzada;

use libros_web_avanzada;


CREATE TABLE libro(
	clave_isbn varchar(13) PRIMARY KEY not null,
    titulo varchar(100) not null,
    autor varchar(80) not null,
	editorial varchar(30) null,
	genero varchar(40) not null,
	fecha_publicacion date not null,
    lugar_publicacion varchar(100) not null,
    numero_edicion varchar(30) not null,
	numero_de_paginas int not null,
    estatus varchar(20)
)ENGINE=InnoDB;


/*************************************************************************Llaves foraneas **********/
/***************************Llaves foraneas ..*/




/***********************************************************************************
									PROCEDIMIENTOS ALMACENADOS
****************************************************************************************/
/******************PROCEDIMIENTOS DE libro**********/


DROP PROCEDURE IF EXISTS getLibros;
CREATE PROCEDURE getLibros(
)
select * from libro where estatus='ACTIVO';
/*
select * from libro;
call getLibros();
*/

DROP PROCEDURE IF EXISTS getLibro;
CREATE PROCEDURE getLibro(
clave varchar(13)
)
select * from libro where libro.clave_isbn=clave and estatus='ACTIVO';
/*
select * from libro;
call getLibro('9789706277435');
*/

 DROP PROCEDURE IF EXISTS insertarLibro;
 CREATE PROCEDURE insertarLibro(
    clave_isbn varchar(13),
    titulo varchar(100),
    autor varchar(80),
	editorial varchar(30) ,
	genero varchar(40),
	fecha_publicacion date,
    lugar_publicacion varchar(100),
    numero_edicion varchar(30),
	numero_de_paginas int
 )
 insert into libro  values(clave_isbn,titulo,autor,editorial,genero,fecha_publicacion,
							lugar_publicacion,numero_edicion,numero_de_paginas,'ACTIVO');
 
 call insertarLibro('9789706277435','Método de Guitarra Moderna','Prof- Ramón Gálvez L.','época',
					'música','2009-01-01','México, D.F','Primera',95);
call insertarLibro('9786070028731','Aprende a tocar guitarra fácilmente','Juan Antonio Amezcua Castillo','Más lectores',
					'música','2010-05-21','México, D.F','Primera',95);

 DROP PROCEDURE IF EXISTS updateLibro;
 CREATE PROCEDURE updateLibro(
	clave_isbn varchar(13),
    titulo varchar(100),
    autor varchar(80),
	editorial varchar(30) ,
	genero varchar(40),
	fecha_publicacion date,
    lugar_publicacion varchar(100),
    numero_edicion varchar(30),
	numero_de_paginas int
 )
 update libro as l set l.titulo=titulo,l.autor=autor,l.editorial=editorial,l.genero=genero,
				l.fecha_publicacion=fecha_publicacion,l.lugar_publicacion=lugar_publicacion,
                l.numero_edicion=numero_edicion,l.numero_de_paginas=numero_de_paginas
			where l.clave_isbn = clave_isbn;
/*
call updateLibro('9786070028731','Aprende a tocar guitarra fácilmente','Juan Antonio Amezcua Castillo','Más lectores',
					'música','2010-05-21','México, D.F','Segunda',95);
 */
 
DROP PROCEDURE IF EXISTS deleteLibro;
CREATE PROCEDURE deleteLibro(
	clave_isbn varchar(13)
)
 update libro as l set l.estatus='INACTIVO'
 where l.clave_isbn =clave_isbn;
 /*
 call deleteLibro(9789706277435);
 */




/*
DROP PROCEDURE IF EXISTS getFiltroLibro;
CREATE PROCEDURE getFiltroLibro( 
	filtro varchar(50)
)
SELECT * from libro AS l
	where (CONVERT(c.id ,CHAR)  like (CONCAT('%',filtro,'%'))//Uso convert para comparar el valor char recibido con un int o double/
    OR c.usuario  like (CONCAT('%',filtro,'%'))
    OR c.nombre like (CONCAT('%',filtro,'%'))
	OR c.apellidos like (CONCAT('%',filtro,'%'))
	OR c.correo like (CONCAT('%',filtro,'%')))
    AND status=1;
    */
/*
 call getFiltroCliente('1');
  call getFiltroCliente('Jor');
    call getFiltroCliente('Gu');
 */
 
