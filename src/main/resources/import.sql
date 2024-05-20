INSERT INTO `usuario`(`nombre`, `username`, `password`, `correo`, `telefono`) VALUES ('Juan Pérez', 'juanpe', 'password123', 'juan.perez@example.com', '600123456');
INSERT INTO `usuario`(`nombre`, `username`, `password`, `correo`, `telefono`) VALUES ('María García', 'mery', 'securePass456', 'maria.garcia@example.com', '600654321');
INSERT INTO `usuario`(`nombre`, `username`, `password`, `correo`, `telefono`) VALUES ('Carlos López', 'carpe', 'myPassword789', 'carlos.lopez@example.com', '600987654');

INSERT INTO `bar`(`nombre`, `provincia`, `ciudad`, `direccion`, `calificacion`, `telefono`, `correo`) VALUES ('Bar Central', 'Madrid', 'Madrid', 'Calle Mayor 1', 4, '912345678', 'barcentral@example.com');
INSERT INTO `bar`(`nombre`, `provincia`, `ciudad`, `direccion`, `calificacion`, `telefono`, `correo`) VALUES ('La Taberna', 'Barcelona', 'Barcelona', 'Avenida Diagonal 23', 4, '934567890', 'lataberna@example.com');
INSERT INTO `bar`(`nombre`, `provincia`, `ciudad`, `direccion`, `calificacion`, `telefono`, `correo`) VALUES ('El Rincón', 'Valencia', 'Valencia', 'Calle de la Paz 10', 4, '963456789', 'elrincon@example.com');
INSERT INTO `bar`(`nombre`, `provincia`, `ciudad`, `direccion`, `calificacion`, `telefono`, `correo`) VALUES ('Café Moderno', 'Sevilla', 'Sevilla', 'Plaza Nueva 5', 4, '954321987', 'cafemoderno@example.com');
INSERT INTO `bar`(`nombre`, `provincia`, `ciudad`, `direccion`, `calificacion`, `telefono`, `correo`) VALUES ('Bodega Antigua', 'Bilbao', 'Bilbao', 'Calle del Perro 9', 4, '944567123', 'bodegaantigua@example.com');

INSERT INTO `reserva`(`usuario`, `bar`, `comensales`, `fecha`, `hora`) VALUES (1, 1, '1', '2024-06-15', '20:00');
INSERT INTO `reserva`(`usuario`, `bar`, `comensales`, `fecha`, `hora`) VALUES (2, 2, '2', '2024-06-16', '21:00');
INSERT INTO `reserva`(`usuario`, `bar`, `comensales`, `fecha`, `hora`) VALUES (3, 3, '3', '2024-06-17', '19:30');
INSERT INTO `reserva`(`usuario`, `bar`, `comensales`, `fecha`, `hora`) VALUES (1, 4, '5', '2024-06-18', '18:00');
INSERT INTO `reserva`(`usuario`, `bar`, `comensales`, `fecha`, `hora`) VALUES (2, 5, '6', '2024-06-19', '20:30');
