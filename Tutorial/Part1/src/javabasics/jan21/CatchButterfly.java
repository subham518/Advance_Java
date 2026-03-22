package jan21;
import java.util.Random;
import java.util.Scanner;

public class CatchButterfly {

    static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int count = 0;

        Random random = new Random();
        int n = random.nextInt(16);
//        System.out.println(n);
        char ch = 'y';

        while (ch == 'y' || ch == 'Y') {
            count = count + 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("* ");
                }
                for (int j = 4; j >= i; j--) {
                    System.out.print("  ");
                }
                for (int j = 4; j >= i; j--) {
                    System.out.print("  ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            for (int i = n - 2; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print("* ");
                }
                for (int j = 4; j >= i; j--) {
                    System.out.print("  ");
                }
                for (int j = 4; j >= i; j--) {
                    System.out.print("  ");
                }
                for (int j = 0; j < i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            if (n == 6) {
                System.out.println("You got the perfect Butterfly !!");
                System.out.println("Your steps: " + count);
                return;
            }
            System.out.println();
            System.out.println("Want to see more patters (y or n): ");
            ch = s.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                n = random.nextInt(16);
            }
        }
        s.close();
    }
}