package section3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
//                        .filter(oc -> !oc.isClosed())
                        .filter(Predicate.not(OnlineClass::isClosed))
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()   // List<List<OnlineClass>> 를 stream으로 Stream<List<OnlineClass>>으로 수정
                                // Stream의 각 요소는 List<OnlineClass>가 됨
                .flatMap(list -> list.stream())     // Stream<OnlineClass>
                .forEach(oc -> System.out.println(oc.getId()));

        /**
         * stream이 제공하는 flatMap과 Optional의 flatMap은 다른 것임
         * stream에서 쓰는 map은 1대1 매핑이다. result도 하나이다.
         * 하지만 stream의 flatmap은 1개의 인풋이 여러개의 아웃풋으로 나누는 것과 같은 것임.
         */



        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");

        Stream.iterate(10, i -> i + 1)      // 여기까지 무제한 데이터로 하는 스트림
                .skip(10)                     // 여기서 skip 갯수를 정함
                .limit(10)               // max 설정
                .forEach(System.out::println);   // 여기서 무제한

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> collect = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring"))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}

