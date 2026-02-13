# FORMAMOS ACERO SAC - Sistema de Gestión Empresarial

Sistema completo de gestión empresarial con 9 módulos CRUD desarrollado con Spring Boot, Thymeleaf y Bootstrap 5.

## 🚀 Características

### Módulos Implementados

1. **Clientes** - Gestión de clientes con DNI, RUC y datos de contacto
2. **Proveedores** - Administración de proveedores con categorías
3. **Pre Órdenes** - Gestión de pre órdenes de compra
4. **Órdenes** - Órdenes de compra con detalles de pago y entrega
5. **Solicitudes de Efectivo** - Solicitudes de desembolso de efectivo
6. **Solicitudes de Viático** - Gestión de viáticos para viajes de trabajo
7. **Cotización de Pasajes** - Cotizaciones de pasajes aéreos
8. **Comparativo de Pasajes** - Análisis comparativo de precios de pasajes
9. **Comparativo de Compras** - Comparación de precios entre proveedores

### Funcionalidades por Módulo

- ✅ Operaciones CRUD completas (Crear, Leer, Actualizar, Eliminar)
- ✅ Búsqueda y filtros avanzados
- ✅ Validación de formularios
- ✅ Interfaz responsive con Bootstrap 5
- ✅ Mensajes flash de confirmación
- ✅ Confirmación de eliminación
- ✅ Relaciones entre entidades (Cliente/Proveedor)

## 🛠️ Tecnologías

- **Backend:** Spring Boot 2.6.6
- **Frontend:** Thymeleaf, Bootstrap 5, Bootstrap Icons
- **Base de Datos:** MySQL 8.0
- **Build Tool:** Maven
- **Java:** 11

## 📋 Requisitos Previos

- Java 11 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior

## ⚙️ Configuración

### 1. Base de Datos

Crear la base de datos MySQL:

```sql
CREATE DATABASE formamos_acero;
```

### 2. Configuración de Conexión

Editar el archivo `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/formamos_acero
    username: root
    password: tu_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Compilar el Proyecto

```bash
mvn clean install
```

### 4. Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

O ejecutar el JAR generado:

```bash
java -jar target/formamos-acero-sac-1.0-SNAPSHOT.jar
```

## 🌐 Acceso a la Aplicación

Una vez iniciada la aplicación, acceder a:

```
http://localhost:8080
```

## 📁 Estructura del Proyecto

```
src/main/java/com/formamosacero/
├── FormamosAceroSacApplication.java    # Clase principal
├── controller/                          # Controladores MVC
│   ├── HomeController.java
│   ├── ClienteController.java
│   ├── ProveedorController.java
│   ├── PreOrdenController.java
│   ├── OrdenController.java
│   ├── SolicitudEfectivoController.java
│   ├── SolicitudViaticoController.java
│   ├── CotizacionPasajesController.java
│   ├── ComparativoPreciosPasajesController.java
│   └── ComparativoPreciosCompraController.java
├── model/                               # Entidades JPA
│   ├── Cliente.java
│   ├── Proveedor.java
│   ├── PreOrden.java
│   ├── Orden.java
│   ├── SolicitudEfectivo.java
│   ├── SolicitudViatico.java
│   ├── CotizacionPasajes.java
│   ├── ComparativoPreciosPasajes.java
│   └── ComparativoPreciosCompra.java
├── repository/                          # Repositorios JPA
│   └── ...
└── service/                            # Servicios de negocio
    └── ...

src/main/resources/
├── templates/                          # Vistas Thymeleaf
│   ├── index.html
│   ├── cliente/
│   ├── proveedor/
│   ├── preorden/
│   ├── orden/
│   ├── solicitudefectivo/
│   ├── solicitudviatico/
│   ├── cotizacionpasajes/
│   ├── comparativopreciopasajes/
│   └── comparativopreciocompra/
├── application.yml
└── application.properties
```

## 🎯 Endpoints Principales

Cada módulo tiene los siguientes endpoints:

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/{modulo}` | Listar todos los registros |
| GET | `/{modulo}/new` | Formulario para crear nuevo |
| POST | `/{modulo}` | Guardar nuevo registro |
| GET | `/{modulo}/{id}` | Ver detalle del registro |
| GET | `/{modulo}/{id}/edit` | Formulario para editar |
| POST | `/{modulo}/{id}` | Actualizar registro |
| DELETE | `/{modulo}/{id}` | Eliminar registro |
| GET | `/{modulo}/search` | Búsqueda con filtros |

Donde `{modulo}` puede ser: `cliente`, `proveedor`, `preorden`, `orden`, `solicitud-efectivo`, `solicitud-viatico`, `cotizacion-pasajes`, `comparativo-precios-pasajes`, `comparativo-precios-compra`.

## 📝 Licencia

Este proyecto es propiedad de FORMAMOS ACERO SAC.

## 👥 Autor

Sistema desarrollado para FORMAMOS ACERO SAC

## 📞 Soporte

Para soporte técnico, contactar al equipo de desarrollo de FORMAMOS ACERO SAC.
