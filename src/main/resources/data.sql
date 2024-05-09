INSERT INTO CONFIGURATION (PROPIEDAD, VALOR) VALUES ('1', 'Valor 1');

-- Inserción de categorías
INSERT INTO categories (id, name) VALUES (1, 'Electrónicos');
INSERT INTO categories (id, name) VALUES (2, 'Ropa');
INSERT INTO categories (id, name) VALUES (3, 'Hogar');

-- Inserción de productos
INSERT INTO products (id, name, category_id) VALUES (1, 'Televisor', 1); -- Producto perteneciente a la categoría Electrónicos
INSERT INTO products (id, name, category_id) VALUES (2, 'Camiseta', 2); -- Producto perteneciente a la categoría Ropa
INSERT INTO products (id, name, category_id) VALUES (3, 'Mesa', 3);     -- Producto perteneciente a la categoría Hogar


-- Insertando datos en la tabla VEHICLES
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('V1', 'Toyota', 'Corolla', 2019, 1800);
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('V2', 'Honda', 'Civic', 2020, 2000);
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('V3', 'Ford', 'Focus', 2018, 1600);


-- Insertando datos en la tabla QUOTES
INSERT INTO quotes (ID, ESTATE, PRICE, VEHICLE_ID) VALUES (1, 'En espera', '1000', 'V1');
INSERT INTO quotes (ID, ESTATE, PRICE, VEHICLE_ID) VALUES (2, 'Aceptada', '1500', 'V2');
INSERT INTO quotes (ID, ESTATE, PRICE, VEHICLE_ID) VALUES (3, 'Rechazada', '800', 'V3');

