package com.formamosacero.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "comparativo_precios_pasajes")
public class ComparativoPreciosPasajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "fecha_comparacion")
    private LocalDate fechaComparacion;

    @Column(name = "aerolinea1")
    private String aerolinea1;

    @Column(name = "total1")
    private BigDecimal total1;

    @Column(name = "aerolinea2")
    private String aerolinea2;

    @Column(name = "total2")
    private BigDecimal total2;

    @Column(name = "aerolinea3")
    private String aerolinea3;

    @Column(name = "total3")
    private BigDecimal total3;

    @Column(name = "mejor_opcion")
    private String mejorOpcion;

    @Column(name = "observaciones")
    private String observaciones;

    public ComparativoPreciosPasajes() {}

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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaComparacion() {
        return fechaComparacion;
    }

    public void setFechaComparacion(LocalDate fechaComparacion) {
        this.fechaComparacion = fechaComparacion;
    }

    public String getAerolinea1() {
        return aerolinea1;
    }

    public void setAerolinea1(String aerolinea1) {
        this.aerolinea1 = aerolinea1;
    }

    public BigDecimal getTotal1() {
        return total1;
    }

    public void setTotal1(BigDecimal total1) {
        this.total1 = total1;
    }

    public String getAerolinea2() {
        return aerolinea2;
    }

    public void setAerolinea2(String aerolinea2) {
        this.aerolinea2 = aerolinea2;
    }

    public BigDecimal getTotal2() {
        return total2;
    }

    public void setTotal2(BigDecimal total2) {
        this.total2 = total2;
    }

    public String getAerolinea3() {
        return aerolinea3;
    }

    public void setAerolinea3(String aerolinea3) {
        this.aerolinea3 = aerolinea3;
    }

    public BigDecimal getTotal3() {
        return total3;
    }

    public void setTotal3(BigDecimal total3) {
        this.total3 = total3;
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
