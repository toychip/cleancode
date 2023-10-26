package section4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMain {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass springBoot = new OnlineClass(1, "SpringBoot", true);
        springBoot.getProgress().ifPresent(p -> System.out.println(p.getStudyDuration()));

        // 그냥 getProgress를 하면, 아래와 같음
        // getProgress -> progress가 기본값을 return하는데, 레퍼런스 값의 기본 값은 null, 값이 채워져 있지 않기 때문에 NPE

        /**
         * premitive type optional 사용법
         * optional.of(10) 이런 방식으로도 사용 가능하지만,
         * optional에서 또 언박싱 해야하므로 성능에 좋지 않음
         * OptionalInt
         * OptionalDouble
         * OptionalLong
         */

        /**
         * Collection, Map, Stream, Arrays, Optional은 Optional로 감싸지 말것.
         * 그 자체로 비어있는지 알 수 있는 컨테이너 성격의 인스턴스를 굳이 왜 하냐? 하지마라
         */

        // isPresent
        Optional<OnlineClass> springOptional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = springOptional.isPresent();
        System.out.println(present);


        // isEmpty
        Optional<OnlineClass> jpaOptional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("JPA"))
                .findFirst();

        boolean empty = jpaOptional.isEmpty();
        System.out.println(empty);

        /**
         * 값이 있다면 꺼냄. 하지만 없다면 RunTimeException 중 하나인 NoSuchElementException이 발생함
         * get을 쓰면서 값이 존재하는지 if를 사용하지 말고, 밑에 내용을 사용하자.
         */

//        OnlineClass onlineClass = springOptional.get();
//        System.out.println(onlineClass.getTitle());

        // 값이 존재하면 print하라
        springOptional.ifPresent(oc -> System.out.println(oc.getTitle()));

        /**
         * 무조건 springOptional 타입으로 받아야한다면
         * 찾았을 때 없다면 새로운 객체를 생성함
         * orElse에서 값이 존재하더라도 무조건적으로 실행되므로 실행된다해서 무조건 세로운 객체가 생성되는 것은 아니다.
         * 하지만 이러한 것은 좀 찝찝하다. 이럴 때 사용할 수 있는 것이 orElseGet이다.
         */
        // OnlineClass onlineClass1 = springOptional.orElse(createNewSpringClasses());

        /**
         * 값이 없다면 메서드 실행, 현재 없는 상태
         */
        jpaOptional.orElseGet(OptionalMain::createNewSpringClasses);

        /**
         * 값을 생성하는 것이 아닌, 만들어줄 수 없는 상황이거나 예외를 터뜨리고 싶다면 아래와 같이 설정
         * 기본적으로는 NoSUchElementException 발생
         */
        // jpaOptional.orElseThrow(IllegalArgumentException::new);

        /**
         * 값을 걸러낼 때 사용. 값이 있을 수도, 없을 수도 있기 때문에 Optional 반환
         * filter는 보통 조건에 따라 값을 "유지"하거나 "버릴" 때, map은 값을 "변환"할 때 사용
         */
        Optional<OnlineClass> onlineClass = jpaOptional.filter(OnlineClass::isClosed);
        System.out.println(onlineClass.isEmpty()); // true

        Optional<Boolean> aBoolean = jpaOptional.map(OnlineClass::isClosed);

        /**
         * 만약 옵셔널이 제공하는 것에 대한 옵셔널, 즉 OnlineClass가 갖고 있는 메서드의 반환 값이 Optional이고,
         * map을 progress로하면 optional이 나온다. 왜? jpaOptional이 optional이니까, 그런데 반환하는
         * 메서드, getProgress가 Optional을 반환하니까, 아래와 같이 된다.
         * 이럴 때 하나씩 까면서 예외를 터뜨리고 꺼내기 번거러우므로, flatMap을 사용한다.
         * Optional이 제공하는 flatMap은 mapping해서 꺼내는 타입 (여기선 getProgress)이 Optional이면
         * 한 번 미리 까준다.
         */

        Optional<Optional<Progress>> progress1 = jpaOptional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());

        // 위와 같은 코드
        Optional<Progress> flatProgress = jpaOptional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewSpringClasses() {
        System.out.println("orElse 는 해당 메서드 무조건 적으로 실행");
        System.out.println("orElseGet은 값이 없을 때에만 본 메서드 실행");
        return new OnlineClass(1, "defaultTitle", true);
    }

}

