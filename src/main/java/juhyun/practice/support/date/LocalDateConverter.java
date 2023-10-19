package juhyun.practice.support.date;

import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;

public class LocalDateConverter {

  private LocalDateConverter() {
    throw new UnsupportedOperationException();
  }

  public static LocalDate from(final String str){
    return StringUtils.isNotBlank(str) ? LocalDate.parse(str) : null;
  }

}
