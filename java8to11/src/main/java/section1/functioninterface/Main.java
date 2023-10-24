package section1.functioninterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        // 무조건 10을 return하는 함수
        // T타입의 값을 제공하는 함수 인터페이스
        Supplier<Integer> get10 = () -> 10;
        Integer integer = get10.get();
        System.out.println("integer = " + integer); // integer = 10
    }
}
