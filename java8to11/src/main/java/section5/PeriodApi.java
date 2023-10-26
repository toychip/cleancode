package section5;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodApi {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        // 현재 2023년 10월 26일
        System.out.println("현재 " + today.getYear() + "년 " +
                                    today.getMonthValue() + "월 " +
                                    today.getDayOfMonth() + "일");

        LocalDate thisYearXMas = LocalDate.of(2023, Month.DECEMBER, 25);

        Period toXMas = Period.between(today, thisYearXMas);
        int days = toXMas.getDays();
        System.out.println("days = " + days);

        /**
         * 내가 기대한 내용은 60일이였다. 하지만 일수의 차이만을 고려하기에 같은 달 안에서만 사용하여 해당 날짜처럼 나왔다.
         * 이럴 때 ChronoUnit.DAYS를 사용하면 된다.
         */

        long untilXmas = ChronoUnit.DAYS.between(today, thisYearXMas);
        System.out.println("untilXmas = " + untilXmas);


    }
}
