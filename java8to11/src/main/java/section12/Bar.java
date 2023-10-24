package section12;

public interface Bar {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }

    static void printBar() {
        System.out.println("static BBAARR!!");
    }
}
