package bizzbuzz;

public class FizzBuzzSolTwo {
    public static void main(String[] args) {
        for (int i=1; i<=100; i++) {
            fizzBuzz(i);
        }
    }
    private static void fizzBuzz(int num)
    {
        for (int i = 1; i <= num; i++)
        {
            if (((i % 3) == 0) && ((i % 5) == 0)) // Is it a multiple of 3 & 5?
                System.out.println("fizzbuzz");
            else if ((i % 3) == 0) // Is it a multiple of 3?
                System.out.println("fizz");
            else if ((i % 5) == 0) // Is it a multiple of 5?
                System.out.println("buzz");
            else
                System.out.println(i); // Not a multiple of 3 or 5
        }
    }
}
