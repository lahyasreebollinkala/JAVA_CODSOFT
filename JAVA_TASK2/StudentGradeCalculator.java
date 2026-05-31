import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StudentGradeCalculator {

    public static String getGrade(double marks) {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("     STUDENT RESULT MANAGEMENT SYSTEM");
        System.out.println("=========================================");

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine();

        String[] subjectNames = new String[subjects];
        int[] marks = new int[subjects];

        int total = 0;
        int highest = -1;
        int lowest = 101;

        String highestSubject = "";
        String lowestSubject = "";

        boolean pass = true;
        int passedSubjects = 0;
        int failedSubjects = 0;

        int aPlusCount = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        for (int i = 0; i < subjects; i++) {

            System.out.print("\nEnter Subject Name " + (i + 1) + ": ");
            subjectNames[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter Marks for " + subjectNames[i] + " (0-100): ");
                marks[i] = sc.nextInt();

                if (marks[i] >= 0 && marks[i] <= 100)
                    break;

                System.out.println("Invalid Input! Enter marks between 0 and 100.");
            }

            sc.nextLine();

            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestSubject = subjectNames[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestSubject = subjectNames[i];
            }

            if (marks[i] >= 35)
                passedSubjects++;
            else {
                failedSubjects++;
                pass = false;
            }

            String grade = getGrade(marks[i]);

            switch (grade) {
                case "A+":
                    aPlusCount++;
                    break;
                case "A":
                    aCount++;
                    break;
                case "B":
                    bCount++;
                    break;
                case "C":
                    cCount++;
                    break;
                case "D":
                    dCount++;
                    break;
                case "F":
                    fCount++;
                    break;
            }
        }

        double average = (double) total / subjects;
        double cgpa = average / 9.5;

        String overallGrade = getGrade(average);

        String performance;

        if (average >= 90)
            performance = "Excellent";
        else if (average >= 75)
            performance = "Very Good";
        else if (average >= 60)
            performance = "Good";
        else if (average >= 40)
            performance = "Average";
        else
            performance = "Needs Improvement";

        String distinction = (average >= 75) ? "YES" : "NO";

        String scholarship =
                (average >= 85 && pass)
                        ? "Eligible"
                        : "Not Eligible";

        String remark;

        if (average >= 90)
            remark = "Outstanding Performance";
        else if (average >= 75)
            remark = "Very Good Performance";
        else if (average >= 60)
            remark = "Good Performance";
        else if (average >= 40)
            remark = "Needs Improvement";
        else
            remark = "Poor Performance";

        double passRate =
                ((double) passedSubjects / subjects) * 100;

        System.out.println("\n=========================================");
        System.out.println("              STUDENT REPORT");
        System.out.println("=========================================");

        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNo);

        System.out.println("\nSUBJECT-WISE RESULTS");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < subjects; i++) {

            double contribution =
                    ((double) marks[i] / total) * 100;

            System.out.printf(
                    "%-15s : %3d Marks | Grade %-2s | Contribution %.2f%%%n",
                    subjectNames[i],
                    marks[i],
                    getGrade(marks[i]),
                    contribution);
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total Marks           : " + total);
        System.out.printf("Average Percentage    : %.2f%%\n", average);
        System.out.println("Overall Grade         : " + overallGrade);
        System.out.printf("Estimated CGPA        : %.2f\n", cgpa);

        System.out.println("Highest Subject       : "
                + highestSubject + " (" + highest + ")");

        System.out.println("Lowest Subject        : "
                + lowestSubject + " (" + lowest + ")");

        System.out.println("Performance Category  : "
                + performance);

        System.out.println("Distinction           : "
                + distinction);

        System.out.println("Scholarship Status    : "
                + scholarship);

        System.out.println("Result Status         : "
                + (pass ? "PASS" : "FAIL"));

        System.out.println("Teacher Remark        : "
                + remark);

        System.out.println("\nGRADE DISTRIBUTION");
        System.out.println("-----------------------------------------");
        System.out.println("A+ Grade Subjects : " + aPlusCount);
        System.out.println("A Grade Subjects  : " + aCount);
        System.out.println("B Grade Subjects  : " + bCount);
        System.out.println("C Grade Subjects  : " + cCount);
        System.out.println("D Grade Subjects  : " + dCount);
        System.out.println("F Grade Subjects  : " + fCount);

        System.out.println("\nCLASS RESULT ANALYSIS");
        System.out.println("-----------------------------------------");
        System.out.println("Total Subjects   : " + subjects);
        System.out.println("Passed Subjects  : " + passedSubjects);
        System.out.println("Failed Subjects  : " + failedSubjects);
        System.out.printf("Pass Rate        : %.2f%%\n", passRate);

        System.out.println("=========================================");

        try {

            FileWriter writer =
                    new FileWriter("StudentReport.txt");

            writer.write("STUDENT REPORT\n");
            writer.write("=================================\n");

            writer.write("Student Name : " + studentName + "\n");
            writer.write("Roll Number  : " + rollNo + "\n\n");

            for (int i = 0; i < subjects; i++) {

                double contribution =
                        ((double) marks[i] / total) * 100;

                writer.write(
                        subjectNames[i]
                                + " : "
                                + marks[i]
                                + " Marks | Grade "
                                + getGrade(marks[i])
                                + " | Contribution "
                                + String.format("%.2f", contribution)
                                + "%\n");
            }

            writer.write("\nTotal Marks : " + total);
            writer.write("\nAverage Percentage : "
                    + String.format("%.2f", average) + "%");

            writer.write("\nOverall Grade : "
                    + overallGrade);

            writer.write("\nCGPA : "
                    + String.format("%.2f", cgpa));

            writer.write("\nHighest Subject : "
                    + highestSubject + " (" + highest + ")");

            writer.write("\nLowest Subject : "
                    + lowestSubject + " (" + lowest + ")");

            writer.write("\nPerformance : "
                    + performance);

            writer.write("\nDistinction : "
                    + distinction);

            writer.write("\nScholarship : "
                    + scholarship);

            writer.write("\nResult Status : "
                    + (pass ? "PASS" : "FAIL"));

            writer.write("\nTeacher Remark : "
                    + remark);

            writer.write("\n\nGRADE DISTRIBUTION");
            writer.write("\nA+ : " + aPlusCount);
            writer.write("\nA  : " + aCount);
            writer.write("\nB  : " + bCount);
            writer.write("\nC  : " + cCount);
            writer.write("\nD  : " + dCount);
            writer.write("\nF  : " + fCount);

            writer.write("\n\nCLASS RESULT ANALYSIS");
            writer.write("\nTotal Subjects : " + subjects);
            writer.write("\nPassed Subjects : " + passedSubjects);
            writer.write("\nFailed Subjects : " + failedSubjects);
            writer.write("\nPass Rate : "
                    + String.format("%.2f", passRate) + "%");

            writer.close();

            System.out.println(
                    "\nReport saved successfully as StudentReport.txt");

        } catch (IOException e) {
            System.out.println("Error saving report file.");
        }

        sc.close();
    }
}