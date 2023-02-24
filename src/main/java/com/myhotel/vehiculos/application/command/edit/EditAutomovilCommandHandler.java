package com.myhotel.vehiculos.application.command.edit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.entities.Automovil;
import com.myhotel.vehiculos.domain.exceptions.ApplicationDomainException;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.CommandHandler;
import lombok.SneakyThrows;

@Component
public class EditAutomovilCommandHandler implements CommandHandler<EditAutomovilCommand> {

    @Autowired
    private IBaseVehiculoRepository baseVehiculoRepository;

    @Override
    @SneakyThrows
    @Transactional
    public void handle(EditAutomovilCommand command) {

        var automovilDB = this.validateAutomovil(command.getId());
        automovilDB.setMarca(command.getMarca());
        automovilDB.setModelo(command.getModelo());
        automovilDB.setPatente(command.getPatente());
        automovilDB.setAnio(command.getAnio());
        automovilDB.setKilometraje(command.getKilometraje());
        automovilDB.setCilindrada(command.getCilindrada());
        automovilDB.setTipo(command.getTipo());
        automovilDB.setPuertas(command.getPuertas());
        automovilDB.setPasajeros(command.getPasajeros());
        automovilDB.setCapacidadMaletero(command.getCapacidadMaletero());

        baseVehiculoRepository.update(automovilDB);

    }
    
    private Automovil validateAutomovil(String id) {

        return baseVehiculoRepository.findAutomovilById(id)
                .orElseThrow(() -> new ApplicationDomainException("Automovil no encontrado"));
    }

}
