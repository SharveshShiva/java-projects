import java.util.Scanner;
public class StudentMarksManagementSystem {

    public static int calculateTotal(int[] marks) {
        // This is the method for calculating the total marks.

        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum;
    }

    public static double calculateAverage(int sum, int subjects) {
        // This is the method for calculating the average of the total marks.

        double average = 0.0;
        for (int i = 0; i < subjects; i++) {
            average = (double) sum / subjects;
        }
        return average;
    }

    public static String gradeCalculation(int average) {
        // This is the method for the grade calculation based on the average that the students got.

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        // The main method where the heart of the program resides.

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the count of students: ");
        int students = sc.nextInt();
        System.out.print("Enter the count of subject marks: ");
        int subjects = sc.nextInt();

        int[][] student_list = new int[students][subjects];
        String[] name = new String[students];

        // This loop is to get the students names.

        for (int i = 0; i < name.length; i++) {
            System.out.print("Enter the students name: " + (i + 1) + ".");
            name[i] = sc.next();
        }
        // This loop is to get the students marks for the number of subjects they provide.

        for (int i = 0; i < student_list.length; i++) {
            System.out.println("Enter marks of " + name[i] + " for subjects");
            for (int j = 0; j < student_list[i].length; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                student_list[i][j] = sc.nextInt();
            }
        }

        // This part is for asking what the program should do.
        boolean repeat = true;

        while (repeat) {
            System.out.print("What do you want to do: 1 for Display the marks, 2 for calculate (sum, average, Grade), 3 for Display the marks and calculate (sum, average, Grade)");
            int input = sc.nextInt();
            if (input == 1) {
                for (int i = 0; i < student_list.length; i++) {
                    System.out.print("The marks of " + name[i] + " is - ");
                    for (int j = 0; j < student_list[i].length; j++) {
                        if (j == subjects - 1) {
                            System.out.print(student_list[i][j]);
                        } else {
                            System.out.print(student_list[i][j] + ", ");
                        }
                    }
                    System.out.println();
                    repeat = false;
                }
            } else if (input == 3) {
                for (int i = 0; i < student_list.length; i++) {
                    System.out.print("The marks of " + name[i] + " is - ");
                    for (int j = 0; j < student_list[i].length; j++) {
                        if (j == subjects - 1) {
                            System.out.print(student_list[i][j]);
                        } else {
                            System.out.print(student_list[i][j] + ", ");
                        }
                    }
                    System.out.println();
                }

                int times = 3;
                for (int j = 0; j < times; j++) {
                    System.out.println();
                }  // printing 3 new lines for good visual.

                System.out.println("Name" + "     " + "Total" + "     " + "Average" + "     " + "Grade");
                for (int i = 0; i < student_list.length; i++) {
                    String n = name[i];
                    int t = calculateTotal(student_list[i]);
                    double a = calculateAverage(calculateTotal(student_list[i]), subjects);
                    String g = gradeCalculation((int) calculateAverage(calculateTotal(student_list[i]), subjects));
                    System.out.printf("%-10s %-10d %-10.2f %-5s\n",
                            n, t, a, g);
                    repeat = false;
                }

            } else if (input == 2) {
                System.out.println("Name" + "     " + "Total" + "     " + "Average" + "     " + "Grade");
                for (int i = 0; i < student_list.length; i++) {
                    String n = name[i];
                    int t = calculateTotal(student_list[i]);
                    double a = calculateAverage(calculateTotal(student_list[i]), subjects);
                    String g = gradeCalculation((int) calculateAverage(calculateTotal(student_list[i]), subjects));
                    System.out.printf("%-10s %-10d %-10.2f %-5s\n",
                            n, t, a, g);
                }
                repeat = false;
                
            } else {
                System.out.println("Enter a valid number from 1 to 3 for printing results.");
            }
        }
    }
}

