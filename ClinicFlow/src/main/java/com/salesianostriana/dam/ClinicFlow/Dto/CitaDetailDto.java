package com.salesianostriana.dam.ClinicFlow.Dto;

import com.salesianostriana.dam.ClinicFlow.Model.Cita;
import com.salesianostriana.dam.ClinicFlow.Model.Estado;


import java.time.LocalDateTime;

public record CitaDetailDto(
        Long id,
        LocalDateTime fechaHora,
        Estado estado,
        CitaDetailDto.PacienteSimple paciente,
        CitaDetailDto.ProfesionalSimple profesional,
        CitaDetailDto.ConsultaSimple consulta
) {
    public record PacienteSimple(
            Long id,
            String nombre,
            String email
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

//    public static CitaDetailDto of(Cita cita){
//        return new CitaDetailDto(cita.getId(),
//                cita.getFechaHora(),
//                cita.getEstado(),
//                new CitaDetailDto.PacienteSimple()
//                cita.getProfesional(),
//                cita.getConsulta());
//    }
}
