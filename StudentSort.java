import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + " - " + grade;
    }
}

public class StudentSort {

    public static int compare(Student a, Student b, int by, int order) {
        int result = 0;
        if (by == 1) {
            result = Double.compare(a.grade, b.grade);
        } else if (by == 2) {
            result = a.name.compareToIgnoreCase(b.name);
        }
        return (order == 1) ? result : -result;
    }

    // Insertion Sort
    public static void insertionSort(Student[] arr, int by, int order) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Student key = arr[i];
            int j = i - 1;
            while (j >= 0 && compare(arr[j], key, by, order) > 0) {
                arr[j + 1] = arr[j]; 
                j--;
            }
            arr[j + 1] = key; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many Students?: ");
        int count = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter Details for Student No. " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(name, grade);
        }

        System.out.println("\nSort by: ");
        System.out.println("[1] Grade");
        System.out.println("[2] Name");
        System.out.print("Choice: ");
        int sortBy = sc.nextInt();
        sc.nextLine();

        System.out.println("\nSort Order: ");
        System.out.println("[1] Ascending");
        System.out.println("[2] Descending");
        System.out.print("Choice: ");
        int sortOrder = sc.nextInt();
        sc.nextLine();

        insertionSort(students, sortBy, sortOrder);

        System.out.println("\nSorted Student List:");
        for (Student s : students) {
            System.out.println(s);
        }

        sc.close();
    }
}
