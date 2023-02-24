package com.myhotel.vehiculos.application.command.create;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.vehiculos.domain.entities.NotaMantenimiento;
import com.myhotel.vehiculos.domain.entities.Vehiculo;
import com.myhotel.vehiculos.domain.exceptions.ApplicationDomainException;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;
import com.myhotel.vehiculos.domain.interfaces.repositories.INotaMantenimientoRepository;

import io.jkratz.mediator.core.CommandHandler;
import java.util.Arrays;
import lombok.SneakyThrows;

@Component
public class CreateMantenimientoCommandHandler implements CommandHandler<CreateMantenimientoCommand> {
    
    @Autowired
    private IBaseVehiculoRepository baseVehiculoRepository;
    
    @Autowired
    private INotaMantenimientoRepository mantenimientoRepository;
    
    @Override
    @SneakyThrows
    @Transactional
    public void handle(CreateMantenimientoCommand command) {
        
        var vehiculo = this.validateVehiculo(command.getVehiculoID());
        
        var newMantenimiento = new NotaMantenimiento();
        newMantenimiento.setResumen(command.getResumen());
        newMantenimiento.setFecha(command.getFecha());
        newMantenimiento.setVehiculoId(vehiculo.getId());
        
        vehiculo.setNotasMantenimiento(Arrays.asList(newMantenimiento));
        
        mantenimientoRepository.create(newMantenimiento);
        
    }
    
    private Vehiculo validateVehiculo(String id) {
        
        return baseVehiculoRepository.findById(id)
                .orElseThrow(() -> new ApplicationDomainException("Vehículo no encontrado"));
    }
    
}
