package juhyun.practice.infrastructure.repository.comment;

import java.util.Collection;
import juhyun.practice.infrastructure.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>, CommentQueryDslRepository {
  Collection<CommentEntity> findAllByArticleId(final Long articleId);
}
