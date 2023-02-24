package com.myhotel.vehiculos.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.myhotel.vehiculos.domain.entities.Vehiculo;
import com.myhotel.vehiculos.infraestructure.models.VehiculoModel;

@Mapper(componentModel = "spring", uses = { NotaMantenimientoMapper.class })
public interface VehiculoMapper {

	Vehiculo toVehiculo(VehiculoModel vehiculoModel);

	List<Vehiculo> toVehiculos(List<VehiculoModel> vehiculoModels);

	@InheritInverseConfiguration
	VehiculoModel toVehiculoModel(Vehiculo vehiculo);
}
