package br.com.felpofo.rental.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue
  @Column(name="id")
  private UUID id;

  @NonNull
  @Column(name="name", nullable=false, unique=true)
  private String name;

  @Column(name="description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "cars_id")
  private Car cars;

  @CreationTimestamp
  @Column(name="created_at", nullable=false, updatable=false)
  private Timestamp createdAt;

}
