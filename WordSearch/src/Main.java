import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        char [][] matrix = {{'a','b'},
                            {'c','d'}};
        String [] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};

        List<String> foundWords = findWords(matrix, words);
        System.out.println(foundWords);

    }

    private static List<String> findWords(char[][] matrix, String[] words) {
        List<String> foundWords = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            boolean found = findWord(matrix, word);
            if(found){
                foundWords.add(word);
            }
        }
        return foundWords;
    }

    private static boolean findWord(char[][] matrix, String word) {
        List<Pair<Integer, Integer>> indices = findFirstCharOccurrences(matrix, word.charAt(0));
        if(indices.isEmpty()){
            return false;
        }
        boolean found = false;
        for(Pair<Integer, Integer> index: indices){
            boolean [][] visited = new boolean[matrix.length][matrix[0].length];
           found  = findWordHelper(matrix, index, word, visited);
           if(found){
               return true;
           }
        }

        return false;
    }

    private static boolean findWordHelper(char[][] matrix, Pair<Integer, Integer> index,
                                          String word, boolean[][] visited) {

        boolean found = false;

        if(matrix.length == 1 &&  word.length() == 1){
            if(matrix[index.getKey()][index.getValue()] == word.charAt(0)){
                return true;
            }
        }

        if(word.length() == 1 && matrix[index.getKey()][index.getValue()] == word.charAt(0)){
            return true;
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.add(index);

        visited[index.getKey()][index.getValue()] = true;

        int counter = 1;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> pair = queue.remove();

            List<Pair<Integer, Integer>> neighbors = getNeighbors(matrix, pair, visited);

            for(Pair<Integer, Integer> neighbor : neighbors){
                if(visited[neighbor.getKey()][neighbor.getValue()] == false){
                    if(matrix[neighbor.getKey()][neighbor.getValue()] == word.charAt(counter)) {
                        visited[neighbor.getKey()][neighbor.getValue()] = true;
                        if(counter == word.length()-1){
                            found = true;
                        } else {
                            queue.add(new Pair<>(neighbor.getKey(), neighbor.getValue()));
                            counter++;
                        }
                        break;
                    }
                }
            }
            if(found){
                break;
            }
        }

        return found;
    }

    private static List<Pair<Integer, Integer>> getNeighbors(char[][] matrix, Pair<Integer, Integer> index,
                                                             boolean[][] visited) {

        List<Pair<Integer, Integer>> neighbors = new ArrayList<>();
        int i = index.getKey();
        int j = index.getValue();


        if(isValid(matrix, i-1, j, visited)){
            neighbors.add(new Pair<>(i-1, j));
        }

        if(isValid(matrix, i+1, j, visited)){
            neighbors.add(new Pair<>(i+1, j));
        }

        if(isValid(matrix, i, j-1, visited)){
            neighbors.add(new Pair<>(i, j-1));
        }

        if(isValid(matrix, i, j+1, visited)){
            neighbors.add(new Pair<>(i, j+1));
        }

        return neighbors;

    }

    private static boolean isValid(char[][] matrix, int i, int j, boolean[][] visited) {
        if(i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0 && visited[i][j] == false){
            return true;
        }
        return false;
    }


    private static List<Pair<Integer, Integer>> findFirstCharOccurrences(char[][] matrix, char charAt) {
        List<Pair<Integer, Integer>> occurrences = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(charAt == matrix[i][j]){
                    occurrences.add(new Pair<>(i, j));
                }
            }
        }
        return occurrences;
    }


}
