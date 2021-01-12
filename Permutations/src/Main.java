
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int [] arrays = {1, 2, 3, 4};
       permutations(arrays);
    }

    private static int [][] insertNumberInArray(int[] arrays, int num) {
        int len = arrays.length+1;
        int len1 = factorial(len);
        int index = 0;
        int [][] arrayOfArrays = new int[len1][len];
        while(index < len1) {
            for (int j = 0; j < len; j++) {
                int[] arr = insertAtIndexInArray(j, arrays, num);
                arrayOfArrays[index] = arr;
                index++;
            }
        }

        return arrayOfArrays;
    }

    private static int[] insertAtIndexInArray(int i, int[] arrays, int num) {
        int [] arr = new int[arrays.length+1];
        arr[i] = num;
        int index = 0;

        for (int j = 0; j <= arrays.length; j++) {
            if(j != i){
                arr[j] = arrays[index++];
            } else {
                arr[j] = num;
            }
        }
        return arr;
    }

    private static void permutations(int[] arr) {

        if(arr.length == 0){
             return;
        }

        int first = arr[0];
        int [] rest =  Arrays.copyOfRange(arr, 1, arr.length);
        permutations(rest);
        int cols = rest.length+1;
        int rows = factorial(cols);
        int [][] arrays = new int[rows][cols];
        arrays = insertNumberInArray(rest, first);
        System.out.println(Arrays.deepToString(arrays));
    }

    private static int factorial(int n) {
        if(n == 0 || n == 1){
            return 1;
        } else {
            return  n * factorial(n-1);
        }
    }
}
