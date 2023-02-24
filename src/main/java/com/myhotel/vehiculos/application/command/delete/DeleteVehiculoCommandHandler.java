package com.myhotel.vehiculos.application.command.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myhotel.vehiculos.application.queries.ReadVehiculoByIdQuery;
import com.myhotel.vehiculos.domain.interfaces.repositories.IBaseVehiculoRepository;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;

@Component
public class DeleteVehiculoCommandHandler implements CommandHandler<DeleteVehiculoCommand> {
	@Autowired
	private IBaseVehiculoRepository vehiculoRepository;
	@Autowired
	private Mediator mediator;

	@Override
	@Transactional
	public void handle(DeleteVehiculoCommand deleteVehiculoCommand) {

		var vehiculoQuery = new ReadVehiculoByIdQuery(deleteVehiculoCommand.getId());
		var vehiculoDB = this.mediator.dispatch(vehiculoQuery);

		this.vehiculoRepository.delete(vehiculoDB.getId());

	}

}
