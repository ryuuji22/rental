package com.myhotel.vehiculos.application.command.delete;


import javax.validation.constraints.NotBlank;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DeleteVehiculoCommand implements Command {

	@NotBlank(message = "El campo id no puede ser vacio")
	private String id;

}

