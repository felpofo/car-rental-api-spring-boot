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
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue
  @Column(name="id")
  private UUID id;

  @NonNull
  @Column(name="name", nullable=false)
  private String name;

  @NonNull
  @Column(name="username", nullable=false, unique=true)
  private String username;

  @NonNull
  @Column(name="password", nullable=false)
  private String password;

  @NonNull
  @Column(name="email", nullable=false, unique=true)
  private String email;

  @Column(name="admin", nullable=false)
  private boolean admin;

  @Column(name="driver_license")
  private String driverLicense;

  @ManyToOne
  @JoinColumn(name = "rentals_id")
  private Rental rentals;

  @CreationTimestamp
  @Column(name="created_at", nullable=false, updatable=false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name="updated_at", nullable=false)
  private Timestamp updatedAt;

  public String toString() {
    return String.format(
      """
        id=%s
        name=%s
        username=%s
        password=%s
        email=%s
        admin=%s
        driver_license=%s
        rentals=%s
        created_at=%s
        updated_at=%s
        """,
      id, name, username, password,
      email, admin, driverLicense,
      rentals, createdAt, updatedAt
    );
  }
}
