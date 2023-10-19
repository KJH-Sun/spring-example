package juhyun.practice.infrastructure.expression;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.LiteralExpression;

public class NullableLiteralExpression {

  private NullableLiteralExpression(){
    throw new UnsupportedOperationException();
  }

  public static <T extends Comparable<T>>BooleanExpression eq(final LiteralExpression<T> expression, final T value){
    return value == null ? null : expression.eq(value);
  }
}
