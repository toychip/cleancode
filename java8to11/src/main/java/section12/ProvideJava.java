package section12;

import java.util.function.Function;

public class ProvideJava implements Function<Integer, Integer> {

    // FUnInterfaceInteger 에서 사용한 수학 함수가 이미 이렇게 정의도어있음.
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
