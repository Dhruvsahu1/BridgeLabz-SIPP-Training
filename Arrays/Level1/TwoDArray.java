import java.util.Scanner;
public class TwoDArray
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int arr[][] = new int[row][col];
        int convertArray[] = new int[row*col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int idx = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                convertArray[idx] = arr[i][j];
                idx++;
            }
        }
        for(int i = 0;i<convertArray.length;i++){
            System.out.println("Your array elem = "+ convertArray[i]);
        }
    }
}
