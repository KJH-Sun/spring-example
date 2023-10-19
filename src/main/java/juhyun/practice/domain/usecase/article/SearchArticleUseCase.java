package juhyun.practice.domain.usecase.article;

import juhyun.practice.domain.converter.article.ArticleConverter;
import juhyun.practice.domain.converter.article.ArticleSearchConverter;
import juhyun.practice.domain.model.Page;
import juhyun.practice.domain.model.article.Article;
import juhyun.practice.domain.model.article.ArticleSearch;
import juhyun.practice.infrastructure.expression.article.ArticlePredicate;
import juhyun.practice.infrastructure.repository.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchArticleUseCase {

  private final ArticleRepository repository;

  public Page<Article> execute(final ArticleSearch search, final Pageable pageable){
    ArticlePredicate predicate = ArticleSearchConverter.to(search);

    return new Page<>(repository.findPageBy(predicate, pageable).map(ArticleConverter::from));
  }
}
