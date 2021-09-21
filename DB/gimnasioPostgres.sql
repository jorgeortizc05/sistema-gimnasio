drop table if exists parameter cascade;
drop table if exists type_person cascade;
drop table if exists person cascade;
drop table if exists type_voucher cascade;
drop table if exists type_suscription cascade;
drop table if exists suscription cascade;
drop table if exists category cascade;
drop table if exists city cascade;
drop table if exists method_pay cascade;
drop table if exists product cascade;
drop table if exists company cascade;
	---drop sequence category_seq_id cascade;
	---drop sequence product_seq_id;

	create table parameter (
		id serial not null,
		receipt_number int,
		primary key (id)
	);

	create table type_person (
		id serial not null, -- serial crea una secuencia de manera automatica y no es necesario establecer id
		name varchar(50) unique not NULL,
		description varchar(300),
		primary key (id)
	);

	create table person (
		id serial not null,
		first_name varchar(70) not NULL,
		last_name varchar(70) not null,
		identification_id varchar(16) unique not null,
		address varchar(300),
		email varchar(150),
		birthday DATE,
		phone varchar(40),
		active varchar(1),
		photo varchar(300),
		type_person_id int not null,
		primary key (id),
		foreign key (type_person_id) references type_person (id)
	);

	create table type_voucher (
		id serial not null,
		name varchar(50) unique not null,
		description varchar(300),
		primary key (id)
	);

	create table type_suscription (
		id serial not null,
		name varchar(50) unique not null,
		num_days int,
		price numeric(1000,2),
		description varchar(300),
		primary key (id)
	);

	create table suscription (
		id serial not null,
		receipt_number varchar(70) unique not null,
		date_suscription date not null,
		date_from date not null,
		date_to date not null,
		price numeric(1000,2) not null,
		discount numeric(1000,2),
		total numeric(1000,2),
		comment varchar(300),
		person_id int not null,
		type_suscription_id int not null,
		primary key (id),
		foreign key (person_id) references person (id),
		foreign key (type_suscription_id) references type_suscription (id)
		
	);

	create table category (
		id serial not null,
		name varchar(50) unique not null,
		description varchar(300),
		primary key (id)
	);


	create table city (
		id serial not null,
		name varchar(50) unique not null,
		description varchar(300),
		primary key (id)
	);

	create table method_pay (
		id serial not null,
		name varchar(50) unique not null,
		description varchar(300),
		primary key (id)
	);

	create table product(
		id serial not null,
		name varchar(50) unique not null,
		description varchar(300),
		price numeric(1000,2),
		serial varchar(30),
		photo varchar(300),
		category_id int not null,
		primary key(id),
		foreign key (category_id) references category (id)
	);

	create table company(
		id serial not null,
		ruc varchar(50) unique not null,
		name varchar(50) unique not null,
		description varchar(300),
		address_main varchar(300),
		address_branch varchar(300),
		city_id int not null,
		primary key(id),
		foreign key (city_id) references city (id)
	);

	---------------Datos--------------------------------
	---parameter---
	INSERT INTO public.parameter
	(receipt_number)
	VALUES(1);


	-----Tipo person-----------
	INSERT INTO public.type_person(name, description)VALUES('Cliente', 'person que usa servicios del gimnasio');
	
	------Tipo Comprobante
	INSERT INTO public.type_voucher(name, description)VALUES('Factura', 'Se incluye el IVA del 12%');
	----Tipo suscription---------
	INSERT INTO public.type_suscription(name, num_days, price, description)VALUES('Suscripción de 1 día', 0, 1.5, 'Valido por un día');
	INSERT INTO public.type_suscription(name, num_days, price, description)VALUES('Suscripción de 1 semana', 7, 7, 'Valido por 7 días');
	INSERT INTO public.type_suscription(name, num_days, price, description)VALUES('Suscripción de 2 semanas', 15, 15, 'Valido por 15 días');
	INSERT INTO public.type_suscription(name, num_days, price, description)VALUES('Suscripción de 1 mes', 30, 25, 'Valido por un mes');
	-------suscription--------
	/*INSERT INTO public.suscription
	(receipt_number, fecha_desde, fecha_hasta, price, descuento, totla, comment, person_id, type_suscription_id)
	VALUES('9', '', '', 0, 0, 0, '', 0, 0);*/
	-------category-----------
	INSERT INTO public.category(name, description)VALUES('smartphones', 'solo telefonos');
	INSERT INTO public.category(name, description)VALUES('monitores', 'monitor a usar');
	INSERT INTO public.category(name, description)VALUES('laptops', 'Portatiles para trabajo');

	----city---------
	INSERT INTO public.city(name, description)VALUES('Paute', 'Lugar de establecimiento principal');

	-----Forma Pago
	INSERT INTO public.method_pay(name, description)VALUES('Efectivo', 'Solo dolares');

	----company---------
	INSERT INTO public.company(ruc, name, description, address_main, address_branch, city_id)
	VALUES('111111111111', 'Gimnasio Soliz', 'Comida rapida y gimnasio', 'Paute', 'Paute', 1);

	-------product------
	INSERT INTO public.product(name, description, price, serial, photo, category_id)VALUES('Xiaomi Poco X3', 'Pantalla de 120hz, 5130 mha, carga rapida de 33w', 285, '11111', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3', 1);
	INSERT INTO public.product(name, description, price, serial, photo, category_id)VALUES('Huawei y7', 'Camara de 16 mpx, 3 de RAM y 32 de ROM', 190, '11112', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3',1);
	INSERT INTO public.product(name, description, price, serial, photo, category_id)VALUES('LG 21 Pulgadas', 'Resolucion 1440x900 px', 120, '11113', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3',2);
	INSERT INTO public.product(name, description, price, serial, photo, category_id)VALUES('LG 29 pulgadas', 'Resolucion de 2560x1080',260, '11114', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3', 2);
	INSERT INTO public.product(name, description, price, serial, photo, category_id)VALUES('DELL Gaming g5', 'Dispone de nvidia gtx 1050',1550, '11115', 'ce63dfea-586e-4e32-a089-2b7ee1cd43b3', 3);
