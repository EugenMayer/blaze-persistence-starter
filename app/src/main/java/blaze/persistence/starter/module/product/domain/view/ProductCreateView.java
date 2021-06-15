package blaze.persistence.starter.module.product.domain.view;

import blaze.persistence.starter.module.product.domain.entity.Product;
import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;

@EntityView(Product.class)
@CreatableEntityView
public interface ProductCreateView extends ProductEntireView, ProductIdView
{
  void setId(Long id);

  void setName(String name);

  void setDescription(String description);

  void setPrice(Long price);
}
