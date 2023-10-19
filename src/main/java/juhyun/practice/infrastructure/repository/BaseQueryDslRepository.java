package juhyun.practice.infrastructure.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseQueryDslRepository extends QuerydslRepositorySupport {

  /**
   * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
   *
   * @param domainClass must not be {@literal null}.
   */
  public BaseQueryDslRepository(final Class<?> domainClass) {
    super(domainClass);
  }

  @NonNull
  @Override
  public Querydsl getQuerydsl() {
    return Objects.requireNonNull(super.getQuerydsl());
  }

  @NonNull
  @Override
  public EntityManager getEntityManager() {
    return Objects.requireNonNull(super.getEntityManager());
  }

  @Override
  @PersistenceContext
  public void setEntityManager(@NonNull EntityManager entityManager) {
    super.setEntityManager(entityManager);
  }
}
