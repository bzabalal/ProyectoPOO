package com.example.zabalaIntegrador.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited

public class Funcion extends Base{

  @Column(name = "horario")
  private String horario;

  @OneToOne(optional = true, cascade = CascadeType.MERGE)
  @JoinColumn(name = "fk_pelicula")
  private Pelicula pelicula;

}
