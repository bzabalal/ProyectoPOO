package com.example.zabalaIntegrador.controllers;

import com.example.zabalaIntegrador.entities.Empleado;
import com.example.zabalaIntegrador.services.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl> {
  public EmpleadoController(EmpleadoServiceImpl service) {
    super(service);
  }
}
