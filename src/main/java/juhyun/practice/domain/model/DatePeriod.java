package juhyun.practice.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import juhyun.practice.support.date.LocalDateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
public class DatePeriod {

  private LocalDate start;
  private LocalDate end;

  public static class Parser {
    private static final String DELIMITER = "~";

    public static DatePeriod parse(final String str){
      if(StringUtils.isBlank(str)){
        return new DatePeriod(null, null);
      }

      validateFormat(str);

      String[] dates = str.split(DELIMITER, -1);
      LocalDate startDate = convertTo(extractOrNull(dates, 0));
      LocalDate endDate = convertTo(extractOrNull(dates, 1));

      return new DatePeriod(startDate, endDate);
    }

    private static String extractOrNull(final String[] source, final int index) {
      try {
        return source[index];
      } catch (IndexOutOfBoundsException e) {
        return null;
      }
    }

    private static LocalDate convertTo(final String str) {
      try {
        return LocalDateConverter.from(str);
      } catch (DateTimeParseException e) {
        throw new IllegalArgumentException(e);
      }
    }

    private static void validateFormat(final String str) {
      if (!str.contains(DELIMITER)) {
        throw new IllegalArgumentException();
      }
    }
  }



}
