package section1.functioninterface;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        Function<Integer, Integer> plus10 = (number) -> number + 10;

        // 입력하는 값과, return하는 값이 같다면 아래처럼 UnaryOperator를 사용할 수 있다.
        UnaryOperator<Integer> plus10_2 = (number) -> number + 10;

        // 입력하는 2개의 매개변수와 return이 모두 같을 때 아래와 같이 사용 가능
        BinaryOperator<Integer> plus10_3 = (number1, number2) -> number1 + number2 + 3;


    }
}
