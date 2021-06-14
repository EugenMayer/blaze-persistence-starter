package blaze.persistence.starter.configuration;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * Blaze configuration
 */
@Configuration
@EnableEntityViews("blaze.persistence.starter")
public class BlazePersistenceConfiguration
{
  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  @Lazy(false)
  public CriteriaBuilderFactory criteriaBuilderFactory()
  {
    CriteriaBuilderConfiguration config = Criteria.getDefault();
    return config.createCriteriaBuilderFactory(entityManagerFactory);
  }

  /**
   * Inject the criteria builder factory which will be used along with the entity view manager.
   *
   * @see
   * <a href="https://persistence.blazebit.com/documentation/1.3/entity-view/manual/en_US/#anchor-environment-spring">
   *   Blazebit documentation
   *   </a>
   */
  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  @Lazy(false)
  public EntityViewManager entityViewManager(
    CriteriaBuilderFactory cbf,
    EntityViewConfiguration entityViewConfiguration
  )
  {
    entityViewConfiguration.setProperty("com.blazebit.persistence.view.static_metamodel_scanning_disabled", "true");
    entityViewConfiguration.setProperty("com.blazebit.persistence.view.static_builder_scanning_disabled", "true");
    entityViewConfiguration
      .setProperty("com.blazebit.persistence.view.static_implementation_scanning_disabled", "true");

    return entityViewConfiguration.createEntityViewManager(cbf);
  }
}
