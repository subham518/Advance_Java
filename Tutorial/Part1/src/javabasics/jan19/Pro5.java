package jan19;
import java.util.Arrays;


public class Pro5 {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int n = arr.length;
        int[] output = new int[n * 2];

        for (int i = 0 ; i<n ; i++){
            output[i] = arr[i];
            output[i + n] = arr[i];
        }

        System.out.println(Arrays.toString(output));
    }
}