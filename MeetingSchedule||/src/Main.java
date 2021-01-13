import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //[7,10],[2,4]]
        int [][] schedules = {{7, 10},{2, 4}};

        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getValue));

        for(int i = 0; i < schedules.length; i++){
            int [] arr = schedules[i];
            Pair<Integer, Integer> pair = new Pair<>(arr[0],arr[1]);
            pairs.add(pair);
        }

        Collections.sort(pairs, Comparator.comparing(Pair::getKey));

        queue.add(new Pair<>(pairs.get(0).getKey(), pairs.get(0).getValue()));
        for(int i = 1; i < pairs.size(); i++){
            Pair<Integer, Integer> current = pairs.get(i);
            if(current.getKey() < queue.peek().getValue()){
                queue.add(current);
            } else {
                if(current.getKey() >= queue.peek().getValue()){
                    queue.poll();
                    queue.add(current);
                }
            }
        }
        System.out.println(queue.size());
    }
}
