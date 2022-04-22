package br.com.felpofo.rental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "rentals")
public class Rental {

  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "car_id")
  private Car car;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private Date start_date;
  private Date end_date;
  private Date expected_return_date;

  @GeneratedValue
  private Date updated_at;
  @GeneratedValue
  private Date created_at;

}
