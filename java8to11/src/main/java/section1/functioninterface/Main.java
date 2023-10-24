package section1.functioninterface;

import java.util.function.Predicate;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        // 어떠한 인자 값을 받아서 True or False를 return하는 함수
        Predicate<String> starts = (s) -> s.startsWith("Jun");
        boolean junhyoung = starts.test("Junhyoung");
        boolean kyoung = starts.test("kyoung");

        System.out.println("junhyoung = " + junhyoung);
        System.out.println("kyoung = " + kyoung);
    }
}
