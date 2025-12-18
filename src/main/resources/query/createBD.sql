drop table if exists b2b_temp.product cascade;
drop table if exists b2b_temp.customer cascade;

drop sequence if exists b2b_temp.product_seq cascade;

create sequence b2b_temp.product_seq
    start with 1
    increment by 1
    minvalue 1
    maxvalue 999999999
    nocycle
    cache 20;

create table b2b_temp.country(
    code varchar(3) primary key,
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
);)

create table b2b_temp.customer(
    dni varchar(12) primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(150) not null unique,
    phone varchar(20),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    constraint fk_customer_country
    foreign key (country_code) references b2b_temp.country(code)
);

--Grants on sequences to SA -ms alonsodb
grant all on sequence b2b_temp.product_seq to 'ms-b2b-sa@lat-pcw-npe-16ac.iam';
--Grants on sequences to proxysql sa
grant all on sequence b2b_temp.product_seq to 'cloudsql-proxy-npe-exposition@lat-pcw-npe-16ac.iam';
--Grants for SA to access SQL instance - ms-b2b-sa
ALTER ROLE "ms-b2b-sa@lat-pcw-npe-16ac.iam" with login;
GRANT connect on DATABASE "b2b_portal" to "cloudsql-proxy-npe-exposition@lat-pcw-npe-16ac.iam";
GRANT USAGE, CREATE, ON SCHEMA b2b_temp to "cloudsql-proxy-npe-exposition@lat-pcw-npe-16ac.iam";
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA b2b_temp to "cloudsql-proxy-npe-exposition@lat-pcw-npe-16ac.iam";

--Grants privileges to SA - ms-b2b-sa
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA b2b_temp TO "ms-b2b-sa@lat-pcw-npe-16ac.iam";
--Grants privileges to proxysql sa
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA b2b_temp TO "cloudsql-proxy-npe-exposition@lat-pcw-npe-16ac.iam";

