package section5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarWeakness {
    public static void main(String[] args) {

        // month가 0부터 시작한다. 2000.04.27을 진행하고 싶다면 4가 아닌, 아래와 같이 3을 해야한다.
        GregorianCalendar junhyoungBirthday = new GregorianCalendar(2000, 3, 27);
        GregorianCalendar junhyoungBirthday2 = new GregorianCalendar(2000, Calendar.APRIL, 27);

        // Calendar에서 getTime()을 하는데 왜 Date가 나오는지..? 참 이상함. 그래서 자바 8에서 바뀐 걸 설명할듯
        System.out.println(junhyoungBirthday.getTime());

        // 날짜 하루 증가
        junhyoungBirthday.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(junhyoungBirthday.getTime());

    }
}
