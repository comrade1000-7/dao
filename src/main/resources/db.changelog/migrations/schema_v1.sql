DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
           id int NOT NULL AUTO_INCREMENT,
           name varchar(255) NOT NULL,
           surname varchar(255),
           age int,
           weight int,
           phone_number varchar(255),
           PRIMARY KEY (id)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
            id serial NOT NULL AUTO_INCREMENT,
            date datetime,
            customer_id integer,
            product_name varchar(255),
            amount numeric,
            PRIMARY KEY (id),
            FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);