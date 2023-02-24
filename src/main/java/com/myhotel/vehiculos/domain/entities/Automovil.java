package com.myhotel.vehiculos.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automovil extends Vehiculo {

    private String tipo;
    private Integer puertas;
    private Integer pasajeros;
    private Double capacidadMaletero;

}
