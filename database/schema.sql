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
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;