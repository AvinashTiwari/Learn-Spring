package capitalize;

public class capitalizesolOne {
    public static void main(String[] args) {
        SolOne();
    }

    static void SolOne(){
        String str = "hello world!";

// capitalize first letter
        String output = str.substring(0, 1).toUpperCase() + str.substring(1);

// print the string
        System.out.println(output);
    }
}
