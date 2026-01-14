package com.salesianostriana.dam.ClinicFlow.Dto;

import com.salesianostriana.dam.ClinicFlow.Model.Estado;
import com.salesianostriana.dam.ClinicFlow.Model.Paciente;

import java.time.LocalDateTime;

public record CitaListDto(
        Long id,
        LocalDateTime fechaHora,
        Estado estado,
        Paciente paciente,
        ProfesionalSimple profesional,
        ConsultaSimple consulta

) {
    public record PacienteSimple(
            Long id,
            String nombre
    ){}
    public record ProfesionalSimple(
            Long id,
            String nombre,
            String especialidad
    ){}

    public record ConsultaSimple(
            Long id,
            String observaciones,
            String diagnostico
    ){}
}
