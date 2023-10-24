package section1.functioninterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("toychip");
        name.add("junjun");
        name.add("ofo");
        name.add("abcdefg");
        name.add("가"); // 한글은 가장 순서가 늦음

        /**
         * stream API는 연속된 data를 처리하는 operation들의 모임이다.
         * stream은 data가 아님. 컬렉션이 data를 갖고 있고 stream은 이를 source로 사용
         * stream으로 처리하는 데이터는 오직 한번만 처리한다.
         * stream은 크게 2가지로 나눌 수 있다.
         * 중개 operator, 터미널 operator
         * 중개 operator은 근본적으로 lazy하다. 중개 operator은 stream을 return한다.
         * 중개 operator은 treminal이 오기 전까지 실행을 하지 않는다.
         * 중개 operator은 종료 operator가 오지 않는다면 무의미하다!
         * 종료 operator은 Stream을 리턴하지 않는다.
         */

        // stream은 또다른 stream이 됨
        Stream<String> stringStream = name.stream().map(String::toUpperCase);

        // 중개 operator은 treminal이 오기 전까지 실행을 하지 않는다. !!!
        name.stream().map((s) -> {
            System.out.println(s);  // 출력 되지 않음
            return s.toUpperCase();
        });

        // name은 변하지 안았으므로 기존의 값과 같음
        name.forEach(System.out::println);

        System.out.println("------------------");
        // 병렬 처리하는 방법 다른 쓰레드를 생성하여 거기서 실행
        // 데이터가 정말 방대한 경우 병렬 처리하는 것이 이득
        List<String> collect = name.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}

