package com.myhotel.vehiculos.application.queries;

import com.myhotel.vehiculos.domain.entities.Vehiculo;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ReadVehiculoByIdQuery implements Request<Vehiculo> {

	private String id;

}
