import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Character> buildMap(String [] words){

        Pair<Map<Character, Integer>, Map<Character, Character>> graphAndIndegreeMap = initializeGraph(words);
        Map<Character, Integer> inDegreeMap = graphAndIndegreeMap.getKey();
        Map<Character, Character> graph = graphAndIndegreeMap.getValue();

        for (int i = 0; i < words.length; i++) {
            if(i+1 >= words.length){
                break;
            }
            String s1 = words[i];
            String s2 = words[i+1];

            int len = s1.length() < s2.length() ? s1.length() : s2.length();

            for(int j = 0; j < len; j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(s1.charAt(j) == s2.charAt(j)){
                    continue;
                } else {
                    if(inDegreeMap.containsKey(c2)){
                        inDegreeMap.put(c2, inDegreeMap.get(c1)+1);
                    } else {
                        inDegreeMap.put(c2, 1);
                    }
                    graph.put(c1, c2);
                    break;
                }
            }
        }

       List<Character> topSort = runTopologicalSort(graph, inDegreeMap);
        return topSort;
    }

    private static Pair<Map<Character, Integer>, Map<Character, Character>> initializeGraph(String[] words) {
        Map<Character, Integer> inDegreeMap = new HashMap<>();
        Map<Character, Character> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(i+1 >= words.length){
                break;
            }
            String s1 = words[i];
            String s2 = words[i+1];

            int len = s1.length() < s2.length() ? s1.length() : s2.length();

            for(int j = 0; j < len; j++){
                graph.putIfAbsent(s1.charAt(j), ' ');
                graph.putIfAbsent(s2.charAt(j), ' ');
                inDegreeMap.putIfAbsent(s1.charAt(j), 0);
                inDegreeMap.putIfAbsent(s2.charAt(j), 0);
            }
        }
        return new Pair<>(inDegreeMap, graph);
    }

    private static List<Character> runTopologicalSort(Map<Character, Character> graph, Map<Character, Integer> inDegreeMap) {
        List<Character> topologicalSortedList = new ArrayList<>();
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Boolean> visitedMap = new HashMap<>();

//        for(char c : inDegreeMap.keySet()){
//            visitedMap.put(c, false);
//        }


        for(char c : inDegreeMap.keySet()){
            if(inDegreeMap.get(c) == 0){
                queue.add(c);
            }
        }

        while (!queue.isEmpty()){
            char c = queue.remove();
            topologicalSortedList.add(c);
           // visitedMap.put(c, true);

            char edge = graph.get(c);

           // for(char neighbor : neighbors){
//                if(visitedMap.containsKey(edge) ){
//                    visitedMap.put(edge, true);
                    //if(inDegreeMap.containsKey(edge)){
                        inDegreeMap.put(edge, inDegreeMap.get(edge)-1);
                   // }
                    if(inDegreeMap.get(edge) == 0 ){
                        queue.add(edge);
                    }
                //}
           // }

        }

    return topologicalSortedList;

    }


    public static void main(String[] args) {
        String [] words = {"wrt","wrf","er","ett","rftt"};

        System.out.println(buildMap(words));


    }
}
