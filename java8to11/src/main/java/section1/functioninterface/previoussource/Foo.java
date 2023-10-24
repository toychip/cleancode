package section1.functioninterface.previoussource;

public interface Foo {

    void printName();

    /*
    아래 메서드를 일만 메서드로 선언할 경우 이를 구현한 모든 클래스들에서 오류가 나기 때문에 추가했어야 했는데
    아래와 같이 default를 사용하면 특정한 기능을 제공하면서 직접 안해줘도 된다.

    아래의 메서드가 항상 잘 동작할지 알 수 없음 무슨 값이 올지 모름
    최소한의 노력으로 반드시 문서화를 해야한다. @implSpec 사용
     */

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();
}
