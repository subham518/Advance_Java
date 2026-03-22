package jan22;


public class Pro2 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("radar");

        StringBuilder rs = new StringBuilder();
        rs.append(s.reverse());

        System.out.println(rs);

    }
}

// reverse a string using StringBuilder