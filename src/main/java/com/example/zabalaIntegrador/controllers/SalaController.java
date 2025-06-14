package com.example.zabalaIntegrador.controllers;

import com.example.zabalaIntegrador.entities.Sala;
import com.example.zabalaIntegrador.services.SalaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class SalaController extends BaseControllerImpl<Sala, SalaServiceImpl>{
  public SalaController(SalaServiceImpl service) {
    super(service);
  }
}
