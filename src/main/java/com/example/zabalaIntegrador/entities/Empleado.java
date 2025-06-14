package com.example.zabalaIntegrador.entities;

import com.example.zabalaIntegrador.zabalaIntegradorApplication;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;
@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Empleado extends Base {

  @Column(name = "nombre")
  private String nombre;
}
