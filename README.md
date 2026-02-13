# FORMAMOS ACERO SAC - Sistema de Gestión Empresarial

Sistema integral de gestión empresarial desarrollado con Spring Boot y Thymeleaf, que incluye 9 módulos completos de CRUD para la gestión de clientes, proveedores, órdenes, solicitudes y comparativos.

## 🚀 Características

### ✅ 9 Módulos Completos Implementados

1. **👥 CLIENTES** (`/cliente`)
   - Gestión completa de clientes
   - Campos: Nombre, Email, Teléfono, Dirección

2. **🏭 PROVEEDORES** (`/proveedor`)
   - Gestión completa de proveedores
   - Campos: Nombre, Email, Teléfono, Dirección

3. **📋 PRE ÓRDENES** (`/preorden`)
   - Pre-órdenes de compra
   - Selección de Cliente y Proveedor
   - Campos: Número, Fecha, Monto Total, Estado, Descripción

4. **📝 ÓRDENES** (`/orden`)
   - Órdenes de compra confirmadas
   - Selección de Proveedor
   - Campos: Número, Fecha, Monto Total, Estado

5. **💵 SOLICITUD EFECTIVO** (`/solicitudefectivo`)
   - Solicitudes de efectivo
   - Selección de Cliente
   - Campos: Número, Monto, Descripción, Fecha Solicitud, Estado

6. **✈️ SOLICITUD VIÁTICO** (`/solicitudviatico`)
   - Solicitudes de viáticos de viaje
   - Campos: Monto, Descripción, Fecha Solicitud, Estado

7. **🎫 COTIZACIÓN PASAJES** (`/cotizacionpasajes`)
   - Cotizaciones de pasajes aéreos
   - Comparación de 3 aerolíneas
   - Campos: Número, Destino, Ruta, Fecha Viaje, Precios de 3 aerolíneas, Mejor Opción

8. **📊 COMPARATIVO PRECIOS PASAJES** (`/comparativopreciopasajes`)
   - Comparativo detallado de precios de pasajes
   - Campos: Número, Destino, Fecha Comparación, Totales de 3 aerolíneas, Mejor Opción, Observaciones

9. **📈 COMPARATIVO PRECIOS COMPRA** (`/comparativopreciocompra`)
   - Comparativo de precios de compra
   - Campos: Número, Producto, Fecha Comparación, Precios de 3 proveedores, Mejor Opción, Observaciones

### 🎯 Funcionalidades por Módulo

Cada módulo incluye:
- ✅ **Listar** - Vista de tabla con paginación (10 registros por página)
- ✅ **Buscar** - Campo de búsqueda funcional
- ✅ **Crear** - Formulario para nuevos registros
- ✅ **Editar** - Formulario para actualizar registros existentes
- ✅ **Eliminar** - Con confirmación JavaScript
- ✅ **Paginación** - Navegación entre páginas
- ✅ **Validaciones** - Campos requeridos marcados con *
- ✅ **Mensajes Flash** - Feedback de éxito/error

## 🛠️ Tecnologías Utilizadas

- **Backend:**
  - Spring Boot 2.6.6
  - Spring Data JPA
  - Hibernate
  - H2 Database (testing)
  - MySQL (production)

- **Frontend:**
  - Thymeleaf
  - Bootstrap 5.3.0
  - HTML5
  - CSS3

- **Herramientas:**
  - Maven
  - Java 11
  - Apache POI (Excel export)
  - iText7 (PDF export)

## 📁 Estructura del Proyecto

