package section1.functioninterface;

import java.util.function.Predicate;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        // 어떠한 인자 값을 받아서 True or False를 return하는 함수
        // integer로 받아서 홀수인지 판별하는 함수, 마찬가지로 Integer도 받을 수 잇음
        Predicate<Integer> isOdd = (i) -> i % 2 != 0;

        boolean test = isOdd.test(2);
        boolean test2 = isOdd.test(3);

        System.out.println("test = " + test);
        System.out.println("test2 = " + test2);

        // 또한 returnr값이 boolean이기 때문에 or, and 등 조합이 가능하다.
    }
}
