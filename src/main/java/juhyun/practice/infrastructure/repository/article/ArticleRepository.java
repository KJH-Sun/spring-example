package juhyun.practice.infrastructure.repository.article;

import juhyun.practice.infrastructure.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long>, ArticleQueryDslRepository {

}
