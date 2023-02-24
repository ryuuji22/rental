package com.myhotel.vehiculos.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Camion extends Vehiculo {

    private String tipo;
    private Double capacidadToneladas;
    private Integer ejes;

}
