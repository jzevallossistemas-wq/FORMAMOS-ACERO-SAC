package com.formamosacero.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comparativo_precios_compra")
public class ComparativoPreciosCompra {

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

    @Column(name = "descripcion_producto", columnDefinition = "TEXT")
    private String descripcionProducto;

    @ManyToOne
    @JoinColumn(name = "proveedor1_id")
    private Proveedor proveedor1;

    @Column(name = "proveedor1_cantidad")
    private Integer proveedor1Cantidad;

    @Column(name = "proveedor1_precio_unitario")
    private BigDecimal proveedor1PrecioUnitario;

    @Column(name = "proveedor1_igv")
    private BigDecimal proveedor1IGV;

    @Column(name = "proveedor1_total")
    private BigDecimal proveedor1Total;

    @ManyToOne
    @JoinColumn(name = "proveedor2_id")
    private Proveedor proveedor2;

    @Column(name = "proveedor2_cantidad")
    private Integer proveedor2Cantidad;

    @Column(name = "proveedor2_precio_unitario")
    private BigDecimal proveedor2PrecioUnitario;

    @Column(name = "proveedor2_igv")
    private BigDecimal proveedor2IGV;

    @Column(name = "proveedor2_total")
    private BigDecimal proveedor2Total;

    @ManyToOne
    @JoinColumn(name = "proveedor3_id")
    private Proveedor proveedor3;

    @Column(name = "proveedor3_cantidad")
    private Integer proveedor3Cantidad;

    @Column(name = "proveedor3_precio_unitario")
    private BigDecimal proveedor3PrecioUnitario;

    @Column(name = "proveedor3_igv")
    private BigDecimal proveedor3IGV;

    @Column(name = "proveedor3_total")
    private BigDecimal proveedor3Total;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "lugar_entrega")
    private String lugarEntrega;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Constructors
    public ComparativoPreciosCompra() {
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

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Proveedor getProveedor1() {
        return proveedor1;
    }

    public void setProveedor1(Proveedor proveedor1) {
        this.proveedor1 = proveedor1;
    }

    public Integer getProveedor1Cantidad() {
        return proveedor1Cantidad;
    }

    public void setProveedor1Cantidad(Integer proveedor1Cantidad) {
        this.proveedor1Cantidad = proveedor1Cantidad;
    }

    public BigDecimal getProveedor1PrecioUnitario() {
        return proveedor1PrecioUnitario;
    }

    public void setProveedor1PrecioUnitario(BigDecimal proveedor1PrecioUnitario) {
        this.proveedor1PrecioUnitario = proveedor1PrecioUnitario;
    }

    public BigDecimal getProveedor1IGV() {
        return proveedor1IGV;
    }

    public void setProveedor1IGV(BigDecimal proveedor1IGV) {
        this.proveedor1IGV = proveedor1IGV;
    }

    public BigDecimal getProveedor1Total() {
        return proveedor1Total;
    }

    public void setProveedor1Total(BigDecimal proveedor1Total) {
        this.proveedor1Total = proveedor1Total;
    }

    public Proveedor getProveedor2() {
        return proveedor2;
    }

    public void setProveedor2(Proveedor proveedor2) {
        this.proveedor2 = proveedor2;
    }

    public Integer getProveedor2Cantidad() {
        return proveedor2Cantidad;
    }

    public void setProveedor2Cantidad(Integer proveedor2Cantidad) {
        this.proveedor2Cantidad = proveedor2Cantidad;
    }

    public BigDecimal getProveedor2PrecioUnitario() {
        return proveedor2PrecioUnitario;
    }

    public void setProveedor2PrecioUnitario(BigDecimal proveedor2PrecioUnitario) {
        this.proveedor2PrecioUnitario = proveedor2PrecioUnitario;
    }

    public BigDecimal getProveedor2IGV() {
        return proveedor2IGV;
    }

    public void setProveedor2IGV(BigDecimal proveedor2IGV) {
        this.proveedor2IGV = proveedor2IGV;
    }

    public BigDecimal getProveedor2Total() {
        return proveedor2Total;
    }

    public void setProveedor2Total(BigDecimal proveedor2Total) {
        this.proveedor2Total = proveedor2Total;
    }

    public Proveedor getProveedor3() {
        return proveedor3;
    }

    public void setProveedor3(Proveedor proveedor3) {
        this.proveedor3 = proveedor3;
    }

    public Integer getProveedor3Cantidad() {
        return proveedor3Cantidad;
    }

    public void setProveedor3Cantidad(Integer proveedor3Cantidad) {
        this.proveedor3Cantidad = proveedor3Cantidad;
    }

    public BigDecimal getProveedor3PrecioUnitario() {
        return proveedor3PrecioUnitario;
    }

    public void setProveedor3PrecioUnitario(BigDecimal proveedor3PrecioUnitario) {
        this.proveedor3PrecioUnitario = proveedor3PrecioUnitario;
    }

    public BigDecimal getProveedor3IGV() {
        return proveedor3IGV;
    }

    public void setProveedor3IGV(BigDecimal proveedor3IGV) {
        this.proveedor3IGV = proveedor3IGV;
    }

    public BigDecimal getProveedor3Total() {
        return proveedor3Total;
    }

    public void setProveedor3Total(BigDecimal proveedor3Total) {
        this.proveedor3Total = proveedor3Total;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
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
