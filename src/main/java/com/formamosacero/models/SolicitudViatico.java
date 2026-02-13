package com.formamosacero.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud_viatico")
public class SolicitudViatico {

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

    @Column(name = "area")
    private String area;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "ruta", columnDefinition = "TEXT")
    private String ruta;

    @Column(name = "tipo_transporte")
    private String tipoTransporte;

    @Column(name = "combustible")
    private BigDecimal combustible;

    @Column(name = "alimentacion")
    private BigDecimal alimentacion;

    @Column(name = "hospedaje")
    private BigDecimal hospedaje;

    @Column(name = "otros")
    private BigDecimal otros;

    @Column(name = "total_solicitado")
    private BigDecimal totalSolicitado;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Constructors
    public SolicitudViatico() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
        this.combustible = BigDecimal.ZERO;
        this.alimentacion = BigDecimal.ZERO;
        this.hospedaje = BigDecimal.ZERO;
        this.otros = BigDecimal.ZERO;
        this.totalSolicitado = BigDecimal.ZERO;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public BigDecimal getCombustible() {
        return combustible;
    }

    public void setCombustible(BigDecimal combustible) {
        this.combustible = combustible;
    }

    public BigDecimal getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(BigDecimal alimentacion) {
        this.alimentacion = alimentacion;
    }

    public BigDecimal getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(BigDecimal hospedaje) {
        this.hospedaje = hospedaje;
    }

    public BigDecimal getOtros() {
        return otros;
    }

    public void setOtros(BigDecimal otros) {
        this.otros = otros;
    }

    public BigDecimal getTotalSolicitado() {
        return totalSolicitado;
    }

    public void setTotalSolicitado(BigDecimal totalSolicitado) {
        this.totalSolicitado = totalSolicitado;
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
