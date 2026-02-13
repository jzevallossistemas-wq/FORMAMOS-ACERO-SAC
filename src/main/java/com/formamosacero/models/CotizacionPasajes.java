package com.formamosacero.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cotizacion_pasajes")
public class CotizacionPasajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "solicitante")
    private String solicitante;

    @Column(name = "destino")
    private String destino;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "itinerario", columnDefinition = "TEXT")
    private String itinerario;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "aerolinea1")
    private String aerolinea1;

    @Column(name = "precio1")
    private BigDecimal precio1;

    @Column(name = "aerolinea2")
    private String aerolinea2;

    @Column(name = "precio2")
    private BigDecimal precio2;

    @Column(name = "aerolinea3")
    private String aerolinea3;

    @Column(name = "precio3")
    private BigDecimal precio3;

    @Column(name = "mejor_opcion")
    private String mejorOpcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Constructors
    public CotizacionPasajes() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAerolinea1() {
        return aerolinea1;
    }

    public void setAerolinea1(String aerolinea1) {
        this.aerolinea1 = aerolinea1;
    }

    public BigDecimal getPrecio1() {
        return precio1;
    }

    public void setPrecio1(BigDecimal precio1) {
        this.precio1 = precio1;
    }

    public String getAerolinea2() {
        return aerolinea2;
    }

    public void setAerolinea2(String aerolinea2) {
        this.aerolinea2 = aerolinea2;
    }

    public BigDecimal getPrecio2() {
        return precio2;
    }

    public void setPrecio2(BigDecimal precio2) {
        this.precio2 = precio2;
    }

    public String getAerolinea3() {
        return aerolinea3;
    }

    public void setAerolinea3(String aerolinea3) {
        this.aerolinea3 = aerolinea3;
    }

    public BigDecimal getPrecio3() {
        return precio3;
    }

    public void setPrecio3(BigDecimal precio3) {
        this.precio3 = precio3;
    }

    public String getMejorOpcion() {
        return mejorOpcion;
    }

    public void setMejorOpcion(String mejorOpcion) {
        this.mejorOpcion = mejorOpcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
