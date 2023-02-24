package com.myhotel.vehiculos.infraestructure.persistance.mappers;

import com.myhotel.vehiculos.domain.entities.Automovil;
import com.myhotel.vehiculos.infraestructure.models.AutomovilModel;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutomovilMapper {


    Automovil toAutomovil(AutomovilModel automovilModel);

    List<Automovil> toAutomovils(List<AutomovilModel> automovilModels);

    @InheritInverseConfiguration
    AutomovilModel toAutomovilModel(Automovil automovil);
}
