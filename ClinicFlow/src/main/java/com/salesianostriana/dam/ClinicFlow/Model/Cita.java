package com.salesianostriana.dam.ClinicFlow.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Cita {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;

    @OneToOne(fetch = FetchType.LAZY)
    private Consulta consulta;

    public void addConsulta(Consulta consulta) {
        consulta.setCita(this);
        this.consulta = consulta;
    }

    public void removeConsulta() {
        if (this.consulta != null) {
            this.consulta.setCita(null);
            this.consulta = null;
        }
    }


}
