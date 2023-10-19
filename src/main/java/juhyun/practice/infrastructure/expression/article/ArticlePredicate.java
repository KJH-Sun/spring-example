package juhyun.practice.infrastructure.expression.article;

import com.querydsl.core.types.dsl.BooleanExpression;
import java.time.LocalDate;
import juhyun.practice.infrastructure.entity.ArticleEntity.ArticleType;
import juhyun.practice.infrastructure.entity.QArticleEntity;
import juhyun.practice.infrastructure.expression.NullableLiteralExpression;
import juhyun.practice.infrastructure.expression.NullableTemporalExpression;
import juhyun.practice.infrastructure.expression.Predicate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArticlePredicate implements Predicate<QArticleEntity> {

  private ArticleType type;
  private LocalDate createdDateStart;
  private LocalDate createdDateEnd;
  private Boolean hasComment;

  @Override
  public BooleanExpression[] to(final QArticleEntity entity){
    return new BooleanExpression[] {
        NullableLiteralExpression.eq(entity.type, this.type),
        NullableTemporalExpression.between(
            entity.createdAt, this.createdDateStart, this.createdDateEnd)
    };
  }
}
