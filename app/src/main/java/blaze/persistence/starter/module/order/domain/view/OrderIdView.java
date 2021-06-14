package blaze.persistence.starter.module.order.domain.view;

import blaze.persistence.starter.module.order.domain.entity.Order;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

@EntityView(Order.class)
public interface OrderIdView
{
  @IdMapping
  Long getId();
}
