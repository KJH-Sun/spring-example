package juhyun.practice.domain.converter;

import juhyun.practice.domain.model.Article;
import juhyun.practice.infrastructure.entity.ArticleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ArticleConverter {
  public static Article from(final ArticleEntity entity){
    if(entity == null){
      return null;
    }

    return Article.builder()
        .id(entity.getId())
        .type(entity.getType())
        .name(entity.getName())
        .createdBy(entity.getCreatedBy())
        .build();
  }

  public static ArticleEntity to(final Article data){
    if(data == null){
      return null;
    }

    return ArticleEntity.builder()
        .id(data.getId())
        .type(data.getType())
        .name(data.getName())
        .build();
  }

}
