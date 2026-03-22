package jan22;

public class Pro5 {
    public static void main(String[] args) {
        String s = "radar";

        String rs = new StringBuilder(s).reverse().toString();


        if (s.equals(rs)){
            System.out.println("Pallindrome.");
        }else{
            System.out.println("Not Pallindrome.");
        }
    }
}

// check if string is palindrome