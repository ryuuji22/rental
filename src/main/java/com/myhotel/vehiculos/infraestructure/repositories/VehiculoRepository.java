/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.vehiculos.infraestructure.repositories;

import com.myhotel.vehiculos.domain.entities.Automovil;
import com.myhotel.vehiculos.domain.entities.Camion;
import com.myhotel.vehiculos.domain.entities.Vehiculo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;
import com.myhotel.vehiculos.infraestructure.models.AutomovilModel;
import com.myhotel.vehiculos.infraestructure.models.CamionModel;
import com.myhotel.vehiculos.infraestructure.models.VehiculoModel;
import com.myhotel.vehiculos.infraestructure.persistance.mappers.AutomovilMapper;
import com.myhotel.vehiculos.infraestructure.persistance.mappers.CamionMapper;
import com.myhotel.vehiculos.infraestructure.persistance.mappers.VehiculoMapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author diego
 */
@Repository
public class VehiculoRepository implements IBaseVehiculoRepository {

    @Autowired
    private VehiculoRepositoryFactory repositoryFactory;

    @Autowired
    private VehiculoMapper vehiculoMapper;

    @Autowired
    private AutomovilMapper automovilMapper;

    @Autowired
    private CamionMapper camionMapper;

    @Override
    public void create(Vehiculo vehiculo) {
        if (vehiculo instanceof Automovil && vehiculo.getClass() != Vehiculo.class) {
            var automovilModel = automovilMapper.toAutomovilModel((Automovil) vehiculo);
            var automovilRepository = repositoryFactory.getRepository(Automovil.class.getSimpleName()).get();
            automovilRepository.save(automovilModel);
        } else if (vehiculo instanceof Camion && vehiculo.getClass() != Vehiculo.class) {
            var camionModel = camionMapper.toCamionModel((Camion) vehiculo);
            var camionRepository = repositoryFactory.getRepository(Camion.class.getSimpleName()).get();
            camionRepository.save(camionModel);
        }

    }

    @Override
    public void delete(String id) {
        var vehiculoRepository = repositoryFactory.getRepository(Vehiculo.class.getSimpleName()).get();
        vehiculoRepository.deleteById(id);
    }

    @Override
    public void update(Vehiculo vehiculo) {
        this.create(vehiculo);
    }

    @Override
    public Optional<Map<String, Object>> findAll() {

        var automovilRepository = repositoryFactory.getRepository(Automovil.class.getSimpleName()).get();
        var camionRepository = repositoryFactory.getRepository(Camion.class.getSimpleName()).get();
        List<Automovil> automoviles = automovilMapper.toAutomovils(automovilRepository.findAll());
        List<Camion> camiones = camionMapper.toCamions(camionRepository.findAll());
        var result = new HashMap<String, Object>();
        result.put(Automovil.class.getSimpleName(), automoviles);
        result.put(Camion.class.getSimpleName(), camiones);
        return Optional.of(result);
    }

    @Override
    public Optional<Vehiculo> findById(String id) {
        var vehiculoRepository = repositoryFactory.getRepository(Vehiculo.class.getSimpleName()).get();
        return vehiculoRepository.findById(id)
                .map(x -> vehiculoMapper.toVehiculo((VehiculoModel) x));
    }

    @Override
    public Optional<Automovil> findAutomovilById(String id) {
        var automovilRepository = repositoryFactory.getRepository(Automovil.class.getSimpleName()).get();
        return automovilRepository.findById(id)
                .map(x -> automovilMapper.toAutomovil((AutomovilModel) x));
    }

    @Override
    public Optional<Camion> findCamionById(String id) {
        var camionRepository = repositoryFactory.getRepository(Camion.class.getSimpleName()).get();
        return camionRepository.findById(id)
                .map(x -> camionMapper.toCamion((CamionModel) x));
    }

}
