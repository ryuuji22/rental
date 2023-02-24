package com.myhotel.vehiculos.infraestructure.persistance.mappers;

import com.myhotel.vehiculos.domain.entities.Camion;
import com.myhotel.vehiculos.infraestructure.models.CamionModel;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CamionMapper {


    Camion toCamion(CamionModel camionModel);

    List<Camion> toCamions(List<CamionModel> camionModels);

    @InheritInverseConfiguration
    CamionModel toCamionModel(Camion camion);
}
