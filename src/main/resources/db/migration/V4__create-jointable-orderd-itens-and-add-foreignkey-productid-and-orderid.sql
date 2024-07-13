CREATE TABLE ordered_itens (
id BINARY(16) NOT NULL,
order_id BINARY(16) NOT NULL,
product_id BINARY(16) NOT NULL,
amount BIGINT NOT NULL,
unitary_value DECIMAL(10,2) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (order_id) REFERENCES orders (id),
FOREIGN KEY (product_id) REFERENCES products (id));