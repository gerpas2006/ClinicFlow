package com.salesianostriana.dam.ClinicFlow.Dto;

import com.salesianostriana.dam.ClinicFlow.Model.Cita;

import java.time.LocalDate;

public record CreateConsultaRequest(
        String observaciones,
        String diagnostico,
        LocalDate fecha,
        Cita cita
) {
}
