package com.myhotel.vehiculos.application.command.create;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.entities.Camion;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.CommandHandler;
import lombok.SneakyThrows;

@Component
public class CreateCamionCommandHandler implements CommandHandler<CreateCamionCommand> {

    @Autowired
    private IBaseVehiculoRepository baseVehiculoRepository;

    @Override
    @SneakyThrows
    @Transactional
    public void handle(CreateCamionCommand command) {

        var newCamion = new Camion();
        newCamion.setMarca(command.getMarca());
        newCamion.setModelo(command.getModelo());
        newCamion.setPatente(command.getPatente());
        newCamion.setAnio(command.getAnio());
        newCamion.setKilometraje(command.getKilometraje());
        newCamion.setCilindrada(command.getCilindrada());
        newCamion.setTipo(command.getTipo());
        newCamion.setCapacidadToneladas(command.getCapacidadToneladas());
        newCamion.setEjes(command.getEjes());
       
        baseVehiculoRepository.create(newCamion);

    }

}
