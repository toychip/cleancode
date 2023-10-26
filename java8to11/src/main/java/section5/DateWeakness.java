package section5;

import java.util.Date;

public class DateWeakness {

    public static void main(String[] args) throws InterruptedException {

        /**
         * TimeStamp 와 같음
         * 작명이 잘 되어있지 않음. 날짜에서 시간을 갖고 올 수 있음
         */
        Date date = new Date();
        long time = date.getTime(); // 1970. 01. 01, 기계용 시간

        // 3초가 지난 시간 생성
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);

        /**
         * 다시 예전 시간으로 설정 가능함
         * 이런 상태를 mutable하다고 한다. 객체 상태를 바꿀 수 있다.
         * mutable 객체를 멀티스레스 환경에서 수정하면, 값이 정상적이지 않다.
         */
        after3Seconds.setTime(time);
    }
}
