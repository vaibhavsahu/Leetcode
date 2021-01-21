import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr = {-2,3,-4};
        //[-2,3,-4]
        // -2, -6, 24
        // -2, 3, 3
        System.out.println(maxProductSubArray(arr));
    }

    private static int maxProductSubArray(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }

        int [] result1 =  new int[arr.length];
        int [] result2 =  new int[arr.length];
        result1[0] = arr[0];
        result2[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result2[i] = Math.min(result1[i-1]*arr[i], Math.min(arr[i], result2[i-1]*arr[i]));
            result1[i] = Math.max(result1[i-1]*arr[i], Math.max(arr[i], result2[i-1]*arr[i]));
        }
        //System.out.println(Arrays.toString(result2));

        return Arrays.stream(result1).boxed().max(Integer::compareTo).get();
    }

}
