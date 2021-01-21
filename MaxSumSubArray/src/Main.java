import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSumSubArray(arr));
    }

    private static int maxSumSubArray(int[] arr) {

        if(arr.length == 1){
            return arr[0];
        }

        int [] result =  new int[arr.length];
        result[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result[i] = Math.max(result[i-1]+arr[i], arr[i]);
        }

        return Arrays.stream(result).boxed().max(Integer::compareTo).get();
    }
}
