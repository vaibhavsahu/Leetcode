import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {4,2,0,3,2,5};

        System.out.println(quantityOfTrappedWater(arr));
    }

    private static int quantityOfTrappedWater(int[] arr) {

        if(arr.length == 0){
            return 0;
        }
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];

        left[0] = 0;

        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(arr[i-1], left[i-1]);
        }

        right[arr.length-1] = 0;

        for (int i = arr.length-2; i >= 0; i--) {
            right[i] = Math.max(arr[i+1], right[i+1]);
        }

        int totalQuantity = 0;

        for (int i = 0; i < arr.length; i++) {
            int quantity = Math.min(left[i], right[i]) - arr[i];
            if(quantity >= 0){
                totalQuantity += quantity;
            }
        }

        return totalQuantity;
    }
}
