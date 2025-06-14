package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Cine;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CineServiceImpl extends BaseServiceImpl<Cine, Integer> implements CineService{
  public CineServiceImpl(BaseRepository<Cine, Integer> baseRepository) {
    super(baseRepository);
  }
}
