package com.salesianostriana.dam.ClinicFlow.Service;

import com.salesianostriana.dam.ClinicFlow.Model.Cita;
import com.salesianostriana.dam.ClinicFlow.Model.Estado;
import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import org.springframework.stereotype.Service;

@Service
public class CitaSevice {

    private CitaRepository citaRepository;

    public Cita cancelarCita(Long id){
        Cita citaBuscada = citaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado la cita"));
        if (citaBuscada.getEstado() == Estado.PROGRAMADA){
            citaBuscada.setEstado(Estado.CANCELADA);
        }else{
            throw new RuntimeException("No se puede cancelar la cita");
        }
        return citaBuscada;
    }
}
