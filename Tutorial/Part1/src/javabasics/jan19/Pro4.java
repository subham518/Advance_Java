package jan19;

public class Pro4 {
    public static void main(String[] args) {
        int[] arr = {12,25,31,56,74,89};
        int max = arr[0];
        int second_max = arr[0];

        for (int j : arr){
            if (j > max) {
                max = j;
            }
        }
        for (int j : arr){
            if( j > second_max &&  max > j){
                second_max = j;
            }
        }
        System.out.println("Biggest Number is : "+ max);
        System.out.println("Second Biggest Number is : "+ second_max);

    }
}

