package com.myhotel.vehiculos.domain.interfaces.repositories;

import com.myhotel.vehiculos.domain.entities.Automovil;
import com.myhotel.vehiculos.domain.entities.Camion;
import com.myhotel.vehiculos.domain.entities.Vehiculo;
import java.util.Map;
import java.util.Optional;


public interface IBaseVehiculoRepository  {

	void create(Vehiculo vehiculo);

	void delete(String id);

	void update(Vehiculo vehiculo);

	Optional<Map<String,Object>> findAll();
	
        Optional<Vehiculo> findById(String id);
        
        Optional<Automovil> findAutomovilById(String id);
        
        Optional<Camion> findCamionById(String id);
	

}
