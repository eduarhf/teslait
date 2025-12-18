drop table if exists b2b_temp.product cascade;
drop table if exists b2b_temp.customer cascade;
drop table if exists b2b_temp.country cascade;
drop table if exists b2b_temp.status cascade;
drop table if exists b2b_temp.prepaid_temp cascade;

drop sequence if exists b2b_temp.product_seq cascade;
drop sequence if exists b2b_temp.prepaid_temp_id_prepaid_seq cascade;

create table b2b_temp.country(
    id_country varchar(3) primary key,
    description varchar(30) not null
);
create table b2b_temp.status(
    id_status varchar(10) primary key,
    description varchar(30) not null
);
create table b2b_temp.product(
    platform varchar(20) primary key,
    code varchar(50) not null,
    name varchar(255) not null,
    description text,
    price numeric(15,2) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);

create table b2b_temp.customer(
    dni varchar(12) primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
	id_country varchar(3) not null,
    email varchar(150) not null unique,
    phone varchar(20),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    constraint fk_customer_country
    foreign key (id_country) references b2b_temp.country(id_country)
);

create table b2b_temp.prepaid_temp(
    id_prepaid serial,
    dni varchar(12) not null,
    id_status varchar(10) not null,
    invoice_number varchar(50) not null,
    name varchar(255) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    constraint PK_id_prepaid primary key (invoice_number, dni)
);
alter table b2b_temp.prepaid_temp
    add constraint FK_status
    foreign key (id_status) references b2b_temp.status(id_status);
