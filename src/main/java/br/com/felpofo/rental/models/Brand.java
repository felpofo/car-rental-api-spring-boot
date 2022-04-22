package br.com.felpofo.rental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "brands")
public class Brand {

  @Id
  @GeneratedValue
  private UUID id;

  private String name;
  private String image_url;

  @ManyToOne
  @JoinColumn(name = "cars_id")
  private Car cars;

  @ManyToOne
  @JoinColumn(name = "managers_id")
  private User managers;

  @GeneratedValue
  private Date created_at;

}
