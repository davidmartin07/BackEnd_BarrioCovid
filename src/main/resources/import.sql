INSERT INTO usuarios (username, password, nombre, apellido, email) VALUES ('fernikalo', '1234', 'Fernando', 'Guillen', 'fer@example.com');
INSERT INTO compradores (direccion, cp, usuario_id) VALUES ('Calle Falsa 123', 28015, 1);

INSERT INTO usuarios (username, password, nombre, apellido, email) VALUES ('deivid', '1234', 'David', 'Martin', 'david@example.com');
INSERT INTO tiendas (nombre_Tienda, direccion_Tienda, cp, usuario_id) VALUES ('David', 'Sales', 28015, 2);

INSERT INTO usuarios (username, password, nombre, apellido, email) VALUES ('rakel', '1234', 'Raquel', 'Meliveo', 'raquel@example.com');
INSERT INTO voluntarios (usuario_id) VALUES (3);

INSERT INTO roles (nombre) VALUES ('COMPRADOR');
INSERT INTO roles (nombre) VALUES ('VENDEDOR');
INSERT INTO roles (nombre) VALUES ('VOLUNTARIO');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3,3);

INSERT INTO productos (nombre, descripcion, precio, stock, foto, catalogo_id) VALUES ('Producto 1', 'Descripción del producto 1', 10.5, 20, 'https://url-imagen-1.com', 2);
INSERT INTO productos (nombre, descripcion, precio, stock, foto, catalogo_id) VALUES ('Producto 2', 'Descripción del producto 2', 25.0, 10, 'https://url-imagen-2.com', 2);
INSERT INTO productos (nombre, descripcion, precio, stock, foto, catalogo_id) VALUES ('Producto 3', 'Descripción del producto 3', 7.99, 50, 'https://url-imagen-3.com', 2);

INSERT INTO pedidos (hora_De_Recogida, comprador_id, tienda_id) VALUES ('2023-04-24 15:30:00', 1, 2);
