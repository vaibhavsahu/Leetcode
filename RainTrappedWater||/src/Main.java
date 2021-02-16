import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int [][] matrix = {  {1,4,3,1,3,2},
                             {3,2,1,3,2,4},
                             {2,3,3,2,3,1}};

        System.out.println(quantityTrappedWater(matrix));
    }

    private static int quantityTrappedWater(int[][] matrix) {

        if(matrix.length == 0){
            return 0;
        }

        int total = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Queue<Integer> queue = getNeighbors(matrix, i, j);

                if(queue.size() == 4){
                    int quantity = matrix[i][j] - queue.poll();
                    if(quantity >= 0){
                        total += quantity;
                    }

                }
            }
        }

        return total;
    }

    private static Queue<Integer> getNeighbors(int[][] matrix, int i, int j) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        if(isValidNeighbor(matrix, i-1, j)){
            queue.add(matrix[i-1][j]);
        }

        if(isValidNeighbor(matrix, i+1, j)){
            queue.add(matrix[i+1][j]);
        }

        if(isValidNeighbor(matrix, i, j-1)){
            queue.add(matrix[i][j-1]);
        }

        if(isValidNeighbor(matrix, i, j+1)){
            queue.add(matrix[i][j+1]);
        }

        return queue;

    }

    private static boolean isValidNeighbor(int[][] matrix, int i, int j){
        if(i < matrix.length && j < matrix[0].length && i >= 0 && j >= 0){
            return true;
        }
        return false;
    }
}
