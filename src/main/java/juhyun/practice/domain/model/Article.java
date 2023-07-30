package juhyun.practice.domain.model;

import java.util.Collection;
import juhyun.practice.infrastructure.entity.ArticleEntity.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Article {
  private Long id;

  private ArticleType type;

  private String name;
  private String createdBy;

  private Collection<Comment> comments;
}
