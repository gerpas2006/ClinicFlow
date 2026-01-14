package com.salesianostriana.dam.ClinicFlow.Service;

import com.salesianostriana.dam.ClinicFlow.Model.Consulta;
import com.salesianostriana.dam.ClinicFlow.Model.Estado;
import com.salesianostriana.dam.ClinicFlow.Repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService{

    private final ConsultaRepository consultaRepository;


    public Consulta registrarConsulta(Long id, Consulta consulta){
        Consulta consultaBuscada = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado la consulta"));
        if (consultaBuscada.getCita().getEstado() != Estado.PROGRAMADA){
            throw new RuntimeException("No se puede registrar la consulta");
        }
        consultaBuscada.getCita().setEstado(Estado.ATENDIDA);
        return consultaRepository.save(consulta);
    }

}
