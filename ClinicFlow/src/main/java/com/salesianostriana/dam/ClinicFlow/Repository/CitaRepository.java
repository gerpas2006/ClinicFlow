package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.Model.Cita;
import com.salesianostriana.dam.ClinicFlow.Model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {


    List<Cita> findByPacienteId(Long pacienteId);
    List<Cita> findByEstado(Estado estado);
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

}
