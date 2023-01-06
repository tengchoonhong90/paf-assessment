drop schema if exists eshop;

select "Creating eshop database" as "";

create database eshop;

use eshop;

select "Creating customers table" as "";

create table customers (
    name varchar(32) unique,
    address varchar(128) not null unique,
    email varchar(128) not null unique,

	primary key(name)
);

select "Inserting records: 5" as "";

LOAD DATA INFILE '/database/data.csv'
INTO TABLE customers
FIELDS TERMINATED BY ':'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

drop schema if exists estore;

select "Creating estore database" as "";

create database estore;

use estore;

select "Creating orders table" as "";

create table orders (
    orderId varchar(8) not null,
    deliveryId varchar(128) not null,
    name varchar(32) not null,
    status DEFAULT "Pending"
	primary key(orderId)
    foreign key(name) references customers(name)
);
