package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Sala;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceImpl extends BaseServiceImpl<Sala, Integer> implements SalaService{
  public SalaServiceImpl(BaseRepository<Sala, Integer> baseRepository) {
    super(baseRepository);
  }
}
