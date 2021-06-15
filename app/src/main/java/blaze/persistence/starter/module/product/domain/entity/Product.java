package blaze.persistence.starter.module.product.domain.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product
{
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String description;

  private String color;

  private Long weight;

  private Long price;
}
