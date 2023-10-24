package section1.functioninterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> staticMethodReference = Greeting::hi;
        // static method 참조하는 UnaryOperator가 만들어짐

        String kyoung = hi.apply("kyoung");
        String junhyoung = staticMethodReference.apply("junhyoung");
        // 참조하는 UnaryOperator가 이때 만들어져 사용하는 것

        System.out.println("kyoung = " + kyoung);
        System.out.println("junhyoung = " + junhyoung);

        // 생성자 참조하는 법
        Greeting greeting = new Greeting();
        UnaryOperator<String> instanceMethodReference = greeting::hello; // instance method 참조

        // 인자가 있는 생성자 참조하는 법
        Supplier<Greeting> newGreeting = Greeting::new; // 야기까지는 생성자로 객체를 생성하는 것이 아님
        Greeting greeting2 = newGreeting.get(); // 이때 생성하는 것

        // name을 인자로 받는 생성자를 사용
        Function<String, Greeting> junHyoungGreeting = Greeting::new;
        String name = junHyoungGreeting.apply("준형").getName();
        System.out.println("name = " + name);

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"toychip", "junHyoung", "toa"};
        // Comparator란 0을 return하면 같고, 양수이면 앞 인자가 크다는 것이고 음수면 뒤 인자가 크다는 것이다.
        // Comparetor와 Arrays.sort(뒷인자) 를 조합해서 사용한 것
        // Arrays.sort(names, (o1, o2) -> 0); 위와 아래가 같은 것
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }

}
