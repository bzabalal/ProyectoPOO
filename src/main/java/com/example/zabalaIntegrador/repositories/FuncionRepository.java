package com.example.zabalaIntegrador.repositories;

import com.example.zabalaIntegrador.entities.Funcion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepository extends BaseRepository<Funcion, Integer> {


}
