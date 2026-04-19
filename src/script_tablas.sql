CREATE DATABASE IF NOT EXISTS bd_reservas_hotel;
USE bd_reservas_hotel;

CREATE TABLE IF NOT EXISTS t_clientes (
                                          identificacion VARCHAR(30) PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    correo VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS t_habitaciones (
                                              numero INT PRIMARY KEY,
                                              tipo VARCHAR(50) NOT NULL,
    precio_por_noche DOUBLE NOT NULL,
    disponible BOOLEAN NOT NULL
    );

CREATE TABLE IF NOT EXISTS t_reservas (
                                          codigo_reserva VARCHAR(30) PRIMARY KEY,
    fecha_entrada VARCHAR(20) NOT NULL,
    fecha_salida VARCHAR(20) NOT NULL,
    identificacion_cliente VARCHAR(30) NOT NULL,
    numero_habitacion INT NOT NULL,
    estado VARCHAR(20) NOT NULL,
    FOREIGN KEY (identificacion_cliente) REFERENCES t_clientes(identificacion),
    FOREIGN KEY (numero_habitacion) REFERENCES t_habitaciones(numero)
    );