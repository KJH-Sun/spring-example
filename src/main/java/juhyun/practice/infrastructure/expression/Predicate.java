package juhyun.practice.infrastructure.expression;

import com.querydsl.core.types.dsl.BooleanExpression;

public interface Predicate<E> {

  BooleanExpression[] to(final E entity);
}
