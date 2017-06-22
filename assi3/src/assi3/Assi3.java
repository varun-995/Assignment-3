package assi3;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author varunaggarwal
 */
class Student {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

}

public class Assi3 {

    static String[] studentDetails;
    static int i = 0;
    static int size;
    static Student[] students;

    static void formatString(String studentDetail) {
        String delimiter = " ";
        String[] tokens = studentDetail.split(delimiter);
        students[i] = new Student(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
        i++;
    }

    // Main Logic
    // If two student has the same CGPA, then arrange them according to their first name in alphabetical order.
    // If those two students also have the same first name, then order them according to their ID. No two students have the same ID.
    void sort() {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getCgpa() < students[j + 1].getCgpa()) {
                    // Swap on basis of CGPA
                    swap(j, j + 1);

                } else if (students[j].getCgpa() == students[j + 1].getCgpa()) {
                    if (students[j].getName().compareTo(students[j + 1].getName()) > 0) {
                        // Swap on basis of Name
                        swap(j, j + 1);
                    }

                } else if (students[j].getName().compareTo(students[j + 1].getName()) == 0) {
                    if (students[j].getId() > students[j + 1].getId()) {
                        swap(j, j + 1);
                    }
                }
//                else{
//                    // Swap on basis of ID
//                    swap(students[j], students[j + 1]);
//                } 
            }
        }
    }

    void print() {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName());
        }
    }

    void swap(int i, int j) {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }

    public static void main(String[] args) {

        Assi3 assi3 = new Assi3();
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        studentDetails = new String[size];
        students = new Student[size];
        sc.nextLine();

        for (int i = 0; i < size; i++) {
            studentDetails[i] = sc.nextLine();
            formatString(studentDetails[i]);
        }

        assi3.sort();
        System.out.println("\n");
        assi3.print();

    }

}
