/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.vehiculos.domain.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    private String id;
    private String marca;
    private String modelo;
    private String patente;
    private Integer anio;
    private Double kilometraje;
    private Double cilindrada;
    private List<NotaMantenimiento> notasMantenimiento;

}
