package org.example;
import java.util.*;

public class Main{

    static class Student {
        String name;
        int score;
        char grade;

        public Student(String name, int score, char grade) {
            this.name = name;
            this.score = score;
            this.grade = grade;
        }
        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public char getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int numberOfStudents = 0;
        double totalScore = 0;

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        int highestScore = -1;
        List<String> topStudentsNames = new ArrayList<>();

        System.out.println("--- Student Grade Analyzer ---");

        System.out.print("Enter number of students: ");
        numberOfStudents = scanner.nextInt();
        if (numberOfStudents <= 0) {
            System.out.println("Please enter a positive number of students.");
            scanner.close();
            return;
        }
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter score for " + name + ": ");
            int score = scanner.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("Invalid Score. Try again.");
                scanner.close();
                return;
            }
            scanner.nextLine();

            char grade = calculateLetterGrade(score);
            totalScore += score;

            students.add(new Student(name, score, grade));

            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
                case 'F': countF++; break;
            }

            if (score > highestScore) {
                highestScore = score;
                topStudentsNames.clear();
                topStudentsNames.add(name + " (" + score + ")");
            } else if (score == highestScore && highestScore != -1) {
                topStudentsNames.add(name + " (" + score + ")");
            }

            System.out.println(name + " got grade: " + grade);
        }

        System.out.println("\n------- Class Summary -------");

        if (numberOfStudents > 0) {
            double classAverage = totalScore / numberOfStudents;
            System.out.printf("Average Score: %.2f\n", classAverage);
        } else {
            System.out.println("Average Score: 0.00 (No students entered)");
        }

        System.out.println("Grade Counts: A:" + countA + " B:" + countB + " C:" + countC + " D:" + countD + " F:" + countF);

        System.out.print("Top Student(s): ");
        if (topStudentsNames.isEmpty()) {
            System.out.println("N/A");
        } else {
            System.out.println(String.join(", ", topStudentsNames));
        }

        scanner.close();
    }

    public static char calculateLetterGrade(int score) {
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80 && score <= 89) {
            return 'B';
        } else if (score >= 70 && score <= 79) {
            return 'C';
        } else if (score >= 60 && score <= 69) {
            return 'D';
        } else {
            return 'F';
        }

    }
}
