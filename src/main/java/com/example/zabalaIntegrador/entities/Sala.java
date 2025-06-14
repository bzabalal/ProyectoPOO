package com.example.zabalaIntegrador.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sala")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Sala extends Base{

  @Column(name = "capacidad")
  private int capacidad;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinTable(
    name= "sala_funcion",
    joinColumns = @JoinColumn(name="sala_id"),
    inverseJoinColumns = @JoinColumn(name = "funcion_id")
  )
  private List<Funcion> funciones = new ArrayList<Funcion>();
}
