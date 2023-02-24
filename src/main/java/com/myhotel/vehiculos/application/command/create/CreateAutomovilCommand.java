package com.myhotel.vehiculos.application.command.create;

import com.myhotel.vehiculos.application.dtos.requests.AutomovilRequest;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAutomovilCommand extends AutomovilRequest implements Command {

}
