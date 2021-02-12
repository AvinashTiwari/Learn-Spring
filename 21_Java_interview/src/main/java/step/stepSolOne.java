package step;

public class stepSolOne {
    public static void main(String[] args) {
        step();
    }
    public static void step(){
        for (int i = 0; i < 10; ++ i) {
           if(i>0) {
               System.out.print("'");
           }
            for (int j = 1; j <= i; ++j) {
                System.out.print("#");
            }
            for (int k = 8 -i ; k >= 0; --k) {
                System.out.print(" ");
            }
            if(i>0) {
                System.out.print("'");
            }
            System.out.println();

        }
    }
}
