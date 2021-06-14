package blaze.persistence.starter.module.product.domain.view;

import blaze.persistence.starter.module.product.domain.entity.Product;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

@EntityView(Product.class)
public interface ProductIdView
{
  @IdMapping
  Long getId();
}
