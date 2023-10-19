package juhyun.practice.domain.converter.article;

import juhyun.practice.domain.model.DatePeriod;
import juhyun.practice.domain.model.article.ArticleSearch;
import juhyun.practice.infrastructure.expression.article.ArticlePredicate;
import lombok.experimental.UtilityClass;

public class ArticleSearchConverter {

  private ArticleSearchConverter() {
    throw new UnsupportedOperationException();
  }
  public static ArticlePredicate to(final ArticleSearch search){
    if(search == null){
      return null;
    }

    DatePeriod createdDatePeriod = search.getCreatedDatePeriod();

    return ArticlePredicate.builder()
        .type(search.getType())
        .createdDateStart(createdDatePeriod.getStart())
        .createdDateEnd(createdDatePeriod.getEnd())
        .hasComment(search.getHasComment())
        .build();
  }

}
