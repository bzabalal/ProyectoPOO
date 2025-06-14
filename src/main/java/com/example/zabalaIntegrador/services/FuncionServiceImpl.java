package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Funcion;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionServiceImpl extends BaseServiceImpl<Funcion, Integer> implements FuncionService{

  public FuncionServiceImpl(BaseRepository<Funcion, Integer> baseRepository) {
    super(baseRepository);
  }
}
