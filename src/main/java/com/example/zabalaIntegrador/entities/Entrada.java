package com.example.zabalaIntegrador.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
@Entity
@Table(name = "entrada")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entrada extends Base{

  @Column(name = "precio")
  private double precio;
  @Column(name = "asiento")
  private String asiento;
  @ManyToOne(optional = true, cascade = CascadeType.MERGE)
  @JoinColumn(name = "fk_funcion")
  @JsonIdentityReference(alwaysAsId = true)
  private Funcion funcion;
}
