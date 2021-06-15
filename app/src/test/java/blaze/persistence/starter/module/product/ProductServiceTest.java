package blaze.persistence.starter.module.product;

import blaze.persistence.starter.configuration.BlazePersistenceConfiguration;
import blaze.persistence.starter.configuration.JpaBlazeConfiguration;
import blaze.persistence.starter.module.product.domain.view.ProductEntireView;
import blaze.persistence.starter.module.product.domain.view.ProductIdView;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({
  ProductService.class,

  ModelMapper.class,
  JpaBlazeConfiguration.class,
  BlazePersistenceConfiguration.class,
})
class ProductServiceTest
{
  @Autowired
  ProductService productService;

  @Test
  void shouldCreate()
  {
    final ProductIdView rick = productService.create("rick", 15L);
    var rickFull = productService.findOne(ProductEntireView.class, rick).orElseThrow();

    assertThat(rickFull).extracting("name", "price").containsExactlyInAnyOrder("rick", 15L);
  }

  @Test
  void shouldDelete()
  {
    final ProductIdView rick = productService.create("rick", 15L);
    productService.delete(rick);

    assertThat(productService.findOne(ProductIdView.class, rick)).isEmpty();
  }
}
