-- Database schema for FORMAMOS ACERO SAC

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS formamos_acero;
USE formamos_acero;

-- Cliente table
CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefono VARCHAR(50),
    direccion VARCHAR(500),
    ciudad VARCHAR(100),
    estado VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Proveedor table
CREATE TABLE IF NOT EXISTS proveedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefono VARCHAR(50),
    direccion VARCHAR(500),
    ciudad VARCHAR(100),
    pais VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Orden table
CREATE TABLE IF NOT EXISTS orden (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    proveedor_id BIGINT,
    monto DOUBLE,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);

-- Preorden table
CREATE TABLE IF NOT EXISTS preorden (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    proveedor_id BIGINT,
    descripcion TEXT,
    monto DOUBLE,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);

-- SolicitudEfectivo table
CREATE TABLE IF NOT EXISTS solicitud_efectivo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    solicitante VARCHAR(255),
    monto DOUBLE,
    motivo TEXT,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- SolicitudViatico table
CREATE TABLE IF NOT EXISTS solicitud_viatico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    solicitante VARCHAR(255),
    destino VARCHAR(255),
    fecha_inicio DATE,
    fecha_fin DATE,
    monto DOUBLE,
    motivo TEXT,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- CotizacionPasajes table
CREATE TABLE IF NOT EXISTS cotizacion_pasajes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    proveedor_id BIGINT,
    origen VARCHAR(255),
    destino VARCHAR(255),
    fecha_viaje DATE,
    precio DOUBLE,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);

-- ComparativoPrecioPasajes table
CREATE TABLE IF NOT EXISTS comparativo_precio_pasajes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    descripcion TEXT,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- ComparativoPrecioCompra table
CREATE TABLE IF NOT EXISTS comparativo_precio_compra (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(100) NOT NULL UNIQUE,
    fecha DATE,
    descripcion TEXT,
    estado VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create indexes for better performance
CREATE INDEX idx_cliente_email ON cliente(email);
CREATE INDEX idx_proveedor_email ON proveedor(email);
CREATE INDEX idx_orden_numero ON orden(numero);
CREATE INDEX idx_orden_fecha ON orden(fecha);
CREATE INDEX idx_preorden_numero ON preorden(numero);
CREATE INDEX idx_solicitud_efectivo_numero ON solicitud_efectivo(numero);
CREATE INDEX idx_solicitud_viatico_numero ON solicitud_viatico(numero);
CREATE INDEX idx_cotizacion_pasajes_numero ON cotizacion_pasajes(numero);
