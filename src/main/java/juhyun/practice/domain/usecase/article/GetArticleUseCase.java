package juhyun.practice.domain.usecase.article;

import java.util.Collection;
import java.util.List;
import juhyun.practice.domain.converter.ArticleConverter;
import juhyun.practice.domain.converter.CommentConverter;
import juhyun.practice.domain.exception.ResourceNotFoundException;
import juhyun.practice.domain.model.Article;
import juhyun.practice.domain.model.Comment;
import juhyun.practice.infrastructure.repository.article.ArticleRepository;
import juhyun.practice.infrastructure.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetArticleUseCase {
  private final ArticleRepository repository;
  private final CommentRepository commentRepository;

  public Article execute(final Long id) {
    Article data = repository.findById(id).map(ArticleConverter::from)
        .orElseThrow(ResourceNotFoundException::new);

    return data.toBuilder().comments(this.getAllComment(id)).build();
  }

  public List<Comment> getAllComment(final Long articleId){
    return commentRepository.findAllByArticleId(articleId).stream().map(CommentConverter::from).toList();
  }
}
