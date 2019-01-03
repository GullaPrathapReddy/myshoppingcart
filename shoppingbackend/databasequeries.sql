create table Catagory(
	id  identity,
	name varchar2(50),
	description varchar2(250),
	img_url varchar2(50),
	is_active boolean,
	constraint catagory_pk_id primary key(id)
);