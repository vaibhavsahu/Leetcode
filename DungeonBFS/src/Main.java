import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        char [][] maze = {{'S', '.', '.', '#', '.', '.', '.'},
                          {'.', '#', '.', '.', '.', '#', '.'},
                          {'.', '#', '.', '.', '.', '.', '.'},
                          {'.', '.', '#', '#', '.', '.', '.'},
                          {'#', '.', '#', 'E', '.', '#', '.'}};


        System.out.println(shortDistance(maze));
    }

    private static int shortDistance(char[][] maze) {

        boolean [][] visited = new boolean[maze.length][maze[0].length];
        int [][] distanceMatrix = new int[maze.length][maze[0] .length];

        int distance = shortDistanceHelper(maze, visited, distanceMatrix);
        return distance;
    }

    private static int shortDistanceHelper(char[][] maze, boolean[][] visited, int [][] distanceMatrix) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int distance = 0;

        queue.add(new Pair<>(0, 0));

        visited[0][0] = true;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> point = queue.remove();

            if(maze[point.getKey()][point.getValue()] == 'E'){
                return distanceMatrix[point.getKey()][point.getValue()];
            }

            List<Pair<Integer, Integer>> neighbors = getNeighbors(maze, visited, distanceMatrix, point.getKey(), point.getValue());

            for(Pair<Integer, Integer> neighbor : neighbors){
                if(visited[neighbor.getKey()][neighbor.getValue()] == false){
                    visited[neighbor.getKey()][neighbor.getValue()] = true;
                    queue.add(neighbor);
                }
            }
        }

        return distance;
    }

    public static List<Pair<Integer, Integer>> getNeighbors(char [][] maze, boolean [][] visited, int [][] distanceMatrix, int i, int j){
        List<Pair<Integer, Integer>> neighbors = new ArrayList<>();

        if(isValidMove(i-1, j, maze, visited)){
            neighbors.add(new Pair<>(i-1, j));
            distanceMatrix[i-1][j] = distanceMatrix[i][j] + 1;
        }

        if(isValidMove(i+1, j, maze, visited)){
            neighbors.add(new Pair<>(i+1, j));
            distanceMatrix[i+1][j] = distanceMatrix[i][j] + 1;
        }

        if(isValidMove(i, j-1,  maze, visited)){
            neighbors.add(new Pair<>(i, j-1));
            distanceMatrix[i][j-1] = distanceMatrix[i][j] + 1;
        }

        if(isValidMove(i, j+1,  maze, visited)){
            neighbors.add(new Pair<>(i, j+1));
            distanceMatrix[i][j+1] = distanceMatrix[i][j] + 1;
        }

        return neighbors;
    }

    private static boolean isValidMove(int i, int j, char [][] grid, boolean [][] visited) {
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && visited[i][j] == false && grid[i][j] != '#'){
            return true;
        }
        return false;
    }
}
