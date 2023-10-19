package juhyun.practice.domain.model;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Getter
@NoArgsConstructor
public class Page<T> implements Serializable {

  private int pageSize;

  private int pageNumber;

  private int totalPageCount;

  private Long totalCount;

  private List<T> data;

  public Page(final org.springframework.data.domain.Page<T> source) {
    Pageable pageable = source.getPageable();

    this.pageSize = pageable.getPageSize();
    this.pageNumber = pageable.getPageNumber();

    this.totalPageCount = source.getTotalPages();
    this.totalCount = source.getTotalElements();

    this.data = source.getContent();
  }
}
