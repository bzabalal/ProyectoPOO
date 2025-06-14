package com.example.zabalaIntegrador.services;

import com.example.zabalaIntegrador.entities.Base;
import com.example.zabalaIntegrador.repositories.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E,ID> {

  protected BaseRepository<E,ID> baseRepository;

  public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
    this.baseRepository = baseRepository;
  }

  @Override
  @Transactional
  public List<E> findAll() throws Exception {
      try{
          List<E> entities = baseRepository.findAll();
          return entities;
      } catch (Exception e) {
        throw new Exception(e.getMessage());
      }
  }

  @Override
  public E findById(ID id) throws Exception {
    try{
      Optional<E> optional = baseRepository.findById(id);
      return optional.get();
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public E save(E entity) throws Exception {
    try{
      entity = baseRepository.save(entity);
      return entity;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public E update(ID id, E entity) throws Exception {
    try{
      Optional<E> optional = baseRepository.findById(id);
      E entityUpdated = optional.get();
      entityUpdated = baseRepository.save(entityUpdated);
      return entityUpdated;
    }catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public boolean delete(ID id) throws Exception {
    try{
      if(baseRepository.existsById(id)){
        baseRepository.deleteById(id);
        return true;
      }else{
        throw new Exception();
      }
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }
}
