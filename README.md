# FORMAMOS ACERO SAC - Sistema de Gestión

Sistema de gestión empresarial desarrollado con Spring Boot para FORMAMOS ACERO SAC.

## Tecnologías Utilizadas

- **Framework**: Spring Boot 2.7.0
- **Java**: 11
- **Base de Datos**: MySQL 8.0+
- **MySQL Connector**: mysql-connector-j 8.2.0 (secure version)
- **ORM**: JPA/Hibernate
- **Mapper**: ModelMapper
- **Validación**: javax.validation
- **Lombok**: Para reducir boilerplate
- **Maven**: Gestor de dependencias

## Estructura del Proyecto

```
src/main/java/com/example/demo/
├── FormamosAceroApplication.java  # Clase principal
├── controller/                    # Controladores REST
├── service/                       # Lógica de negocio
├── repository/                    # Repositorios JPA
├── entity/                        # Entidades JPA
├── dto/                          # Data Transfer Objects
├── exception/                    # Manejo de excepciones
├── validation/                   # Validaciones personalizadas
├── config/                       # Configuraciones
├── util/                         # Utilidades
├── constant/                     # Constantes
└── response/                     # Respuestas API

src/main/resources/
├── application.yml               # Configuración de la aplicación
└── schema.sql                    # Script de base de datos
```

## Módulos Principales

### Entidades
- **Cliente**: Gestión de clientes
- **Proveedor**: Gestión de proveedores
- **Orden**: Órdenes de compra
- **Preorden**: Preórdenes
- **SolicitudEfectivo**: Solicitudes de efectivo
- **SolicitudViatico**: Solicitudes de viáticos
- **CotizacionPasajes**: Cotizaciones de pasajes
- **ComparativoPrecioPasajes**: Comparativo de precios de pasajes
- **ComparativoPrecioCompra**: Comparativo de precios de compra

## Configuración

### Base de Datos

Editar el archivo `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/formamos_acero
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

# Configuración CORS (opcional)
cors:
  allowed-origins: http://localhost:3000,http://localhost:4200,https://your-production-domain.com
```

### Crear la Base de Datos

```sql
CREATE DATABASE formamos_acero;
```

O ejecutar el script completo en `src/main/resources/schema.sql`

## Instalación y Ejecución

### Requisitos Previos
- Java 11 o superior
- Maven 3.6+
- MySQL 8.0+

### Pasos

1. Clonar el repositorio:
```bash
git clone https://github.com/jzevallossistemas-wq/FORMAMOS-ACERO-SAC.git
cd FORMAMOS-ACERO-SAC
```

2. Configurar la base de datos en `application.yml`

3. Compilar el proyecto:
```bash
mvn clean install
```

4. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

O ejecutar el JAR generado:
```bash
java -jar target/formamos-acero-sac-1.0-SNAPSHOT.jar
```

5. La aplicación estará disponible en: `http://localhost:8080`

## API Endpoints

### Clientes
- `GET /api/v1/clientes` - Listar todos los clientes
- `GET /api/v1/clientes/{id}` - Obtener un cliente por ID
- `POST /api/v1/clientes` - Crear un nuevo cliente
- `PUT /api/v1/clientes/{id}` - Actualizar un cliente
- `DELETE /api/v1/clientes/{id}` - Eliminar un cliente

### Proveedores
- `GET /api/v1/proveedores` - Listar todos los proveedores
- `GET /api/v1/proveedores/{id}` - Obtener un proveedor por ID
- `POST /api/v1/proveedores` - Crear un nuevo proveedor
- `PUT /api/v1/proveedores/{id}` - Actualizar un proveedor
- `DELETE /api/v1/proveedores/{id}` - Eliminar un proveedor

### Órdenes
- `GET /api/v1/ordenes` - Listar todas las órdenes
- `GET /api/v1/ordenes/{id}` - Obtener una orden por ID
- `POST /api/v1/ordenes` - Crear una nueva orden
- `PUT /api/v1/ordenes/{id}` - Actualizar una orden
- `DELETE /api/v1/ordenes/{id}` - Eliminar una orden

_Similar para Preórdenes, Solicitudes de Efectivo, Solicitudes de Viáticos, Cotizaciones de Pasajes, etc._

## Validaciones

El sistema incluye validaciones personalizadas:
- **@ValidEmail**: Valida formato de email
- **@ValidPhone**: Valida formato de teléfono
- Validaciones estándar de javax.validation (@NotNull, @NotBlank, etc.)

## Manejo de Excepciones

- **ResourceNotFoundException**: Cuando no se encuentra un recurso
- **DuplicateRecordException**: Cuando se intenta crear un registro duplicado
- **ValidationException**: Para errores de validación
- **GlobalExceptionHandler**: Maneja todas las excepciones globalmente

## Utilidades

- **MapperUtil**: Facilita el mapeo entre entidades y DTOs
- **DateUtil**: Utilidades para manejo de fechas
- **ValidationUtil**: Validaciones adicionales

## Configuración CORS

El sistema está configurado para permitir peticiones desde:
- http://localhost:3000 (por defecto)
- http://localhost:4200 (por defecto)

Para configurar orígenes personalizados en producción, agregar la siguiente propiedad en `application.yml`:

```yaml
cors:
  allowed-origins: https://your-domain.com,https://another-domain.com
```

## Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## Licencia

Este proyecto es propiedad de FORMAMOS ACERO SAC.

## Contacto

FORMAMOS ACERO SAC - [@jzevallossistemas-wq](https://github.com/jzevallossistemas-wq)

Enlace del proyecto: [https://github.com/jzevallossistemas-wq/FORMAMOS-ACERO-SAC](https://github.com/jzevallossistemas-wq/FORMAMOS-ACERO-SAC)
