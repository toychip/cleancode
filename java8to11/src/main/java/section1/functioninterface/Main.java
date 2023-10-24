package section1.functioninterface;

public class Main {

    // 생성한 클래스를 실행하는 메인 메서드
    public static void main(String[] args) {

        Foo foo = new DefaultFoo("toychip");
        foo.printName();
        foo.printNameUpperCase();

        // interface의 static 메소드를 사용할 수 있음
        Bar.printBar();
    }

}
