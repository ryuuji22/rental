/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myhotel.vehiculos.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.vehiculos.application.command.create.CreateAutomovilCommand;
import com.myhotel.vehiculos.application.command.create.CreateCamionCommand;
import com.myhotel.vehiculos.application.command.create.CreateMantenimientoCommand;
import com.myhotel.vehiculos.application.command.delete.DeleteVehiculoCommand;
import com.myhotel.vehiculos.application.command.edit.EditAutomovilCommand;
import com.myhotel.vehiculos.application.command.edit.EditCamionCommand;
import com.myhotel.vehiculos.application.queries.ReadAllVehiculoQuery;

import io.jkratz.mediator.core.Mediator;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping("/vehiculo-api")
public class VehiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @Autowired
    private Mediator mediator;

    @DeleteMapping(path = "/vehiculo/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable("id") String id) {
        var deleteCommand = new DeleteVehiculoCommand();
        deleteCommand.setId(id);

        logger.info("--------- Sending command: {} ", deleteCommand.getClass().getName());
        this.mediator.dispatch(deleteCommand);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/vehiculo/automovil")
    public ResponseEntity<Void> createAutomovil(@Valid @RequestBody CreateAutomovilCommand command) {

        logger.info("------ Sending command: {} ", command.getClass().getName());

        this.mediator.dispatch(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/vehiculo/camion")
    public ResponseEntity<Void> createCamion(@Valid @RequestBody CreateCamionCommand command) {

        logger.info("------ Sending command: {} ", command.getClass().getName());

        this.mediator.dispatch(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/vehiculo/camion/{id}")
    public ResponseEntity<Void> editCamion(@PathVariable("id") String id,
            @Valid @RequestBody EditCamionCommand editCommand) {

        editCommand.setId(id);

        logger.info("------ Sending command: {} ", editCommand.getClass().getName());

        this.mediator.dispatch(editCommand);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/vehiculo/automovil/{id}")
    public ResponseEntity<Void> editAutomovil(@PathVariable("id") String id,
            @Valid @RequestBody EditAutomovilCommand editCommand) {

        editCommand.setId(id);
        logger.info("------ Sending command: {} ", editCommand.getClass().getName());

        this.mediator.dispatch(editCommand);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(path = "/vehiculo/{id}/mantenimiento")
    public ResponseEntity<Void> createMantenimiento(@PathVariable("id") String id,
            @Valid @RequestBody CreateMantenimientoCommand createCommand) {

        createCommand.setVehiculoID(id);
        logger.info("------ Sending command: {} ", createCommand.getClass().getName());

        this.mediator.dispatch(createCommand);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/vehiculo")
    public ResponseEntity<Map<String, Object>> listAll() {

        var query = new ReadAllVehiculoQuery();
        logger.info("------ Sending command: {} ", query.getClass().getName());

        return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
    }

}
