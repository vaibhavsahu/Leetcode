import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int [] arr1 = {1, 3};
        int [] arr2 = {2};

        System.out.println(medianOfTwoSortedArray(arr1, arr2));
    }

    private static double medianOfTwoSortedArray(int[] arr1, int[] arr2) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((a,b) -> b - a);

        for (int i = 0; i < arr1.length; i++) {
            queue1.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            queue2.add(arr2[i]);
        }

        return (queue1.remove() + queue2.remove())/2.0;
    }
}
