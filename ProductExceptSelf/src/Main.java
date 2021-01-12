import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4};
        System.out.println(productExceptSelf(array));
    }

    private static int [] productExceptSelf(int[] array) {
        int [] result = new int[array.length];
        int [] left = new int[array.length];
        int [] right = new int[array.length];

        Arrays.fill(result, 1);
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);



        for (int i = 0; i < array.length; i++) {
            if(i == 0){
                left[i] = array[i];
            } else {
                left[i] = left[i-1]*array[i];
            }
        }

        for (int i = array.length-1; i >= 0; i--) {
            if(i == array.length-1){
                right[i] = array[i];
            } else {
                right[i] = right[i+1]*array[i];
            }
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        for (int i = 0; i < array.length; i++) {
            if(i==0){
                result[i] = right[1];
            } else if(i == array.length-1){
                result[i] = left[array.length-2];
            } else{
                result[i] = left[i-1]*right[i+1];
            }
        }

        return result;

    }
}
