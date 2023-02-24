package com.myhotel.vehiculos.application.command.edit;

import com.myhotel.vehiculos.application.dtos.requests.AutomovilRequest;
import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EditAutomovilCommand extends AutomovilRequest implements Command {
    
    private String id;


}
