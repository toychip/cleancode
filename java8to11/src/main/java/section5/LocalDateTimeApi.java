package section5;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeApi {
    public static void main(String[] args) {

        // Local이 붙어있는데, 이것이 사용자의 로컬의 위치를 갖고 온다.
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime birthDay = LocalDateTime.of(1982, Month.JULY, 15, 0, 0, 0);
        System.out.println("birthDay = " + birthDay);

        ZonedDateTime nowLA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("nowLA = " + nowLA);

        /**
         * Instat와 JoindDate Time이 서로 변환이 가능하다.
         * Instant는 기계용 시간을,
         * LocalDateTime은 인간용 시간을,
         * ZonedDateTime은 시간대가 적용된 인간용 시간을 각각 나타낸다.
         */

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime = nowInstant.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println("zonedDateTime = " + zonedDateTime);
    }
}
