package br.com.felpofo.rental.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {

  @Id
  @GeneratedValue
  @Column(name="id")
  private UUID id;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "car_id")
  private Car car;

  @NonNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NonNull
  @Column(name="start_date", nullable=false)
  private Timestamp start_date;

  @NonNull
  @Column(name="end_date", nullable=false)
  private Timestamp end_date;

  @NonNull
  @Column(name="expected_return_date", nullable=false)
  private Timestamp expected_return_date;

  @CreationTimestamp
  @Column(name="created_at", nullable=false, updatable=false)
  private Timestamp created_at;

  @UpdateTimestamp
  @Column(name="updated_at", nullable=false)
  private Timestamp updated_at;

}
