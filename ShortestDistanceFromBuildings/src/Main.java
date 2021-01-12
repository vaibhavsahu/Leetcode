import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //int [][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};

        //[[1,1,1,1,1,0],[0,0,0,0,0,1],[0,1,1,0,0,1],[1,0,0,1,0,1],[1,0,1,0,0,1],[1,0,0,0,0,1],[0,1,1,1,1,0]]
        int [][] grid = {{1,1,1,1,1,0},
                         {0,0,0,0,0,1},
                         {0,1,1,0,0,1},
                         {1,0,0,1,0,1},
                         {1,0,1,0,0,1},
                         {1,0,0,0,0,1},
                         {0,1,1,1,1,0}};
        System.out.println(shortestDistance(grid));


    }

    public static int shortestDistance(int [][] grid){

        List<Pair<Integer, Integer>> buildings = new ArrayList<>();
        List<Pair<Integer, Integer>> walls = new ArrayList<>();

        if(grid.length == 1){
            if(grid[0].length <= 1)
            return -1;
        }

        if(!noZerosAvailable(grid)){
            return -1;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    buildings.add(new Pair(i, j));
                }
                if(grid[i][j] == 2){
                    walls.add(new Pair(i, j));
                }
            }
        }

        List<Integer> shortDistance = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 1 && grid[i][j] != 2){

                    int result = shortDistanceHelper(grid, buildings, walls, i, j);
                    shortDistance.add(result);
                }
            }
        }

        List<Integer> numberOfUnreachablePaths = shortDistance.stream().filter( i -> i <= 0).collect(Collectors.toList());
        if(numberOfUnreachablePaths.size() > 1){
            return shortDistance.stream().filter( i -> i >= 0).min((i, j) -> i.compareTo(j)).get();
        } else {
            return shortDistance.stream().min((i, j) -> i.compareTo(j)).get();
        }
    }

    private static boolean noZerosAvailable(int[][] grid) {
        boolean isZeroAvailable = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                   isZeroAvailable = true;
                }
            }
        }
        return isZeroAvailable;
    }

    private static int shortDistanceHelper(int[][] grid, List<Pair<Integer, Integer>> buildings,
                                           List<Pair<Integer, Integer>> walls, int i, int j) {
        int distance = 0;

            Pair<Integer, Integer> start = new Pair<>(i, j);
            for(Pair<Integer, Integer> list: buildings){
                Pair<Integer, Integer> goal = new Pair<>(list.getKey(), list.getValue());
                int tempDistance = calculateDistance(grid, start, goal, walls);
                if(tempDistance <= 0){
                    return -1;
                }
                distance += tempDistance;
            }
            return distance;
        }

    private static int calculateDistance(int[][] grid, Pair<Integer, Integer> start,
                                         Pair<Integer, Integer> goal,
                                         List<Pair<Integer, Integer>> walls) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int [][] distanceMatrix = new int[grid.length][grid[0] .length];

        queue.add(start);

        visited[start.getKey()][start.getValue()] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> point = queue.remove();

            if(point.getKey() == goal.getKey() && point.getValue() == goal.getValue()){
                return distanceMatrix[point.getKey()][point.getValue()];
            }

            List<Pair<Integer, Integer>> neighbors = getNeighbors(grid, visited, distanceMatrix, point.getKey(), point.getValue());

            for(Pair<Integer, Integer> neighbor : neighbors){
                if(visited[neighbor.getKey()][neighbor.getValue()] == false){
                    visited[neighbor.getKey()][neighbor.getValue()] = true;
                    queue.add(neighbor);
                }
            }
        }
        return -1;

    }

    private static List<Pair<Integer, Integer>> getNeighbors(int[][] grid, boolean[][] visited,
                                                             int[][] distanceMatrix,
                                                             int i, int j) {


        List<Pair<Integer, Integer>> neighbors = new ArrayList<>();

            if(grid[i][j] == 1){
                return neighbors;
            }


        if(isValidMove(grid, visited, i-1, j)){
            neighbors.add(new Pair<>(i-1, j));
            if(grid[i][j] != 1){
                distanceMatrix[i-1][j] = distanceMatrix[i][j]+1;
            }
        }

        if(isValidMove(grid, visited, i+1, j)){
            neighbors.add(new Pair<>(i+1, j));
            if(grid[i][j] != 1) {
                distanceMatrix[i + 1][j] = distanceMatrix[i][j] + 1;
            }
        }

        if(isValidMove(grid, visited, i, j-1)){
            neighbors.add(new Pair<>(i, j-1));
            if(grid[i][j] != 1) {
                distanceMatrix[i][j - 1] = distanceMatrix[i][j] + 1;
            }
        }

        if(isValidMove(grid, visited, i, j+1)){
            neighbors.add(new Pair<>(i, j+1));
            if(grid[i][j] != 1) {
                distanceMatrix[i][j + 1] = distanceMatrix[i][j] + 1;
            }
        }

        return neighbors;
    }

    private static boolean isValidMove(int[][] grid, boolean[][] visited,
                                       int i, int j) {
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && visited[i][j] == false && grid[i][j] != 2){
            return true;
        }
        return false;
    }
}
