package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Pelicula;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl extends BaseServiceImpl<Pelicula, Integer> implements PeliculaService{
  public PeliculaServiceImpl(BaseRepository<Pelicula, Integer> baseRepository) {
    super(baseRepository);
  }
}
