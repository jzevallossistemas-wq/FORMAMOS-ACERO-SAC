package com.formamosacero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application class for FORMAMOS ACERO SAC
 * Sistema de Gestión Empresarial
 */
@SpringBootApplication
public class FormamosAceroApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FormamosAceroApplication.class, args);
        System.out.println("===========================================");
        System.out.println("🏭 FORMAMOS ACERO SAC - Sistema iniciado");
        System.out.println("📍 URL: http://localhost:8080");
        System.out.println("===========================================");
    }
}
