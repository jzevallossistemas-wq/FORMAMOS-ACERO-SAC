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
@Table(name = "comparativo_precios_compra", indexes = {
    @Index(name = "idx_comp_compra_numero", columnList = "numero"),
    @Index(name = "idx_comp_compra_fecha", columnList = "fecha"),
    @Index(name = "idx_comp_compra_estado", columnList = "estado")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComparativoPreciosCompra {

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

    @Column(name = "descripcion_producto", columnDefinition = "TEXT")
    private String descripcionProducto;

    // Proveedor 1
    @Column(name = "proveedor1", length = 200)
    private String proveedor1;

    @Column(name = "forma_pago1", length = 50)
    private String formaPago1;

    @Column(name = "lugar_entrega1", length = 255)
    private String lugarEntrega1;

    @Column(name = "moneda1", length = 10)
    private String moneda1 = "PEN";

    @Column(name = "incluye_igv1")
    private Boolean incluyeIgv1 = true;

    @Column(name = "cantidad1")
    private Integer cantidad1;

    @Column(name = "precio_unitario1", precision = 10, scale = 2)
    private BigDecimal precioUnitario1;

    @Column(name = "igv1", precision = 10, scale = 2)
    private BigDecimal igv1;

    @Column(name = "total1", precision = 10, scale = 2)
    private BigDecimal total1;

    // Proveedor 2
    @Column(name = "proveedor2", length = 200)
    private String proveedor2;

    @Column(name = "forma_pago2", length = 50)
    private String formaPago2;

    @Column(name = "lugar_entrega2", length = 255)
    private String lugarEntrega2;

    @Column(name = "moneda2", length = 10)
    private String moneda2 = "PEN";

    @Column(name = "incluye_igv2")
    private Boolean incluyeIgv2 = true;

    @Column(name = "cantidad2")
    private Integer cantidad2;

    @Column(name = "precio_unitario2", precision = 10, scale = 2)
    private BigDecimal precioUnitario2;

    @Column(name = "igv2", precision = 10, scale = 2)
    private BigDecimal igv2;

    @Column(name = "total2", precision = 10, scale = 2)
    private BigDecimal total2;

    // Proveedor 3
    @Column(name = "proveedor3", length = 200)
    private String proveedor3;

    @Column(name = "forma_pago3", length = 50)
    private String formaPago3;

    @Column(name = "lugar_entrega3", length = 255)
    private String lugarEntrega3;

    @Column(name = "moneda3", length = 10)
    private String moneda3 = "PEN";

    @Column(name = "incluye_igv3")
    private Boolean incluyeIgv3 = true;

    @Column(name = "cantidad3")
    private Integer cantidad3;

    @Column(name = "precio_unitario3", precision = 10, scale = 2)
    private BigDecimal precioUnitario3;

    @Column(name = "igv3", precision = 10, scale = 2)
    private BigDecimal igv3;

    @Column(name = "total3", precision = 10, scale = 2)
    private BigDecimal total3;

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
