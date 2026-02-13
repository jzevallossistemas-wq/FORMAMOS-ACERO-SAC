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
@Table(name = "solicitud_viatico", indexes = {
    @Index(name = "idx_sol_viatico_numero", columnList = "numero"),
    @Index(name = "idx_sol_viatico_fecha", columnList = "fecha"),
    @Index(name = "idx_sol_viatico_estado", columnList = "estado")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudViatico {

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

    @Column(name = "area", length = 100)
    private String area;

    @Column(name = "destino", length = 255)
    private String destino;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "ruta", length = 500)
    private String ruta;

    @Column(name = "tipo_transporte", length = 50)
    private String tipoTransporte;

    @Column(name = "combustible", precision = 10, scale = 2)
    private BigDecimal combustible = BigDecimal.ZERO;

    @Column(name = "alimentacion", precision = 10, scale = 2)
    private BigDecimal alimentacion = BigDecimal.ZERO;

    @Column(name = "hospedaje", precision = 10, scale = 2)
    private BigDecimal hospedaje = BigDecimal.ZERO;

    @Column(name = "otros", precision = 10, scale = 2)
    private BigDecimal otros = BigDecimal.ZERO;

    @Column(name = "total_solicitado", precision = 10, scale = 2)
    private BigDecimal totalSolicitado;

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
        calculateTotal();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaModificacion = LocalDateTime.now();
        calculateTotal();
    }

    private void calculateTotal() {
        totalSolicitado = combustible.add(alimentacion).add(hospedaje).add(otros);
    }
}
