package br.com.felpofo.rental.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue
  private UUID id;

  private String name;
  private String username;
  private String password;
  private String email;
  private boolean admin;

  private String driver_license;

  @ManyToOne
  @JoinColumn(name = "rentals_id")
  private Rental rentals;

  @GeneratedValue
  private Date created_at;

}
