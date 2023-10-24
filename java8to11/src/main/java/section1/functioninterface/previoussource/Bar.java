package section1.functioninterface.previoussource;

public interface Bar {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }

    static void printBar() {
        System.out.println("static BBAARR!!");
    }
}
