/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.vehiculos.infraestructure.repositories;

import com.myhotel.vehiculos.domain.entities.NotaMantenimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhotel.vehiculos.domain.interfaces.repositories.INotaMantenimientoRepository;
import com.myhotel.vehiculos.infraestructure.persistance.mappers.NotaMantenimientoMapper;
import com.myhotel.vehiculos.infraestructure.repositories.jpa.IJpaNotaMantenimientoRepository;

/**
 *
 * @author diego
 */
@Repository
public class NotaMantenimientoRepository implements INotaMantenimientoRepository {

    @Autowired
    private IJpaNotaMantenimientoRepository mantenimientoRepository;

    @Autowired
    private NotaMantenimientoMapper mantenimientoMapper;

    @Override
    public void create(NotaMantenimiento mantenimiento) {
        var model = mantenimientoMapper.toNotaMantenimientoModel(mantenimiento);
        mantenimientoRepository.save(model);
    }

}
