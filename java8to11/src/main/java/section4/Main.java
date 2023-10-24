package section4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass springBoot = new OnlineClass(1, "SpringBoot", true);
        springBoot.getProgress().ifPresent(p -> System.out.println(p.getStudyDuration()));

        // 그냥 getProgress를 하면, 아래오 같음
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
    }
}

