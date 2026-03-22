package jan21;


public class Pro2 {
    static void main(String[] args) {


        for (int i = 1; i < 6; i++) {
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
        for (int i = 4; i>0; i--){ // if i = 4
            for (int j =0 ; j < i ; j++){
                System.out.print("* ");
            }
            for (int j = 4 ; j >= i ; j--){
               System.out.print("  ");
            }
            for (int j = 4 ; j >= i ; j--) {
                System.out.print("  ");
            }
            for (int j =0 ; j < i ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}