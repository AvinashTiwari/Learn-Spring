package datastruct.recurssive.recursion;

public class recursiveLinear {
    public static void main(String[] args) {
        System.out.println(recursiveLinearSearch(
                new int[]{4,48,4,28,32,76,9,3},
                0,32));
    }



    public static int recursiveLinearSearch(int [] a, int i, int x){
        if(i > a.length -1){
            return  -1;
        }else if (a[i] == x){
            return i;
        } else {
            System.out.println("index at : " + i);
           return recursiveLinearSearch(a,i+1,x);
        }
    }
}
