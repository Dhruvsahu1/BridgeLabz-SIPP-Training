
import java.util.Arrays;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            return sortedArray;
        }

        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] != sortedArray[j]) {
                j++;
                sortedArray[j] = sortedArray[i];
            }
        }

        int[] result = Arrays.copyOf(sortedArray, j + 1);
        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] result = removeDuplicates(sortedArray);

        System.out.println(Arrays.toString(result)); 
    }
}

