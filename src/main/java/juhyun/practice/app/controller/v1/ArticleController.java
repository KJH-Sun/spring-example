package juhyun.practice.app.controller.v1;

import juhyun.practice.domain.model.Article;
import juhyun.practice.domain.usecase.article.GetArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/articles")
public class ArticleController {

  private final GetArticleUseCase getUseCase;

  @GetMapping("/{id}")
  public Article read(@PathVariable final Long id){
    return getUseCase.execute(id);
  }
}
