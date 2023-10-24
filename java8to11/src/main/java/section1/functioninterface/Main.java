package section1.functioninterface;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        // 람다 표현식
        // ()가 인자를 나타냄, 아래는 인자가 없는 Supplier 인터페이스 사용
        Supplier<Integer> supplier = () -> 10;

        // 인자가 2개인 경우 아래와 같이 사용. 인자 2개인 BinaryOperator 인터페이스 사용
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b + 1;



    }
}
