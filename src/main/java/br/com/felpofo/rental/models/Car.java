package br.com.felpofo.rental.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue
  @Column(name="id")
  private UUID id;

  @NonNull
  @Column(name="name", nullable=false, unique=true)
  private String name;

  @Column(name="description")
  private String description;

  @Column(name="available")
  private boolean available;

  @NonNull
  @Column(name="license_plate", nullable=false, unique=true)
  private String license_plate;

  @Column(name="image_url")
  private String image_url;

  @NonNull
  @Column(name="daily_rate")
  private BigDecimal daily_rate;

  @NonNull
  @Column(name="fine_amount")
  private BigDecimal fine_amount;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @CreationTimestamp
  @Column(name="created_at", nullable=false, updatable=false)
  private Timestamp created_at;

  @UpdateTimestamp
  @Column(name="updated_at", nullable=false)
  private Timestamp updated_at;
}
