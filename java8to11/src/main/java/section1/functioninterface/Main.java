package section1.functioninterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("toychip");
        name.add("junjun");
        name.add("ofo");
        name.add("abcdefg");
        name.add("가"); // 한글은 가장 순서가 늦음

        // "t"로 시작하는 것 제외
        name.removeIf(s -> s.startsWith("t"));
//        name.forEach(System.out::println);

        // 문자열 정렬
        name.sort(String::compareToIgnoreCase);

        // 기존 정렬의 역순으로 정렬
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());

        name.forEach(System.out::println);
    }
}

