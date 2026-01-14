package com.salesianostriana.dam.ClinicFlow.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Profesional {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;

    private String especialidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesional")
    private List<Cita> citas = new ArrayList<>();

    public void addCita(Cita cita) {
        this.citas.add(cita);
        cita.setProfesional(this);
    }

    public void removeCita(Cita cita) {
        this.citas.remove(cita);
        cita.setProfesional(null);
    }

}
