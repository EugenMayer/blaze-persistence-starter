package blaze.persistence.starter.module.order.domain.entity;

import blaze.persistence.starter.module.product.domain.entity.Product;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Order
{
  @Id
  @GeneratedValue
  private Long id;

  @JoinTable
  @ManyToMany(fetch = FetchType.LAZY)
  private List<Product> products;
}
