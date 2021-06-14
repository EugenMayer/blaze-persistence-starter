package blaze.persistence.starter.module.product.domain.entity;

import blaze.persistence.starter.configuration.BlazePersistenceConfiguration;
import blaze.persistence.starter.configuration.JpaBlazeConfiguration;
import blaze.persistence.starter.module.product.domain.view.*;
import com.blazebit.persistence.view.EntityViewManager;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DataJpaTest
@Import({
  ModelMapper.class,
  JpaBlazeConfiguration.class,
  BlazePersistenceConfiguration.class,
})
class ProductTest
{
  @Autowired
  EntityViewManager entityViewManager;

  @Autowired
  EntityManager entityManager;

  @Test
  void createProduct()
  {
    assertThatCode(() -> entityViewManager.save(entityManager, getCV())).doesNotThrowAnyException();
  }

  @Test
  void updateProductUsingImpl()
  {
    var createView = getCV();
    entityViewManager.save(entityManager, createView);

    var updateView = new ProductUpdateViewImpl(createView.getId());
    updateView.setName("apple");
    entityViewManager.save(entityManager, updateView);

    var updateProduct = entityViewManager.find(entityManager, ProductEntireView.class, updateView.getId());
    assertThat(updateProduct.getName()).isEqualTo("apple");
  }

  private ProductCreateView getCV()
  {
    final var createView = entityViewManager.create(ProductCreateView.class);
    createView.setName("ventilator");
    createView.setPrice(10L);
    return createView;
  }
}
