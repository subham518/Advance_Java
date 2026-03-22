package jan19;

public class Pro3 {
    public static void main(String[] args) {
        int a = 15;
        int rev = 0;
        while(a > 0){
            int temp = a % 10;
            rev = (rev*10) + temp;
            a /= 10;
        }
        System.out.println("Reverse no. is: "+ rev);
    }
}
