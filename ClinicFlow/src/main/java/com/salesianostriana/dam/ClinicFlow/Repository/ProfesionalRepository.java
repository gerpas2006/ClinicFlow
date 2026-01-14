package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.Model.Cita;
import com.salesianostriana.dam.ClinicFlow.Model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional,Long> {

    @Query("""
    SELECT c
    FROM Cita c
    JOIN FETCH c.paciente p
    WHERE c.profesional.id = :profesionalId
      AND c.fechaHora BETWEEN :inicioDia AND :finDia
    ORDER BY c.fechaHora
""")
    List<Cita> findAgendaDiariaProfesional(
            @Param("profesionalId") Long profesionalId,
            @Param("inicioDia") LocalDateTime inicioDia,
            @Param("finDia") LocalDateTime finDia
    );
}
