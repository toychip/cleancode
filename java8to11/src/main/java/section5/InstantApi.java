package section5;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantApi {
    public static void main(String[] args) {

        /**
         * Instant는 기계용 시간, 메서드의 특정 시간 설정 등 기계가 사용하는 시간이다.
         */

        Instant instant = Instant.now();

        // UTC, GMT 시간
        System.out.println(instant);
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        // 어느 zone의 기준으로 현재 시간을 판단할 것인가
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);
    }
}
