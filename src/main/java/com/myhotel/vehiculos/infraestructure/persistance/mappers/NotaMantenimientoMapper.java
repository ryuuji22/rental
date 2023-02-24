package com.myhotel.vehiculos.infraestructure.persistance.mappers;

import com.myhotel.vehiculos.domain.entities.NotaMantenimiento;
import com.myhotel.vehiculos.infraestructure.models.NotaMantenimientoModel;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotaMantenimientoMapper {

    @Mapping(source = "vehiculo.id",target = "vehiculoId")
    NotaMantenimiento toNotaMantenimiento(NotaMantenimientoModel mantenimientoModel);

    List<NotaMantenimiento> toNotaMantenimientos(List<NotaMantenimientoModel> mantenimientoModels);

    @InheritInverseConfiguration
    NotaMantenimientoModel toNotaMantenimientoModel(NotaMantenimiento notaMantenimiento);
}
