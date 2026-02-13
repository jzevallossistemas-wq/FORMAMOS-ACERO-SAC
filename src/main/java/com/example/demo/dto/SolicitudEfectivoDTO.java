package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudEfectivoDTO {
    private Long id;

    @NotBlank(message = "El número es obligatorio")
    private String numero;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotBlank(message = "El solicitante es obligatorio")
    private String solicitante;

    @NotNull(message = "El monto es obligatorio")
    private Double monto;

    private String motivo;
    private String estado;
}
