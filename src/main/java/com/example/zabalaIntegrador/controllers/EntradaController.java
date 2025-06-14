package com.example.zabalaIntegrador.controllers;

import com.example.zabalaIntegrador.entities.Entrada;
import com.example.zabalaIntegrador.services.EntradaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/entradas")
public class EntradaController extends BaseControllerImpl<Entrada, EntradaServiceImpl>{
  public EntradaController(EntradaServiceImpl service) {
    super(service);
  }
  }
