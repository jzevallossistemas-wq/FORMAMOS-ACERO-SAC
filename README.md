# Sistema de Gestión FORMAMOS ACERO SAC - Guía de Inicio

## 🚀 Inicio Rápido

### Prerrequisitos
- Java 11 o superior
- Maven 3.6+
- MySQL 8.0+

### Configuración de Base de Datos

1. Crear base de datos MySQL:
```sql
CREATE DATABASE formamos_acero_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Configurar credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/formamos_acero_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
```

### Compilar y Ejecutar

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn spring-boot:run
```

### Acceder a la Aplicación

Abrir navegador en: http://localhost:8080

## 📋 Funcionalidades Implementadas

### ✅ Módulo Pre Órdenes (Completo)
- Lista con paginación
- Crear nueva pre orden
- Editar pre orden existente
- Eliminar pre orden
- Ver detalles

### ✅ Base de Datos
11 tablas creadas automáticamente:
- cliente
- proveedor
- pre_orden
- orden
- solicitud_efectivo
- solicitud_viatico
- solicitud_gasto_viaje
- cotizacion_pasajes
- comparativo_precios_pasajes
- comparativo_precios_compra
- auditoria_movimiento

## 🎨 Características de la UI

- Dashboard con estadísticas
- Menú de navegación responsive
- Formularios con validación
- Tablas con acciones (Ver, Editar, Eliminar)
- Paginación
- Búsqueda
- Mensajes de feedback

## 🔧 Tecnologías

- Spring Boot 2.7.14
- Java 11
- MySQL Connector/J 8.3.0 (patched for security vulnerabilities)
- Hibernate/JPA
- Thymeleaf
- Lombok
- Bootstrap 5
- iText 7.2.5 (PDF)
- Apache POI 5.2.3 (Excel)

## 📁 Estructura del Proyecto

```
src/main/java/com/formamosacero/
├── FormamosAceroApplication.java    # Main class
├── config/
│   └── WebConfig.java                # Web configuration
├── models/                           # 11 entity models
│   ├── Cliente.java
│   ├── Proveedor.java
│   ├── PreOrden.java
│   ├── Orden.java
│   ├── SolicitudEfectivo.java
│   ├── SolicitudViatico.java
│   ├── SolicitudGastoViaje.java
│   ├── CotizacionPasajes.java
│   ├── ComparativoPreciosPasajes.java
│   ├── ComparativoPreciosCompra.java
│   └── AuditoriaMovimiento.java
├── repositories/                     # 11 repositories
├── services/                         # 5 services
│   ├── ClienteService.java
│   ├── ProveedorService.java
│   ├── PreOrdenService.java
│   ├── OrdenService.java
│   └── AuditoriaService.java
└── controller/                       # 2 controllers
    ├── HomeController.java
    └── PreOrdenController.java
```

## 📝 Datos de Ejemplo

Al ejecutar por primera vez, se pueden insertar datos de ejemplo:

```sql
-- Clientes
INSERT INTO cliente (dni, ruc, razon_social, nombres, apellidos, email, telefono, direccion, ciudad, pais, area, departamento, estado, fecha_creacion, fecha_modificacion) VALUES
('12345678', '20123456789', 'Constructora ABC SAC', 'Juan', 'Pérez', 'juan.perez@constructoraabc.com', '987654321', 'Av. Principal 123', 'Lima', 'Perú', 'Compras', 'Logística', 'ACTIVO', NOW(), NOW()),
('87654321', '20987654321', 'Inmobiliaria XYZ EIRL', 'María', 'García', 'maria.garcia@inmobiliariaxyz.com', '912345678', 'Jr. Comercio 456', 'Lima', 'Perú', 'Obras', 'Proyectos', 'ACTIVO', NOW(), NOW());

-- Proveedores
INSERT INTO proveedor (ruc, razon_social, contacto, email, telefono, direccion, ciudad, pais, tipo_proveedor, categoria, estado, fecha_creacion, fecha_modificacion) VALUES
('20111222333', 'Aceros del Norte SAC', 'Pedro Sánchez', 'ventas@acerosnorte.com', '945678901', 'Av. Industrial 789', 'Lima', 'Perú', 'Materiales', 'Acero', 'ACTIVO', NOW(), NOW()),
('20444555666', 'Ferretería Central EIRL', 'Ana López', 'contacto@ferreteriacentral.com', '923456789', 'Jr. Mercado 321', 'Lima', 'Perú', 'Herramientas', 'General', 'ACTIVO', NOW(), NOW());

-- Pre Órdenes
INSERT INTO pre_orden (numero, fecha, cliente_id, proveedor_id, solicitante, area, concepto, monto, moneda, estado, vb_gerencia, autorizacion, observaciones, fecha_creacion, fecha_modificacion, usuario_creacion, usuario_modificacion) VALUES
('PRE-000001', CURDATE(), 1, 1, 'Juan Pérez', 'Compras', 'Compra de acero estructural', 15000.00, 'PEN', 'APROBADO', 1, 'Gerencia General', 'Urgente', NOW(), NOW(), 'admin', 'admin'),
('PRE-000002', CURDATE(), 2, 2, 'María García', 'Obras', 'Herramientas para construcción', 8500.50, 'PEN', 'PENDIENTE', 0, NULL, NULL, NOW(), NOW(), 'admin', 'admin');
```

## 🔜 Próximos Pasos

Para completar el sistema, se deben implementar:

1. Controladores y vistas para los módulos restantes:
   - Órdenes
   - Solicitud Efectivo
   - Solicitud Viáticos
   - Solicitud Gasto Viaje
   - Cotización Pasajes
   - Comparativo Precios Pasajes
   - Comparativo Precios Compra
   - Clientes
   - Proveedores

2. Generación de PDF con iText

3. Exportación a Excel con Apache POI

4. Filtros avanzados

5. Reportes y estadísticas

6. Autenticación y autorización con Spring Security

7. Tests unitarios

## 🐛 Solución de Problemas

### Error de conexión a MySQL
```
Verificar que MySQL esté ejecutándose:
sudo service mysql status
sudo service mysql start
```

### Error de compilación
```
Limpiar y recompilar:
mvn clean install
```

### Puerto 8080 ocupado
```
Cambiar el puerto en application.properties:
server.port=8081
```

## 📞 Soporte

Para más información o ayuda, consultar la documentación de Spring Boot:
https://spring.io/projects/spring-boot

---

© 2024 FORMAMOS ACERO SAC - Sistema de Gestión
