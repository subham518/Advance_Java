package jan22;


public class Pro1 {
    public static void main(String[] args) {
        String s = "subham89388";
        int count = 0;

        for (int i=0 ; i < s.length(); i++){
             char ch = s.charAt(i);
             if (Character.isDigit(ch)){
                 count += 1;
             }
        }
        System.out.println(count);

        for ( char c : s.toCharArray()){
            if (Character.isDigit(c)){
                count += 1;
            }
        }
        System.out.println(count / 2);

    }
}

// count digits in a string.
