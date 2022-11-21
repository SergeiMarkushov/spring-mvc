DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost INT, PRIMARY KEY(id));
INSERT INTO products (title, cost) VALUES ('Milk', 100), ('Bread', 80), ('Butter', 89);