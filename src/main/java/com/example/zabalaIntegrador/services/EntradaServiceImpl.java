package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Entrada;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class EntradaServiceImpl extends BaseServiceImpl<Entrada, Integer> implements EntradaService{
  public EntradaServiceImpl(BaseRepository<Entrada, Integer> baseRepository) {
    super(baseRepository);
  }


}
