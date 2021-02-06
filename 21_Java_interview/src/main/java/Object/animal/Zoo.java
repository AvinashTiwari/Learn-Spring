package Object.animal;

public class Zoo {
    public static void main(String[] args) {
        Animal animal1 = new Animal(12, "M", 23);
        animal1.eat();

        Bird bird = new Bird();
        bird.fly();
    }
}
