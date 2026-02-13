package com.formamosacero.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cotizacion_pasajes", indexes = {
    @Index(name = "idx_cot_pasajes_numero", columnList = "numero"),
    @Index(name = "idx_cot_pasajes_fecha", columnList = "fecha"),
    @Index(name = "idx_cot_pasajes_estado", columnList = "estado")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionPasajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número es obligatorio")
    @Column(name = "numero", nullable = false, unique = true, length = 50)
    private String numero;

    @NotNull(message = "La fecha es obligatoria")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "solicitante", length = 100)
    private String solicitante;

    @Column(name = "destino", length = 255)
    private String destino;

    @Column(name = "ruta", length = 500)
    private String ruta;

    @Column(name = "itinerario", columnDefinition = "TEXT")
    private String itinerario;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "fecha_retorno")
    private LocalDate fechaRetorno;

    @Column(name = "aerolinea1", length = 100)
    private String aerolinea1;

    @Column(name = "precio_aerolinea1", precision = 10, scale = 2)
    private BigDecimal precioAerolinea1;

    @Column(name = "aerolinea2", length = 100)
    private String aerolinea2;

    @Column(name = "precio_aerolinea2", precision = 10, scale = 2)
    private BigDecimal precioAerolinea2;

    @Column(name = "aerolinea3", length = 100)
    private String aerolinea3;

    @Column(name = "precio_aerolinea3", precision = 10, scale = 2)
    private BigDecimal precioAerolinea3;

    @Column(name = "mejor_opcion", length = 100)
    private String mejorOpcion;

    @Column(name = "moneda", length = 10)
    private String moneda = "PEN";

    @Column(name = "estado", length = 20)
    private String estado = "PENDIENTE";

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuario_creacion", length = 100)
    private String usuarioCreacion;

    @Column(name = "usuario_modificacion", length = 100)
    private String usuarioModificacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaModificacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaModificacion = LocalDateTime.now();
    }
}
