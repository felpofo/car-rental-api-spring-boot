package br.com.felpofo.rental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue
  private UUID id;

  private String name;
  private String description;
  private boolean available;

  private String license_plate;
  private String image_url;

  private BigDecimal daily_rate;
  private BigDecimal fine_amount;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @GeneratedValue
  private Date created_at;

}
