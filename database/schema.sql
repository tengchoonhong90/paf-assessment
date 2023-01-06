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

select "Creating orders table" as "";

create table orders (
    orderId varchar(8) not null,
    name varchar(32) not null,
	primary key(orderId)
    foreign key(name) references customers(name)
);

select "Creating items table" as "";

create table items (
    orderId varchar(8) not null,
    item varchar(128) not null,
    quantity int not null,
    primary key(orderId)
    foreign key(orderId) references orders(orderId)
);

select "Creating order_status table" as "";

create table order_status (
    order_id varchar(8) not null,
    delivery_id varchar(128) not null,
    status ENUM ("pending", "dispatch"),
    status_update DATETIME,

    primary key(order_id)
    foreign key(order_id) references orders(orderId)
    
);