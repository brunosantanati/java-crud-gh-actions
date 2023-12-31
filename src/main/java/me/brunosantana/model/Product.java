package me.brunosantana.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

  @Id
  // @GeneratedValue(strategy = GenerationType.AUTO)
  // The seed script inserts products until id 3, so for this demo application I'm starting the
  // sequence with 4 to avoid DataIntegrityViolationException
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_id_seq")
  @SequenceGenerator(
      name = "product_id_seq",
      sequenceName = "product_id_seq",
      allocationSize = 1,
      initialValue = 4)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private BigDecimal price;

  @CreationTimestamp private Date createdAt;

  @CreationTimestamp private Date updatedAt;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
