package com.salesianostriana.dam.ClinicFlow.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Paciente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private LocalDate fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
    private List<Cita> citas = new ArrayList<>();

    public void addCita(Cita cita) {
        this.citas.add(cita);
        cita.setPaciente(this);
    }

    public void removeCita(Cita cita) {
        this.citas.remove(cita);
        cita.setPaciente(null);
    }
}
