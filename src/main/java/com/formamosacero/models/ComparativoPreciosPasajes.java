package com.formamosacero.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comparativo_precios_pasajes")
public class ComparativoPreciosPasajes {

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

    @Column(name = "aerolinea1_nombre")
    private String aerolinea1Nombre;

    @Column(name = "aerolinea1_cantidad")
    private Integer aerolinea1Cantidad;

    @Column(name = "aerolinea1_precio_unitario")
    private BigDecimal aerolinea1PrecioUnitario;

    @Column(name = "aerolinea1_total")
    private BigDecimal aerolinea1Total;

    @Column(name = "aerolinea2_nombre")
    private String aerolinea2Nombre;

    @Column(name = "aerolinea2_cantidad")
    private Integer aerolinea2Cantidad;

    @Column(name = "aerolinea2_precio_unitario")
    private BigDecimal aerolinea2PrecioUnitario;

    @Column(name = "aerolinea2_total")
    private BigDecimal aerolinea2Total;

    @Column(name = "aerolinea3_nombre")
    private String aerolinea3Nombre;

    @Column(name = "aerolinea3_cantidad")
    private Integer aerolinea3Cantidad;

    @Column(name = "aerolinea3_precio_unitario")
    private BigDecimal aerolinea3PrecioUnitario;

    @Column(name = "aerolinea3_total")
    private BigDecimal aerolinea3Total;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Constructors
    public ComparativoPreciosPasajes() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.moneda = "PEN";
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

    public String getAerolinea1Nombre() {
        return aerolinea1Nombre;
    }

    public void setAerolinea1Nombre(String aerolinea1Nombre) {
        this.aerolinea1Nombre = aerolinea1Nombre;
    }

    public Integer getAerolinea1Cantidad() {
        return aerolinea1Cantidad;
    }

    public void setAerolinea1Cantidad(Integer aerolinea1Cantidad) {
        this.aerolinea1Cantidad = aerolinea1Cantidad;
    }

    public BigDecimal getAerolinea1PrecioUnitario() {
        return aerolinea1PrecioUnitario;
    }

    public void setAerolinea1PrecioUnitario(BigDecimal aerolinea1PrecioUnitario) {
        this.aerolinea1PrecioUnitario = aerolinea1PrecioUnitario;
    }

    public BigDecimal getAerolinea1Total() {
        return aerolinea1Total;
    }

    public void setAerolinea1Total(BigDecimal aerolinea1Total) {
        this.aerolinea1Total = aerolinea1Total;
    }

    public String getAerolinea2Nombre() {
        return aerolinea2Nombre;
    }

    public void setAerolinea2Nombre(String aerolinea2Nombre) {
        this.aerolinea2Nombre = aerolinea2Nombre;
    }

    public Integer getAerolinea2Cantidad() {
        return aerolinea2Cantidad;
    }

    public void setAerolinea2Cantidad(Integer aerolinea2Cantidad) {
        this.aerolinea2Cantidad = aerolinea2Cantidad;
    }

    public BigDecimal getAerolinea2PrecioUnitario() {
        return aerolinea2PrecioUnitario;
    }

    public void setAerolinea2PrecioUnitario(BigDecimal aerolinea2PrecioUnitario) {
        this.aerolinea2PrecioUnitario = aerolinea2PrecioUnitario;
    }

    public BigDecimal getAerolinea2Total() {
        return aerolinea2Total;
    }

    public void setAerolinea2Total(BigDecimal aerolinea2Total) {
        this.aerolinea2Total = aerolinea2Total;
    }

    public String getAerolinea3Nombre() {
        return aerolinea3Nombre;
    }

    public void setAerolinea3Nombre(String aerolinea3Nombre) {
        this.aerolinea3Nombre = aerolinea3Nombre;
    }

    public Integer getAerolinea3Cantidad() {
        return aerolinea3Cantidad;
    }

    public void setAerolinea3Cantidad(Integer aerolinea3Cantidad) {
        this.aerolinea3Cantidad = aerolinea3Cantidad;
    }

    public BigDecimal getAerolinea3PrecioUnitario() {
        return aerolinea3PrecioUnitario;
    }

    public void setAerolinea3PrecioUnitario(BigDecimal aerolinea3PrecioUnitario) {
        this.aerolinea3PrecioUnitario = aerolinea3PrecioUnitario;
    }

    public BigDecimal getAerolinea3Total() {
        return aerolinea3Total;
    }

    public void setAerolinea3Total(BigDecimal aerolinea3Total) {
        this.aerolinea3Total = aerolinea3Total;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
