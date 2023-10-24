package section1.functioninterface.previoussource;

public class FunInterfaceDefault {

    public static void main(String[] args) {
        /*
        // java 8 이전에는 interface를 구현한 클래스를 '내부 익명 클래스' 라고 불렀다.
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };
         */

        // 아래와 같이 람다를 활용할 수 있다.
        RunDefault runDefault = () -> System.out.println("Hello");
        runDefault.doIt();
    }


}
