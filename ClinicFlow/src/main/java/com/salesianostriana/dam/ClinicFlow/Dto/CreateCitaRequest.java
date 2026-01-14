package com.salesianostriana.dam.ClinicFlow.Dto;

import com.salesianostriana.dam.ClinicFlow.Model.Paciente;
import com.salesianostriana.dam.ClinicFlow.Model.Profesional;

import java.time.LocalDateTime;

public record CreateCitaRequest(
        LocalDateTime fechaHora,
        Long idPaciente,
        Long idProfesional
) {

}
