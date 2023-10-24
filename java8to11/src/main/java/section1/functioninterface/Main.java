package section1.functioninterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("toychip");
        name.add("junjun");
        name.add("ofo");

        // 아래 둘은 같은 메서드다. 순회하면서 모두 print한다.
//        name.forEach(s -> System.out.println(s));
//        name.forEach(System.out::println);

        // spliterator 쪼개진 것들의 String 들이 존재할 때까지 반복해서 Print
        Spliterator<String> spliterator1 = name.spliterator();
        System.out.println("-----  flag 1  ----");
        while (spliterator1.tryAdvance(System.out::println));

        System.out.println("-----------------자르기 전--------------------");
        // 아래의 trySplit을 사용하면 반으로 쪼갬. 4개면 2, 2. 3개면 1,2 이런 방식
        // name 리스트를 string을 개당 나눠서 spliterator1 넣음.
        spliterator1 = name.spliterator();

        // spliterator1에 있는 값을 반으로 잘라서, 2엔다가 넣음.
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        // spliterator1을 print
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("================");
        // spliterator2를 print
        while (spliterator2.tryAdvance(System.out::println));


    }
}

