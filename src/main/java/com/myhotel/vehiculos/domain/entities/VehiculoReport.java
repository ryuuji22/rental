/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myhotel.vehiculos.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculoReport {

    private String id;
    private String marca;
    private String modelo;
    private String patente;
    private Integer anio;
    private Double kilometraje;
    private Double cilindrada;
    private String tipo;
    private Integer puertas;
    private Integer pasajeros;
    private Double capacidadMaletero;
    private Double capacidadToneladas;
    private Integer ejes;
    private List<NotaMantenimiento> notasMantenimiento;

}
