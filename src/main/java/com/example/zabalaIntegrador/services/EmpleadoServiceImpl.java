package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Empleado;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Integer> implements EmpleadoService{
  public EmpleadoServiceImpl(BaseRepository<Empleado, Integer> baseRepository) {
    super(baseRepository);
  }
}
