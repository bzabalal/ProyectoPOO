package com.example.zabalaIntegrador.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
@Entity
@Table(name = "pelicula")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Pelicula extends Base{

  @Column(name = "nombre")
  private String nombre;

  @Enumerated(EnumType.STRING)
  @Column(name = "genero")
  private Genero genero;

}