```
src/main/
├── java/com/formamosacero/
│   ├── FormamosAceroApplication.java          # Clase principal
│   ├── controller/                            # Controladores REST/MVC
│   │   ├── HomeController.java
│   │   ├── ClienteController.java
│   │   ├── ProveedorController.java
│   │   ├── PreOrdenController.java
│   │   ├── OrdenController.java
│   │   ├── SolicitudEfectivoController.java
│   │   ├── SolicitudViaticoController.java
│   │   ├── CotizacionPasajesController.java
│   │   ├── ComparativoPreciosPasajesController.java
│   │   └── ComparativoPreciosCompraController.java
│   ├── models/                                # Entidades JPA
│   │   ├── Cliente.java
│   │   ├── Proveedor.java
│   │   ├── PreOrden.java
│   │   ├── OrdenCompra.java
│   │   ├── SolicitudEfectivo.java
│   │   ├── SolicitudGastoViaje.java
│   │   ├── CotizacionPasajes.java
│   │   ├── ComparativoPreciosPasajes.java
│   │   └── ComparativoPreciosCompra.java
│   ├── repositories/                          # Repositorios JPA
│   │   └── [Repositorios para cada entidad]
│   └── services/                              # Capa de servicios
│       └── [Servicios para cada entidad]
└── resources/
    ├── application.properties                 # Configuración
    └── templates/                             # Vistas Thymeleaf
        ├── index.html                         # Página principal
        ├── cliente/
        │   ├── lista.html
        │   └── formulario.html
        ├── proveedor/
        ├── preorden/
        ├── orden/
        ├── solicitudefectivo/
        ├── solicitudviatico/
        ├── cotizacionpasajes/
        ├── comparativopreciopasajes/
        └── comparativopreciocompra/
```

## 🚀 Instalación y Ejecución

### Requisitos Previos
- Java 11 o superior
- Maven 3.6+
- MySQL 8.0+ (para producción)

### Pasos de Instalación

1. **Clonar el repositorio:**
```bash
git clone https://github.com/jzevallossistemas-wq/FORMAMOS-ACERO-SAC.git
cd FORMAMOS-ACERO-SAC
```

2. **Compilar el proyecto:**
```bash
mvn clean compile
```

3. **Ejecutar la aplicación:**
```bash
mvn spring-boot:run
```

4. **Acceder a la aplicación:**
```
http://localhost:8080
```

### Configuración de Base de Datos

#### Para Desarrollo (H2 - Por defecto):
La aplicación está configurada para usar H2 en memoria. No requiere configuración adicional.

#### Para Producción (MySQL):
Editar `src/main/resources/application.properties`:
```properties
# Comentar/eliminar configuración H2
# Descomentar y configurar MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/formamos_acero
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## 🎨 Diseño de Interfaz

- **Colores principales:**
  - Púrpura: #667eea
  - Naranja: #ff8c00

- **Características de UI:**
  - Diseño responsive con Bootstrap 5
  - Gradientes modernos
  - Navegación intuitiva con navbar completo
  - Iconos emoji para mejor UX
  - Tablas con efecto hover
  - Formularios limpios con validación
  - Mensajes flash de éxito/error

## 📊 Rutas Disponibles

| Ruta | Descripción |
|------|-------------|
| `/` | Página principal con tarjetas de módulos |
| `/cliente` | Listado de clientes |
| `/cliente/nuevo` | Crear nuevo cliente |
| `/cliente/{id}/editar` | Editar cliente |
| `/cliente/{id}/eliminar` | Eliminar cliente |
| `/proveedor` | Listado de proveedores |
| `/preorden` | Listado de pre-órdenes |
| `/orden` | Listado de órdenes |
| `/solicitudefectivo` | Listado de solicitudes de efectivo |
| `/solicitudviatico` | Listado de solicitudes de viático |
| `/cotizacionpasajes` | Listado de cotizaciones de pasajes |
| `/comparativopreciopasajes` | Listado de comparativos de pasajes |
| `/comparativopreciocompra` | Listado de comparativos de compra |

*Cada módulo sigue el mismo patrón de rutas CRUD*

## 📝 Funcionalidades Futuras

- [ ] Exportación a Excel
- [ ] Exportación a PDF
- [ ] Búsqueda avanzada con filtros
- [ ] Autenticación y autorización de usuarios
- [ ] Dashboard con estadísticas
- [ ] Reportes personalizados
- [ ] API REST completa
- [ ] Integración con servicios externos

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:
1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es propiedad de Formamos Acero SAC.

## 👥 Autores

- **Formamos Acero SAC** - *Desarrollo inicial*

## 📞 Contacto

Para más información, contacte a través del repositorio de GitHub.

---

**© 2024 Formamos Acero SAC - Todos los derechos reservados**
