/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel.vehiculos.infraestructure.repositories.jpa;


import com.myhotel.vehiculos.infraestructure.models.NotaMantenimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diego
 */
public interface IJpaNotaMantenimientoRepository extends JpaRepository<NotaMantenimientoModel, String> {

}
