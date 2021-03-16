package datastruct.quicksort;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] inputArray = {12,81,74,43,1098,0,8,02,17,754,912,0,6,4};
        quickSort(inputArray,0, inputArray.length -1);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void quickSort(int[] inputArray, int start, int end) {
      if(start < end){
          int pp = parition(inputArray, start,end);
          quickSort(inputArray, start,pp-1);
          quickSort(inputArray, pp+1,end);
      }
    }

    private static int parition(int[] inputArray, int start, int end) {
        int pivot = inputArray[end];
        int i = start -1;

        for(int j = start; j <= end-1;j++){
            if(inputArray[j] <= pivot){
                i++;
                int ival = inputArray[i];
                int jval = inputArray[j];
                inputArray[i] = jval;
                inputArray[j] = ival;
            }
        }
        int ival = inputArray[i+1];
        inputArray[end] = ival;
        inputArray[i+1] = pivot;
     return i+1;
    }
}
