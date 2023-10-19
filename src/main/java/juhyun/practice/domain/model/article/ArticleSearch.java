package juhyun.practice.domain.model.article;

import juhyun.practice.domain.model.DatePeriod;
import juhyun.practice.infrastructure.entity.ArticleEntity.ArticleType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArticleSearch {
  private ArticleType type;

  private String createdDatePeriod;

  private Boolean hasComment;

  public DatePeriod getCreatedDatePeriod() {
    return DatePeriod.Parser.parse(createdDatePeriod);
  }
}
