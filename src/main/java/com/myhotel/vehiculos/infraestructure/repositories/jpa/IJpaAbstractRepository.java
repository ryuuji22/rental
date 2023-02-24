/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.myhotel.vehiculos.infraestructure.repositories.jpa;

import com.myhotel.vehiculos.infraestructure.models.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author diego
 * @param <T>
 */
@NoRepositoryBean
public interface IJpaAbstractRepository<T extends VehiculoModel> extends JpaRepository<T, String> {

}
