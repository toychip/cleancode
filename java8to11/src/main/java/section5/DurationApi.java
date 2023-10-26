package section5;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationApi {
    public static void main(String[] args) {

        // Pariod는 인간용 날짜 비교, Duration은 기계용 날짜 비교이다.
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());

    }
}
