package blaze.persistence.starter.module.product.domain.view;

import blaze.persistence.starter.module.product.domain.entity.Product;
import com.blazebit.persistence.view.EntityView;

@EntityView(Product.class)
public interface ProductEntireView extends ProductIdView
{
  String getName();

  Long getPrice();
}
