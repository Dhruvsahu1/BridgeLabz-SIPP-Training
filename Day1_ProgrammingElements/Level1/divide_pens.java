public class divide_pens {
    public static void main(String[] args) {
        int totalPens = 14;
        int totalStudents = 3;
        int pensPerStudent = totalPens / totalStudents;
        int remainingPens = totalPens % totalStudents;
        System.out.println("The pen per Student is "+pensPerStudent+" and the remaining pen not distributed is "+remainingPens);
    }
}
