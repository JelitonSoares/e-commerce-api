CREATE TABLE orders (
id BINARY(16) NOT NULL,
client_id BINARY(16) NOT NULL,
order_date DATE NOT NULL,
order_total_value DECIMAL(10,2) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(client_id) REFERENCES clients (id));