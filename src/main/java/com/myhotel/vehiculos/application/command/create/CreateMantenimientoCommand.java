package com.myhotel.vehiculos.application.command.create;

import io.jkratz.mediator.core.Command;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateMantenimientoCommand implements Command {

    @NotBlank(message = "El campo resumen no puede ser vacío")
    private String resumen;
    @NotNull(message = "El campo fecha no puede ser vacío")
    private LocalDate fecha;
    private String vehiculoID;

}
