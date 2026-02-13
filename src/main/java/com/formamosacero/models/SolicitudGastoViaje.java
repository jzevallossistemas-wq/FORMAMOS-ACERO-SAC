package com.formamosacero.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "solicitud_gasto_viaje")
public class SolicitudGastoViaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "estado")
    private String estado;

    // Constructors
    public SolicitudGastoViaje() {}

    public SolicitudGastoViaje(BigDecimal monto, String descripcion, LocalDate fechaSolicitud, String estado) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}