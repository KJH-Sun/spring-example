package juhyun.practice.infrastructure.expression;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import java.util.Optional;
import java.util.function.Function;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OptionalFilterQuery<E> {

  private final JPQLQuery<E> query;

  public static <E> OptionalFilterQuery<E> of(final JPQLQuery<E> query) {
    return new OptionalFilterQuery<>(query);
  }

  public <P> FilterClause<E, P> ifPresent(final P predicate) {
    return new FilterClause<>(query, predicate);
  }

  @AllArgsConstructor
  public static class FilterClause<E, P> {

    private final JPQLQuery<E> query;
    private final P predicate;

    public OptionalFilterQuery<E> where(final Function<P, BooleanExpression> mapper) {
      return this.whereAll(p -> new BooleanExpression[] {mapper.apply(p)});
    }

    public OptionalFilterQuery<E> whereAll(final Function<P, BooleanExpression[]> mapper) {
      Optional.ofNullable(predicate).map(mapper).ifPresent(query::where);

      return new OptionalFilterQuery<>(query);
    }
  }
}
