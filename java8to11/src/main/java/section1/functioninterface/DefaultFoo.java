package section1.functioninterface;

public class DefaultFoo implements Foo{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public void printNameUpperCase() {
        System.out.println("재정의 가능!");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
