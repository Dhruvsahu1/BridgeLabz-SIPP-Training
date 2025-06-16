
import java.util.Scanner;

public class bonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] time = new double[10];
        double[] newSalarie = new double[10];
        double[] bonus = new double[10];
        int totalBonus = 0;
        int OldSalary = 0;
        int newSalary = 0;

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            salaries[i] = sc.nextDouble();
            time[i] = sc.nextDouble();
            if (salaries[i] <= 0 || time[i] < 0) {
                System.out.println("Invalid input");
                idx--;
            }
            idx++;
        }
        for (int i = 0; i < 10; i++) {
            if (time[i] > 5) {
                bonus[i] = (5 * salaries[i]) / 100;
                newSalarie[i] = salaries[i] + bonus[i];
                totalBonus += bonus[i];
            } else {
                bonus[i] = (2 * salaries[i]) / 100;
                newSalarie[i] = salaries[i] + bonus[i];
                totalBonus += bonus[i];
            }
            OldSalary += salaries[i];
            newSalary += newSalarie[i];
        }
        System.out.println("The total bonus payOut is "+totalBonus +" and the total old Salary is "+ OldSalary+" and the total new Salary is "+newSalary);
    }
}
