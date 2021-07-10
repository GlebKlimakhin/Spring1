BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id BIGINT PRIMARY KEY, title VARCHAR(255), cost INTEGER);
INSERT INTO products (id, title, cost) VALUES
(1, "fork", 23),
(3, "flok", 32),
(5, "book", 10);

