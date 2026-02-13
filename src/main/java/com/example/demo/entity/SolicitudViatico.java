package com.example.demo.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "solicitud_viatico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudViatico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private String numero;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "solicitante")
    private String solicitante;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "estado")
    private String estado;
}
