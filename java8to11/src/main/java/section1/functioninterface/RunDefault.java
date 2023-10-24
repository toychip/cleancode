package section1.functioninterface;

@FunctionalInterface
public interface RunDefault {

    // 추상 메서드가 하나면 함수형 인터페이스라고 부른다. (2개가 있으면 안됨)
    void doIt();
    /*
    abstract 가 생략되어 있는 것이다.
    abstract void doIt();
     */

    static void printName() {
        System.out.println("print!");
    }

    default void printAge() {
        System.out.println("40");
    }

    /*
    이렇게 다른 형태의 2가지 메서드가 있어도, 추상 메서드가 1개이므로 이것은 여전히 함수형 인터페이스이다.

    @FunctionalInterface를 사용하면 인터페이스가 함수형 인터페이스임을 명시적으로 표시한다.
    직접 사용하게 되면 추상 메서드가 하나만 존재하는지 검사한다.

     */

}
