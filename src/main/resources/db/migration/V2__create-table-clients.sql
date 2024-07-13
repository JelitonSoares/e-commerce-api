CREATE TABLE clients (
id BINARY(16) NOT NULL,
client_name VARCHAR(50) NOT NULL,
client_document VARCHAR(11) NOT NULL,
client_public_place VARCHAR(255) NOT NULL,
client_number BIGINT,
client_neighborhood VARCHAR(255) NOT NULL,
client_city VARCHAR(255) NOT NULL,
client_uf VARCHAR(2) NOT NULL,
client_cep VARCHAR(8) NOT NULL,
client_complement VARCHAR(255),
PRIMARY KEY (id));