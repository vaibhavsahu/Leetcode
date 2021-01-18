import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] nums = {1,3,5,4,7};
        System.out.println(longestLIS(nums));


    }

    public static int longestLIS(int [] nums){
        int [] result = new int[nums.length];
        int [] count = new int[nums.length];
        Arrays.fill(result, 1);
        Arrays.fill(count, 1);
        List<List<Integer>> listList = new ArrayList<>();




        for(int i = 1; i < nums.length; i++){

            for(int j = 0; j < nums.length; j++){
                // when  i == j reset j, and increment i
                if(i == j){

                    break;
                }

                // if number at j is less than number at i, take max from result array
                // at j and add 1 and check with result at index i
                if(nums[i] > nums[j]){
                    result[i] = Math.max(1+result[j], result[i]);
                   // count[i] = count[j];
                }
//                if(result[i] == result[j]){
//                    count[i] += count[j];
//                }
            }
        }

      System.out.println(Arrays.toString(count));

        System.out.println(Arrays.toString(result));


        return Arrays.stream(result).boxed().max(Integer::compareTo).get();
    }
}
