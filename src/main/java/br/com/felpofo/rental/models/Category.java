package br.com.felpofo.rental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue
  private UUID id;

  private String name;
  private String description;


  @ManyToOne
  @JoinColumn(name = "cars_id")
  private Car cars;

  @GeneratedValue
  private Date created_at;

}
