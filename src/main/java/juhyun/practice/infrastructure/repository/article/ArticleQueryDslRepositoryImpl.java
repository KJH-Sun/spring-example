package juhyun.practice.infrastructure.repository.article;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import java.util.Collection;
import juhyun.practice.infrastructure.entity.ArticleEntity;
import juhyun.practice.infrastructure.entity.QArticleEntity;
import juhyun.practice.infrastructure.entity.QCommentEntity;
import juhyun.practice.infrastructure.expression.OptionalFilterQuery;
import juhyun.practice.infrastructure.expression.article.ArticlePredicate;
import juhyun.practice.infrastructure.repository.BaseQueryDslRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

public class ArticleQueryDslRepositoryImpl extends BaseQueryDslRepository
    implements ArticleQueryDslRepository {

  private static final QArticleEntity article = QArticleEntity.articleEntity;
  private static final QCommentEntity comment = QCommentEntity.commentEntity;

  public ArticleQueryDslRepositoryImpl() {
    super(ArticleEntity.class);
  }

  @Override
  public Page<ArticleEntity> findPageBy(final ArticlePredicate predicate, final Pageable pageable) {
    JPQLQuery<ArticleEntity> query =
        getQuerydsl().applyPagination(pageable, this.createFindAllQuery(article, predicate));

    return PageableExecutionUtils.getPage(
        query.fetch(),
        pageable,
        () -> this.createFindAllQuery(article.count(), predicate).fetchFirst());
  }
  private <T> JPQLQuery<T> createFindAllQuery(
      final Expression<T> selectExpression, final ArticlePredicate predicate) {
    JPQLQuery<T> query = getQuerydsl().createQuery().select(selectExpression).from(article);

    OptionalFilterQuery.of(query)
        .ifPresent(predicate)
        .whereAll(v -> v.to(article))
        .ifPresent(predicate.getHasComment())
        .where(
            v -> {
              JPQLQuery<Long> subQuery =
                  getQuerydsl()
                      .createQuery()
                      .select(comment.id)
                      .from(comment)
                      .where(article.id.eq(comment.articleId));

              return v ? subQuery.exists() : subQuery.notExists();
            });

    return query;
  }

}
