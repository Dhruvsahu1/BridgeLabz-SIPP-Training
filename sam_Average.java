public class sam_Average {
    public static void main(String[] args) {
        int marks_Math = 94;
        int marks_Physics = 95;
        int marks_Chemistry = 96;
        int total_marks = marks_Math + marks_Physics + marks_Chemistry;
        double average_marks = (double)total_marks/3;
        System.out.println("Sam's average mark in PCM is " + average_marks);
    }
}
