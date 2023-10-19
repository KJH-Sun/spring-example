package juhyun.practice.infrastructure.expression;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.TemporalExpression;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NullableTemporalExpression {

  private NullableTemporalExpression(){
    throw new UnsupportedOperationException();
  }

  public static BooleanExpression between(
      final TemporalExpression<LocalDateTime> expression,
      final LocalDate start,
      final LocalDate end) {
    if(start == null && end == null){
      return null;
    }

    DateTemplate<LocalDate> dateExpression = TemporalExpressionFormatter.formatDate(expression);
    if(end == null){
      return dateExpression.goe(start);
    }

    return start == null ? dateExpression.loe(end) : dateExpression.between(start, end);
  }
}
