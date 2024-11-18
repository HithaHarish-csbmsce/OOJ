package CIE;

import java.util.Scanner;

public class Student {
    public String USN;
    public String Name;
    public int sem;
    public int[] Marks = new int[5];

    // Constructor to initialize student details
    public Student(String USN, String Name, int sem) {
        this.USN = USN;
        this.Name = Name;
        this.sem = sem;
    }
}
package SEE;

import java.util.Scanner;

public class External extends CIE.Student {
    public int[] externalMarks = new int[5];

    public External(String USN, String Name, int sem) {
        super(USN, Name, sem);
    }

    // Method to input external marks
    public void setMarks() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the external marks of 5 subjects:");
        for (int i = 0; i < 5; i++) {
            externalMarks[i] = input.nextInt();
        }
    }
}
import CIE.Student;
import SEE.External;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = input.nextInt();

        External[] students = new External[n];

        // Input details for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Enter USN, Name, and Semester:");
            String USN = input.next();
            String Name = input.next();
            int sem = input.nextInt();

            students[i] = new External(USN, Name, sem);

            // Input internal marks
            System.out.println("Enter the internal marks of 5 subjects:");
            for (int j = 0; j < 5; j++) {
                students[i].Marks[j] = input.nextInt();
            }

            // Input external marks
            students[i].setMarks();
        }

        // Calculate and display final marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent Details:");
            System.out.println("USN: " + students[i].USN);
            System.out.println("Name: " + students[i].Name);
            System.out.println("Semester: " + students[i].sem);

            System.out.println("Final Marks (Internal + External):");
            for (int j = 0; j < 5; j++) {
                int finalMark = students[i].Marks[j] + students[i].externalMarks[j];
                System.out.println("Subject " + (j + 1) + ": " + finalMark);
            }
        }
    }
}
