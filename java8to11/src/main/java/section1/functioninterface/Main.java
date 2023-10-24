package section1.functioninterface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        Main main = new Main();
        main.run();
    }

    private void run() {
        // java 8부터는 해당 변수가 '사실상' final인 경우 생략이 가능하다.
        int baseNumber = 10;
        // baseNumber++; -> 메서드들에서 오류가 남

        // 로컬 클래스
        class LocalClass{
            void printBaseNumber() {
                // 로컬 클래스 내부에 있는 baseNumber가 바깥에 있는 baseNumber를 가린다.
                int baseNumber = 20;
                System.out.println("LocalClass.printBaseNumber = " + baseNumber);   // 20이 찍힘
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {

            int baseNumber = 500;   // 익명 클래스 내부에 있는 baseNumber가 바깥에 있는 baseNumber를 가린다.
            @Override
            public void accept(Integer baseNumber) {    // 클래스에 있는 baseNumber가 아닌, 매개변수로 baseNumber를 사용함
                System.out.println(baseNumber);
            }
        };


        // 람다
        // 위 2개의 클래스와의 차이점은, 쉐도잉이 가능하지 않다. 위와같이 변수를 가릴 수 없다.
        // 처음 int baseNumber 선언한 곳과 같은 스코프이기 때문이다.
        IntConsumer consumer = (i) -> {
            System.out.println(i + baseNumber);
        };

        consumer.accept(10000);
    }
}
