import java.util.Scanner;
public class comparisonAgeAndHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        int[] height = new int[3];
        System.out.println("Enter the age here");
        for(int i = 0;i<3;i++){
            age[i]=  sc.nextInt();
        }
        System.out.println("Enter the height here");
        for(int i = 0;i<3;i++){
            height[i]=  sc.nextInt();
        }
        int min  = age[0];
        int max = height[0];
        for(int i = 1;i<3;i++){
            if(age[i]<min){
                min = age[i];
            }
            if(height[i]>max){
                max = height[i];
            }
        }
        System.out.println("The youngest age is "+min + " and the tallest height is "+max);
    }
}
