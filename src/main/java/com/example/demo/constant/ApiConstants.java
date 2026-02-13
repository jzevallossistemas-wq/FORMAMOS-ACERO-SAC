package com.example.demo.constant;

public class ApiConstants {

    // API versioning
    public static final String API_VERSION = "v1";
    public static final String API_BASE_PATH = "/api/" + API_VERSION;

    // Status constants
    public static final String STATUS_PENDING = "PENDIENTE";
    public static final String STATUS_APPROVED = "APROBADO";
    public static final String STATUS_REJECTED = "RECHAZADO";
    public static final String STATUS_CANCELLED = "CANCELADO";
    public static final String STATUS_COMPLETED = "COMPLETADO";

    // Messages
    public static final String SUCCESS_MESSAGE = "Operación exitosa";
    public static final String CREATE_SUCCESS = "Registro creado exitosamente";
    public static final String UPDATE_SUCCESS = "Registro actualizado exitosamente";
    public static final String DELETE_SUCCESS = "Registro eliminado exitosamente";
    public static final String NOT_FOUND_MESSAGE = "Registro no encontrado";
    public static final String DUPLICATE_MESSAGE = "El registro ya existe";

    // Pagination
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;

    private ApiConstants() {
        // Private constructor to prevent instantiation
    }
}
