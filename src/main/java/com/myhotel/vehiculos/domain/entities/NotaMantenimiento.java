/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.vehiculos.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diego
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaMantenimiento {

    private String id;
    private String resumen;
    private LocalDate fecha;
    @JsonIgnore
    private String vehiculoId;

}
