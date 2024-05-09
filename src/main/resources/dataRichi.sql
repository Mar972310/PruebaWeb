-- Insertar categorías de ejemplo
INSERT INTO CATEGORIES (ID, NAME) VALUES ('1', 'Electronics');
INSERT INTO CATEGORIES (ID, NAME) VALUES ('2', 'Clothing');
INSERT INTO CATEGORIES (ID, NAME) VALUES ('3', 'Books');
INSERT INTO CATEGORIES (ID, NAME) VALUES ('4', 'Furniture');
INSERT INTO CATEGORIES (ID, NAME) VALUES ('5', 'Toys');

-- Insertar vehículos de ejemplo
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('1', 'Toyota', 'Corolla', 2022, 1600);
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('2', 'Honda', 'Civic', 2023, 1500);
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('3', 'Ford', 'F-150', 2021, 2500);
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('4', 'Chevrolet', 'Camaro', 2024, 2000);
INSERT INTO VEHICLES (ID, BRAND, MODEL, VEHICLE_YEAR, CYLINDER_CAPACITY) VALUES ('5', 'BMW', 'X5', 2022, 3000);

-- Insertar cotizaciones de ejemplo
INSERT INTO QUOTES (ID, ESTATE, PRICE, VEHICLE_ID) VALUES ('1', 'Active', '20000', '1');
INSERT INTO QUOTES (ID, ESTATE, PRICE, VEHICLE_ID) VALUES ('2', 'Active', '18000', '2');
INSERT INTO QUOTES (ID, ESTATE, PRICE, VEHICLE_ID) VALUES ('3', 'Active', '25000', '3');
INSERT INTO QUOTES (ID, ESTATE, PRICE, VEHICLE_ID) VALUES ('4', 'Active', '35000', '4');
INSERT INTO QUOTES (ID, ESTATE, PRICE, VEHICLE_ID) VALUES ('5', 'Active', '40000', '5');

-- Insertar productos de ejemplo
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('1', 'Laptop', 'Example laptop description', 'Technical specs here', '/images/aceite.png', '1000', 'USD', 10, 5, '1', '1');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('2', 'T-shirt', 'Cotton T-shirt', 'Size: M, Color: Red', '/images/acelerador.png', '20', 'USD', 0, 5, '2', '2');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('3', 'Book', 'Fiction novel', 'Author: John Doe', '/images/amortiguador.png', '15', 'USD', 0, 5, '3', '3');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('4', 'Chair', 'Wooden chair', 'Size: Standard', '/images/balanceo-de-ruedas.png', '50', 'USD', 0, 5, '4', '4');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('5', 'Action Figure', 'Superhero action figure', 'Size: 12 inches', '/images/carro-hidraulico.png', '10', 'USD', 0, 5, '5', '5');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('11', 'Laptop', 'Example laptop description', 'Technical specs here', '/images/signo-de-interrogacion.png', '1000', 'USD', 0, 5, '1', '1');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('12', 'T-shirt', 'Cotton T-shirt', 'Size: M, Color: Red', '/images/signo-de-interrogacion.png', '20', 'USD', 0, 5, '2', '2');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('13', 'Book', 'Fiction novel', 'Author: John Doe', '/images/signo-de-interrogacion.png', '15', 'USD', 15, 5, '3', '3');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('14', 'Chair', 'Wooden chair', 'Size: Standard', '/images/signo-de-interrogacion.png', '50', 'USD', 0, 5, '4', '4');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('15', 'Action Figure', 'Superhero action figure', 'Size: 12 inches', '/images/signo-de-interrogacion.png', '10', 'USD', 0, 5, '5', '5');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('10', 'Laptop', 'Example laptop description', 'Technical specs here','/images/signo-de-interrogacion.png', '1000', 'USD', 0, 5, '1', '1');
INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, TECHNICAL_DESCRIPTION, IMAGE, PRICE, COIN, DISCOUNT, TAX, CATEGORY_ID, QUOTE_ID) VALUES ('20', 'T-shirt', 'Cotton T-shirt', 'Size: M, Color: Red', '/images/signo-de-interrogacion.png', '20', 'USD', 0, 5, '2', '2');