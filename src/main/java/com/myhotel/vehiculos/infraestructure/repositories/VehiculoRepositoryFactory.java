/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.vehiculos.infraestructure.repositories;

import com.myhotel.vehiculos.domain.entities.Automovil;
import com.myhotel.vehiculos.domain.entities.Camion;
import com.myhotel.vehiculos.domain.entities.Vehiculo;
import com.myhotel.vehiculos.infraestructure.repositories.jpa.IJpaAbstractRepository;
import com.myhotel.vehiculos.infraestructure.repositories.jpa.IJpaAutomovilRepository;
import com.myhotel.vehiculos.infraestructure.repositories.jpa.IJpaCamionRepository;
import com.myhotel.vehiculos.infraestructure.repositories.jpa.IJpaVehiculoRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author diego
 */
@Component
public class VehiculoRepositoryFactory {

    @Autowired
    private IJpaAutomovilRepository automovilRepository;
    @Autowired
    private IJpaCamionRepository camionRepository;
    @Autowired
    private IJpaVehiculoRepository vehiculoRepository;

    private Map<String, IJpaAbstractRepository> validatorsMap;

    public VehiculoRepositoryFactory() {
    }

    @PostConstruct
    public void init() {
        validatorsMap=new HashMap<>();
        validatorsMap.put(Automovil.class.getSimpleName(), automovilRepository);
        validatorsMap.put(Camion.class.getSimpleName(), camionRepository);
        validatorsMap.put(Vehiculo.class.getSimpleName(), vehiculoRepository);
    }

    public Optional<IJpaAbstractRepository> getRepository(String type) {
        return Optional.ofNullable(validatorsMap.get(type));
    }

}
