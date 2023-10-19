package juhyun.practice.app.controller.v1;

import juhyun.practice.domain.model.Page;
import juhyun.practice.domain.model.article.Article;
import juhyun.practice.domain.model.article.ArticleSearch;
import juhyun.practice.domain.usecase.article.GetArticleUseCase;
import juhyun.practice.domain.usecase.article.SearchArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/articles")
public class ArticleController {

  private final GetArticleUseCase getUseCase;
  private final SearchArticleUseCase searchUseCase;

  @GetMapping("/{id}")
  public Article read(@PathVariable final Long id){
    return getUseCase.execute(id);
  }

  @GetMapping
  public Page<Article> browse(final ArticleSearch request, @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) final Pageable pageable){
    return searchUseCase.execute(request, pageable);
  }
}
