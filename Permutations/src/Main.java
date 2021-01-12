
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        int [] arrays = {1, 2, 3, 4,5};
        System.out.println(permute(arrays));
    }

    private static List<List<Integer>> insertNumberInArray(int[] arrays, int num, List<List<Integer>> list) {
        int len = arrays.length+1;
        int len1 = factorial(len);
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        if(list.isEmpty()){
            result.add(Arrays.asList(num));
        } else {
            for(int k = 0; k < list.size(); k++){
                List<Integer> list1 = null;
                for (int j = 0; j < len; j++) {
                    list1 = insertAtIndexInList(j, list.get(k), num);
                    result.add(index, list1);
                    index++;
                }
            }
        }
        return result;
    }

    private static List<Integer> insertAtIndexInList(int i, List<Integer> list, int num) {
        List<Integer> result = new ArrayList<>();
        int index = 0;

        for (int j = 0; j <= list.size(); j++) {
            if(j != i){
                result.add(j, list.get(index++));
            } else {
                result.add(i, num);
            }
        }
        return result;
    }

    private static List<List<Integer>> permute(int[] arr) {

        if(arr.length == 0){
             return new ArrayList<>();
        }

        int first = arr[0];
        int [] rest =  Arrays.copyOfRange(arr, 1, arr.length);
        List<List<Integer>> list = permute(rest);
        List<List<Integer>> listList = insertNumberInArray(rest, first, list);
        return listList;
    }

    private static int factorial(int n) {
        if(n == 0 || n == 1){
            return 1;
        } else {
            return  n * factorial(n-1);
        }
    }
}
