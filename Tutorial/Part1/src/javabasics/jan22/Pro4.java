package jan22;

import java.util.Arrays;

public class Pro4 {
    public static void main(String[] args) {
        int[] arr = {24,2,4,5,78};
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);

//        int max = arr[0];
//        for( int c: arr){
//            if(c > max ){
//                max = c;
//            }
//        }
//        System.out.println(max);
    }
}

// find maximum element in array