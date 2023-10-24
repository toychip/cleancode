package section1.functioninterface;

public interface FooChild extends Foo {

    // 인터페이스를 상속받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다.
    // FooChild는 printUpperCase 메서드를 제공하고 싶지 않을 때 추상메서드로 선언해주면 된다.
    void printNameUpperCase();
}
