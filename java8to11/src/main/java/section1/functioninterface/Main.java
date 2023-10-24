package section1.functioninterface;

import java.util.function.Function;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {
        ProvideJava provideJava = new ProvideJava();
        System.out.println(provideJava.apply(1));

        // 사실, ProvideJava를 생성할 필요 없어, 람다로 직접 구현할 수 있다.
        // 더하는 메서드
        Function<Integer, Integer> plus10 = (number) -> number + 10;
//        System.out.println(plus10.apply(5));  // 15

        // 곱하는 메서드
        Function<Integer, Integer> multiply2 = (number) -> number * 2;
//        System.out.println(multiply2.apply(14)); // 28

        // 함수를 조합해서 사용
        // compose란, 함수를 매개변수로 넘기고, 넘긴 함수의 return 값을 매개변수로 넣는 것이다.
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);

        // 첫 로직 3 * 2
        // 두번째 로직 6 + 10
        System.out.println(multiply2AndPlus10.apply(3));

        // andThen을 사용하면 앞에 먼저 하고, 그 후에 오는 것들 2번째로 실행함

        // 첫 로직 7 + 10
        // 두번째 로직 17 * 2
        Integer andThenValue = plus10.andThen(multiply2).apply(7);
        System.out.println(andThenValue); // 34
    }
}
