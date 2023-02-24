package com.myhotel.vehiculos.application.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.entities.Vehiculo;
import com.myhotel.vehiculos.domain.exceptions.ApplicationDomainException;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class ReadVehiculoByIdQueryHandler implements RequestHandler<ReadVehiculoByIdQuery, Vehiculo> {

	@Autowired
	private IBaseVehiculoRepository baseVehiculoRepository;

	@Override
	public Vehiculo handle(ReadVehiculoByIdQuery query) {
		var vehiculoDB = baseVehiculoRepository.findById(query.getId());
		if (!vehiculoDB.isPresent()) {
			throw new ApplicationDomainException("El vehículo con id: " + query.getId()+ " no existe.");
		}
		return vehiculoDB.get();
	}

}
