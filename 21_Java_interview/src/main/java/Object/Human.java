package Object;

public class Human {
    String name;
    int age;
    int heightInches;
    String eyeColor;

    public void speak(){
        System.out.println("Hello my name is " + name);
        System.out.println("My height is " + heightInches);
        System.out.println("My age is " + age);
        System.out.println("My eye color is " + eyeColor);
    }

    public void eat(){
        System.out.println("Eating");
    }
    public void walk(){
        System.out.println("Walk");
    }
    public void work(){
        System.out.println("Work");
    }

    public Human( ) {

    }
}
