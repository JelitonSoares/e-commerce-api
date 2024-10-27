CREATE TABLE orders (
id VARCHAR(36) NOT NULL,
client_id VARCHAR(36) NOT NULL,
order_date DATE NOT NULL,
order_total_value DECIMAL(10,2) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(client_id) REFERENCES clients (id));