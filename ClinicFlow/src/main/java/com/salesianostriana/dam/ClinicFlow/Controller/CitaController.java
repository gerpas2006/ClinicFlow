package com.salesianostriana.dam.ClinicFlow.Controller;

import com.salesianostriana.dam.ClinicFlow.Dto.CitaDetailDto;
import com.salesianostriana.dam.ClinicFlow.Service.CitaSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CitaController {

    private final CitaSevice citaSevice;

    @PutMapping("/citas/{id}/cancelar")
    public CitaDetailDto cancelarCita(Long id){
         return citaSevice.cancelarCita(id).
    }

}
