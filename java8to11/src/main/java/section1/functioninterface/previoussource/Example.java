package section1.functioninterface.previoussource;

public class Example implements Bar, Foo{
    @Override
    public void printName() {

    }

    @Override
    public String getName() {
        return null;
    }

    // Bar와 Foo 에 있는 printNameUpperCase()가 충돌 남. 이 때 오버라이드를 해주지 않으면 컴파일 에러가 남
    @Override
    public void printNameUpperCase() {
        Bar.super.printNameUpperCase();
    }
}
