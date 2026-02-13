package com.formamosacero.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria_movimiento", indexes = {
    @Index(name = "idx_auditoria_tipo", columnList = "tipo_modulo"),
    @Index(name = "idx_auditoria_numero", columnList = "numero_solicitud"),
    @Index(name = "idx_auditoria_fecha", columnList = "fecha_accion")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_modulo", length = 50)
    private String tipoModulo;

    @Column(name = "numero_solicitud", length = 50)
    private String numeroSolicitud;

    @Column(name = "usuario_creacion", length = 100)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_modificacion", length = 100)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "estado_anterior", length = 20)
    private String estadoAnterior;

    @Column(name = "estado_nuevo", length = 20)
    private String estadoNuevo;

    @Column(name = "observacion", columnDefinition = "TEXT")
    private String observacion;

    @Column(name = "accion", length = 50)
    private String accion;

    @Column(name = "fecha_accion")
    private LocalDateTime fechaAccion;

    @PrePersist
    protected void onCreate() {
        if (fechaAccion == null) {
            fechaAccion = LocalDateTime.now();
        }
    }
}
