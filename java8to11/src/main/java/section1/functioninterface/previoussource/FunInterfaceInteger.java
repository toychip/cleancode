package section1.functioninterface.previoussource;

public class FunInterfaceInteger {
    public static void main(String[] args) {
        // 특수한 형태를 메서드의 파라미터로 전달하거나 메서드 자체를 return 또한 가능하다.
        RunInteger runInteger = (number) -> {
            return number + 10;
        };

        // 입력한 값이 동일한 경우 결과 값이 같아야함. -> 이를 보장해주지 못하면 함수형 프로그래밍이 아니다.
        System.out.println(runInteger.doIt(1)); // 11
        System.out.println(runInteger.doIt(1)); // 11

        System.out.println(runInteger.doIt(2)); // 12
        System.out.println(runInteger.doIt(2)); // 12
        /*
         만약 값을 누군가에게 의존하고 있는 경우 순수한 함수라고 볼 수 없음.
         익명 내부 클래스에서 외부의 값을 변경하려는 경우 또한 순수한 함수라고 볼 수 없음.
         지역 변수를 참조한 경우 값을 변경하지 말고 사용해야한다. final이라고 가정
         순수 함수라면 함수 내부값, 전달 받은 파라미터만 사용해야한다.
         */
    }
}
