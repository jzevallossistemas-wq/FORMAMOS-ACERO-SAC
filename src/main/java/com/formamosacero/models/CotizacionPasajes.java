package com.formamosacero.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "cotizacion_pasajes")
public class CotizacionPasajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "fecha_viaje")
    private LocalDate fechaViaje;

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

    public CotizacionPasajes() {}

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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
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
}
