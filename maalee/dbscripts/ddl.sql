create table users (email_id varchar(50) primary key, phone_number varchar(15), password varchar(100), date_registered datetime, name varchar(100));

create table product_categories (id bigint auto_increment primary key, name varchar(100));

create table products (id bigint primary key, name varchar(100), price float, category_id bigint, foreign key(category_id) references product_categories(id));

create table inventories (id bigint primary key, quantity float, units varchar(50));

create table orders(id bigint auto_increment primary key, created_date datetime, total_amount float, user_id varchar(50));

create table order_items(id bigint auto_increment primary key, product_id bigint, rate float, quantity float, order_id bigint, amount float);

