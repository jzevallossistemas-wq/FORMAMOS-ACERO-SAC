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
public class PreordenDTO {
    private Long id;

    @NotBlank(message = "El número es obligatorio")
    private String numero;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    private Long proveedorId;
    private String descripcion;
    private Double monto;
    private String estado;
}
