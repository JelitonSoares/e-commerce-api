CREATE TABLE products (
id BINARY(16) NOT NULL,
product_name VARCHAR(255) NOT NULL,
product_description VARCHAR(255) NOT NULL,
product_value DECIMAL(10,2) NOT NULL,
product_stock BIGINT NOT NULL,
product_category VARCHAR(255) NOT NULL,
product_register_date DATE NOT NULL,
PRIMARY KEY (id));