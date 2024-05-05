-- Inserción de categorías
INSERT INTO categories (id, name) VALUES (1, 'Electrónicos');
INSERT INTO categories (id, name) VALUES (2, 'Ropa');
INSERT INTO categories (id, name) VALUES (3, 'Hogar');

-- Inserción de productos
INSERT INTO products (id, name, category_id) VALUES (1, 'Televisor', 1); -- Producto perteneciente a la categoría Electrónicos
INSERT INTO products (id, name, category_id) VALUES (2, 'Camiseta', 2); -- Producto perteneciente a la categoría Ropa
INSERT INTO products (id, name, category_id) VALUES (3, 'Mesa', 3);     -- Producto perteneciente a la categoría Hogar

