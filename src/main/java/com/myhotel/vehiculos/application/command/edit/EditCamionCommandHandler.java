package com.myhotel.vehiculos.application.command.edit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.entities.Camion;
import com.myhotel.vehiculos.domain.exceptions.ApplicationDomainException;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.CommandHandler;
import lombok.SneakyThrows;

@Component
public class EditCamionCommandHandler implements CommandHandler<EditCamionCommand> {

    @Autowired
    private IBaseVehiculoRepository baseVehiculoRepository;

    @Override
    @SneakyThrows
    @Transactional
    public void handle(EditCamionCommand command) {

        var camionDB = this.validateCamion(command.getId());
        camionDB.setMarca(command.getMarca());
        camionDB.setModelo(command.getModelo());
        camionDB.setPatente(command.getPatente());
        camionDB.setAnio(command.getAnio());
        camionDB.setKilometraje(command.getKilometraje());
        camionDB.setCilindrada(command.getCilindrada());
        camionDB.setTipo(command.getTipo());
        camionDB.setCapacidadToneladas(command.getCapacidadToneladas());
        camionDB.setEjes(command.getEjes());

        baseVehiculoRepository.update(camionDB);

    }
    
    private Camion validateCamion(String id) {

        return baseVehiculoRepository.findCamionById(id)
                .orElseThrow(() -> new ApplicationDomainException("Camión no encontrado"));
    }

}
