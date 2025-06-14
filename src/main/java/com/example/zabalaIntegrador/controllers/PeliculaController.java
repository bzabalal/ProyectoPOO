package com.example.zabalaIntegrador.controllers;

import com.example.zabalaIntegrador.entities.Pelicula;
import com.example.zabalaIntegrador.services.PeliculaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/peliculas")
public class PeliculaController extends BaseControllerImpl<Pelicula, PeliculaServiceImpl>{
  public PeliculaController(PeliculaServiceImpl service) {
    super(service);
  }
}
