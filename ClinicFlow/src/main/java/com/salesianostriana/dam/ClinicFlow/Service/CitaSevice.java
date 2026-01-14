package com.salesianostriana.dam.ClinicFlow.Service;

import com.salesianostriana.dam.ClinicFlow.Model.Cita;
import com.salesianostriana.dam.ClinicFlow.Model.Estado;
import com.salesianostriana.dam.ClinicFlow.Model.Paciente;
import com.salesianostriana.dam.ClinicFlow.Model.Profesional;
import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.PacienteRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.ProfesionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaSevice {

    private final CitaRepository citaRepository;
    private final ProfesionalRepository profesionalRepository;
    private final PacienteRepository pacienteRepository;


    public Cita cancelarCita(Long id){
        Cita citaBuscada = citaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado la cita"));
        if (citaBuscada.getEstado() == Estado.PROGRAMADA){
            citaBuscada.setEstado(Estado.CANCELADA);
        }else{
            throw new RuntimeException("No se puede cancelar la cita");
        }
        return citaBuscada;
    }

    public Cita crearCita(Cita cita,Long id){
        Profesional profesional = profesionalRepository.findById(id).orElseThrow( ()-> new RuntimeException("No se ha encontrado el profesional"));
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado al paciente"));

        profesional.getCitas().forEach( c -> {
            if(c.getFechaHora().isEqual(cita.getFechaHora())){
                throw new RuntimeException("No puedes tener dos fechas con la misma hora y dia");
            }
        });

        if (cita.getFechaHora().isAfter(LocalDateTime.now())){
            throw new RuntimeException("No pueden citas que tenga una fecha pasada");
        }

        return citaRepository.save(cita);
    }
}
