package blaze.persistence.starter.module.order.domain.view;

import blaze.persistence.starter.module.order.domain.entity.Order;
import blaze.persistence.starter.module.product.domain.entity.Product;
import com.blazebit.persistence.view.EntityView;
import java.util.List;

@EntityView(Order.class)
public interface OrderEntireView extends OrderIdView
{
  List<Product> getProducts();
}
