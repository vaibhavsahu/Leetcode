import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [][] arr = {{1,3}};

        int [][] result = mergeIntervals(arr);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] mergeIntervals(int[][] arr) {
        if(arr.length == 1){
            return arr;
        }
        List<int []> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int [] first = arr[i-1];
            if(first[1] >= arr[i][0]){
                int [] temp = new int[2];
                temp[0] = first[0];
                temp[1] = arr[i][1];
                result.add(temp);
                i++;
            } else {
                result.add(arr[i-1]);
                result.add(arr[i]);
            }
        }
       // System.out.println(result);

        //String[][] w = allProducts.toArray(new String[][] {});
        //int [][] output = result.stream().toArray();
        return result.toArray(new int[][] {});
    }
}
