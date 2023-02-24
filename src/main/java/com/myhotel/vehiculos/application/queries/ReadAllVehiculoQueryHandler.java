package com.myhotel.vehiculos.application.queries;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.RequestHandler;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReadAllVehiculoQueryHandler implements RequestHandler<ReadAllVehiculoQuery, Map<String, Object>> {

	@Autowired
	private IBaseVehiculoRepository baseVehiculoRepository;

	@Override
	public Map<String, Object> handle(ReadAllVehiculoQuery query) {
		var vehiculosDB = baseVehiculoRepository.findAll();
		if (!vehiculosDB.isPresent()) {
			return new HashMap<>();
		}
		return vehiculosDB.get();
	}

}
