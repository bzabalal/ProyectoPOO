package com.example.zabalaIntegrador.controllers;

import com.example.zabalaIntegrador.entities.Base;
import com.example.zabalaIntegrador.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Integer>> implements BaseController<E, Integer>{

  public BaseControllerImpl(S service) {
    this.service = service;
  }

  protected S service;
  @GetMapping("")
  public ResponseEntity<?> getAll() {
    try{
      return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente mas tarde\"}");
    }
  }
  /*@GetMapping("/paged")
  public ResponseEntity<?> getAll(SpringDataWebProperties.Pageable pageable) {
    try{
      return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente mas tarde\"}");
    }
  }
  */
  @GetMapping("/{id}")
  public ResponseEntity<?> getOne(@PathVariable Integer id) {
    try{
      return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Intente mas tarde\"}");
    }
  }
  @PostMapping("")
  public ResponseEntity<?> save(@RequestBody E entity) {
    try{
      return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde\"}");

    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody E entity) {
    try{
      return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde\"}");
    }
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    try{
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));

    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde\"}");
    }
  }
}
