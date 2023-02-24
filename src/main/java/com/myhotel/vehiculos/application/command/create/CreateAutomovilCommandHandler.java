package com.myhotel.vehiculos.application.command.create;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.entities.Automovil;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.CommandHandler;
import lombok.SneakyThrows;

@Component
public class CreateAutomovilCommandHandler implements CommandHandler<CreateAutomovilCommand> {

    @Autowired
    private IBaseVehiculoRepository baseVehiculoRepository;

    @Override
    @SneakyThrows
    @Transactional
    public void handle(CreateAutomovilCommand command) {

        var newAutomovil = new Automovil();
        newAutomovil.setMarca(command.getMarca());
        newAutomovil.setModelo(command.getModelo());
        newAutomovil.setPatente(command.getPatente());
        newAutomovil.setAnio(command.getAnio());
        newAutomovil.setKilometraje(command.getKilometraje());
        newAutomovil.setCilindrada(command.getCilindrada());
        newAutomovil.setTipo(command.getTipo());
        newAutomovil.setPuertas(command.getPuertas());
        newAutomovil.setPasajeros(command.getPasajeros());
        newAutomovil.setCapacidadMaletero(command.getCapacidadMaletero());

        baseVehiculoRepository.create(newAutomovil);

    }

}
