package section5;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeFormatterApi {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        // 포맷팅
        DateTimeFormatter MMDDyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMDDyyyy));

        // 파싱
        LocalDate parse = LocalDate.parse("04/27/2000", MMDDyyyy);
        System.out.println(parse);

        // 레거시 - 옛날 Date와 호환
        Date date = new Date();
        Instant instant = date.toInstant();
        Date newDate = Date.from(instant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        ZonedDateTime zonedDateTime = gregorianCalendar
                .toInstant()
                .atZone(ZoneId.systemDefault());

        GregorianCalendar from = GregorianCalendar.from(zonedDateTime);
    }
}
