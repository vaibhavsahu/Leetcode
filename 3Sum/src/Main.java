import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static List<List<Integer>> listOfThreeSumZero(int [] arr, int sum){

        Map<Integer, Integer> map1 = new HashMap<>();

        Map<Integer, Integer> map2 = new HashMap<>();



        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        list.stream().forEach( e -> map1.put(e, e));

        Set<List<Integer>> listOfList = new HashSet<>();

        for(Integer integer : list){
            if(map2.containsKey(integer)){
                map2.put(integer, map2.get(integer)+1);
            } else {
                map2.put(integer, 1);
            }
        }

        for(int i = 0; i < arr.length; i++){
            int num1 = arr[i];
            for(int j = i; j < arr.length; j++){
                int num2 = arr[j];
                if(map1.containsKey(sum - (num1 + num2))){
                    List<Integer> list1 = new ArrayList<>();
                    if(list.indexOf(num1) != list.indexOf(num2)){
                        list1.add(num1);
                        list1.add(num2);
                        list1.add(sum - (num1 + num2));
                    }
                    Collections.sort(list1);
                    boolean flag = removeDuplicateLists(listOfList, list1);
                    if(!flag && !list1.isEmpty()){
                       listOfList.add(list1);
                    }
                }
            }
            //removeFalsePositives(listOfList, map2);
        }
        return listOfList.stream().collect(Collectors.toList());
    }
//
//    private static void removeFalsePositives(Set<List<Integer>> listOfList, Map<Integer, Integer> map) {
//        List<Integer> list = new ArrayList<>();
//        int index = 0;
//        for(List<Integer> list1: listOfList){
//
//            Map<Integer, Integer> map3 = new HashMap<>();
//            for(Integer integer : list1){
//                if(map3.containsKey(integer)){
//                    map3.put(integer, map3.get(integer)+1);
//                } else {
//                    map3.put(integer, 1);
//                }
//            }
//
//            for(Integer integer : list1){
//                if(map3.containsKey(integer) && map.get(integer) <= map3.get(integer)){
//                   // map3.put(integer, map3.get(integer)+1);
//                    list.add(index);
//                }
//            }
//
//
//
//        }
//    }

    private static boolean removeDuplicateLists(Set<List<Integer>> listOfList, List<Integer> list1) {
        for(List<Integer> list : listOfList){
            if(list1.equals(list)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int [] arr = {-1,0,1,2,-1,-4};

        System.out.println(listOfThreeSumZero(arr, 0));


    }
}
