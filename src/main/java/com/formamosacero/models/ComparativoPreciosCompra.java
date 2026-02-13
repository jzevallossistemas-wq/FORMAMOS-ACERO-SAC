package com.formamosacero.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "comparativo_precios_compra")
public class ComparativoPreciosCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "producto", nullable = false)
    private String producto;

    @Column(name = "fecha_comparacion")
    private LocalDate fechaComparacion;

    @Column(name = "proveedor1")
    private String proveedor1;

    @Column(name = "precio1")
    private BigDecimal precio1;

    @Column(name = "proveedor2")
    private String proveedor2;

    @Column(name = "precio2")
    private BigDecimal precio2;

    @Column(name = "proveedor3")
    private String proveedor3;

    @Column(name = "precio3")
    private BigDecimal precio3;

    @Column(name = "mejor_opcion")
    private String mejorOpcion;

    @Column(name = "observaciones")
    private String observaciones;

    public ComparativoPreciosCompra() {}

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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public LocalDate getFechaComparacion() {
        return fechaComparacion;
    }

    public void setFechaComparacion(LocalDate fechaComparacion) {
        this.fechaComparacion = fechaComparacion;
    }

    public String getProveedor1() {
        return proveedor1;
    }

    public void setProveedor1(String proveedor1) {
        this.proveedor1 = proveedor1;
    }

    public BigDecimal getPrecio1() {
        return precio1;
    }

    public void setPrecio1(BigDecimal precio1) {
        this.precio1 = precio1;
    }

    public String getProveedor2() {
        return proveedor2;
    }

    public void setProveedor2(String proveedor2) {
        this.proveedor2 = proveedor2;
    }

    public BigDecimal getPrecio2() {
        return precio2;
    }

    public void setPrecio2(BigDecimal precio2) {
        this.precio2 = precio2;
    }

    public String getProveedor3() {
        return proveedor3;
    }

    public void setProveedor3(String proveedor3) {
        this.proveedor3 = proveedor3;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
