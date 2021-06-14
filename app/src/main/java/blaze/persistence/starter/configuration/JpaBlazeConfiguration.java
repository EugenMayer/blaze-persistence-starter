package blaze.persistence.starter.configuration;

import com.blazebit.persistence.spring.data.impl.repository.BlazePersistenceRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Blaze based JPA configuration replacing the repositoryFactoryBeanClass
 */
@Configuration
@EnableJpaRepositories(
  basePackages = "blaze.persistence.starter",
  repositoryFactoryBeanClass = BlazePersistenceRepositoryFactoryBean.class
)
@EnableTransactionManagement
public class JpaBlazeConfiguration
{
}
