package jan22;

class RBI {

    double simpleInterest(double amount, double time, double rate) {
        return (amount * time * rate) / 100;
    }

    double calculateLoan(double amount) {
        return amount;
    }

    double calculateLoan(double amount, double interest) {
        return amount + (amount * interest / 100);
    }
}

class SBI extends RBI {

    double simpleInterest(double amount, double time, double rate) {
        System.out.println("Welcome To SBI Simple Interest");
        return (amount * time * rate) / 100;
    }
}

class HDFC extends RBI {

    double simpleInterest(double amount, double time, double rate) {
        System.out.println("Welcome To HDFC Simple Interest");
        return (amount * time * rate) / 100;
    }
}

public class Pro6 {
    public static void main(String[] args) {

        RBI rbi = new RBI();
        SBI sbi = new SBI();
        HDFC hdfc = new HDFC();

        //overloading (compile-time polymorphism)
        System.out.println("Loan (amount only): " + rbi.calculateLoan(10000));
        System.out.println("Loan (with interest): " + rbi.calculateLoan(10000, 5));

        //overriding (runtime polymorphism)
        System.out.println("Interest: " + sbi.simpleInterest(10000, 2, 6));
        System.out.println("Interest: " + hdfc.simpleInterest(10000, 2, 7));
    }
}