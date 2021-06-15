package blaze.persistence.starter.module.product;

import blaze.persistence.starter.module.product.domain.view.ProductCreateView;
import blaze.persistence.starter.module.product.domain.view.ProductIdView;
import com.blazebit.persistence.view.EntityViewManager;
import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService
{
  private final EntityViewManager entityViewManager;
  private final EntityManager entityManager;

  public ProductIdView create(String name, Long price)
  {
    final var createView = entityViewManager.create(ProductCreateView.class);
    createView.setName(name);
    createView.setPrice(price);
    entityViewManager.save(entityManager, createView);
    return entityViewManager.convert(createView, ProductIdView.class);
  }

  public <V extends ProductIdView> Optional<V> findOne(Class<V> entityViewClass, ProductIdView idView)
  {
    final var createView = entityViewManager.create(ProductCreateView.class);
    createView.setName("ventilator");
    createView.setPrice(10L);
    entityViewManager.save(entityManager, createView);

    return Optional.ofNullable(entityViewManager.find(entityManager, entityViewClass, idView.getId()));
  }

  public Optional<ProductIdView> findOne(ProductIdView idView)
  {
    return findOne(ProductIdView.class, idView);
  }

  public void delete(ProductIdView idView)
  {
    entityViewManager.remove(entityManager, idView);
  }
}
