package juhyun.practice.infrastructure.expression;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.TemporalExpression;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class TemporalExpressionFormatter {

  private static final String DEFAULT_DATE_FORMAT = "DATE_FORMAT({0}, '%Y-%m-%d')";

  private TemporalExpressionFormatter(){
    throw new UnsupportedOperationException();
  }

  public static DateTemplate<LocalDate> formatDate(final TemporalExpression<LocalDateTime> expression){
    return Expressions.dateTemplate(LocalDate.class, DEFAULT_DATE_FORMAT, expression);
  }

}
