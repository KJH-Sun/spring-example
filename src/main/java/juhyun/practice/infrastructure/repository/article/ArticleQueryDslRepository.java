package juhyun.practice.infrastructure.repository.article;

import juhyun.practice.infrastructure.entity.ArticleEntity;
import juhyun.practice.infrastructure.expression.article.ArticlePredicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleQueryDslRepository {
  Page<ArticleEntity> findPageBy(final ArticlePredicate predicate, final Pageable pageable);

}
