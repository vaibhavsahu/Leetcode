import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(subSets(arr));
    }

    private static List<List<Integer>> subSets(int[] arr) {
        if(arr.length == 0){
            return new ArrayList<>();
        }

        int first = arr[0];
        int [] rest = Arrays.copyOfRange(arr, 1, arr.length);
        List<List<Integer>> listListWithoutFirst = subSets(rest);

        List<List<Integer>> listListWithFirst = generateSubSetsWithFirst(first, listListWithoutFirst);


        List<List<Integer>> result = new ArrayList<>();
        if(listListWithoutFirst.isEmpty()){
            result.add(new ArrayList<>());
        }
        listListWithoutFirst.stream().forEach( e -> result.add(e));
        listListWithFirst.stream().forEach( e -> result.add(e));

        return result;
    }

    private static List<List<Integer>> generateSubSetsWithFirst(int first,
                                                                List<List<Integer>> listListWithoutFirst) {
        List<List<Integer>> listListWithFirst = new ArrayList<>();
        if(listListWithoutFirst.isEmpty()){
            listListWithFirst.add(Arrays.asList(first));
        } else {
            for (int i = 0; i < listListWithoutFirst.size(); i++) {
                if(listListWithoutFirst.get(i).isEmpty()) {
                    listListWithFirst.add(Arrays.asList(first));
                } else {
                    List<Integer> list1 = new ArrayList<>();
                    list1.addAll(listListWithoutFirst.get(i));
                    list1.add(first);
                    listListWithFirst.add(list1);
                }
            }
        }
        return listListWithFirst;
    }
}
