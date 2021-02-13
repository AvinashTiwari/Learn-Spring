package datastruct.adt;

public class App {
    public static void main(String[] args) {
        Counter myCounter = new Counter("test");
        myCounter.increment();
        myCounter.increment();

        System.out.println(myCounter.toString());
    }
}
