package blaze.persistence.starter.module.product.domain.view;

import blaze.persistence.starter.module.product.domain.entity.Product;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.UpdatableEntityView;

@EntityView(Product.class)
@UpdatableEntityView
public interface ProductUpdateView extends ProductEntireView, ProductIdView
{
  void setId(Long id);

  void setName(String name);

  void setPrice(Long price);
}
