package com.example.zabalaIntegrador.entities;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cine")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Cine extends Base{

  @Column(name = "nombre")
  private String nombre;
  @Column(name = "direccion")
  private String direccion;

  @ManyToMany(cascade = CascadeType.REFRESH)
  private List<Empleado> empleados = new ArrayList<Empleado>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
  @JoinTable(
    name = "cine_pelicula",
    joinColumns = @JoinColumn(name = "cine_id"),
    inverseJoinColumns = @JoinColumn(name = "pelicula_id")
  )
  private List<Pelicula> peliculas = new ArrayList<Pelicula>();


  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinTable(
    name = "cine_sala",
    joinColumns = @JoinColumn(name = "cine_id"),
    inverseJoinColumns = @JoinColumn(name = "sala_id")
  )
  private List<Sala> salas = new ArrayList<Sala>();
}
