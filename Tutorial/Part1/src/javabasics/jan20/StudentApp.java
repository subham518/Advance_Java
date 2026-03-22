// Mini Project:
// Student Record Analyzer(Console Based Java Project)
//  stores student records
// uses arraylist and objects
// accepts user input
// performs basic analytics.
package jan20;
import java.util.ArrayList;
import java.util.Scanner;


class Student {
    String name;
    String rollNo;   // mix of int and char
    double marks;

    Student(String name, String rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No: " + rollNo +
                ", Name: " + name +
                ", Marks: " + marks);
    }
}


public class StudentApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            String rollNo = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine(); // consume newline

            Student s = new Student(name, rollNo, marks);
            students.add(s);
        }

        // Display all students
        System.out.println("\nAll Students: ");
        for (Student s : students) {
            s.display();
        }

        // Find highest marks
        Student topper = students.get(0);
        for (Student s : students) {
            if (s.marks > topper.marks) {
                topper = s;
            }
        }

        System.out.println("\nHighest Marks:");
        topper.display();

        // Calculate average marks
        double sum = 0;
        for (Student s : students) {
            sum += s.marks;
        }

        double average = sum / students.size();
        System.out.println("\nAverage Marks: " + average);

        // Object reference behavior
//        System.out.println("\nObject Reference Behavior: ");
//        Student ref = students.get(0);
//        ref.marks += 5;
//
//        System.out.println("After modifying marks using reference:");
//        students.get(0).display();

        sc.close();
    }
}
