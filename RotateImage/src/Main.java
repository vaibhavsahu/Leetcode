import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        // int temp = a
        // a = c
        // c = d
        // d = b
        // b = temp
        rotateMatrix(matrix);

    }

    //first iteration
    //(0, 0) -> (0, 4)
    //(0, 4) -> (4, 4)
    //(4, 4) -> (4, 0)
    //(4, 0) -> (0, 0)

    //(0, 1) -> (1, 4)
    //(1, 4) -> (4, 3)
    //(4, 3) -> (3, 0)
    //(3, 0) -> (0, 0)

    //(0, 2) -> (2, 4)
    //(2, 4) -> (4, 2)
    //(4, 2) -> (2, 0)
    //(2, 0) -> (0, 0)

    //(0, 3) -> (3, 4)
    //(3, 4) -> (4, 1)
    //(4, 1) -> (1, 0)
    //(1, 0) -> (0, 0)

    //second iteration
    //(1, 1) -> (1, 3)
    //(1, 3) -> (3, 3)
    //(3, 3) -> (3, 1)
    //(3, 1) -> (1, 1)

    //(1, 2) -> (2, 3)
    //(2, 3) -> (3, 2)
    //(3, 2) -> (2, 1)
    //(2, 1) -> (1, 2)

    //i, j -> j , n-i-1
    //j, n-i-1 -> n-i-1, n-j-i-1
    //n-i-1, n-j-i-1 -> n-j-i-1, i
    //n-j-i-1, i -> i, j


    public static void rotateMatrix(int [][] matrix){

        int n = matrix.length;
        if(n == 1){
            System.out.println(Arrays.deepToString(matrix));
        } else {
            int N = n/2;
            for (int i = 0; i < N; i++) {
                for(int j = i; j < n-i-1; j++){
                    //int temp = a
                    // a = d
                    // d = c
                    // c = b
                    // b = temp
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-j-1][i]; //n-j-i-1, i
                    matrix[n-j-1][i] = matrix[n-i-1][n-j-1];//n-i-1, n-j-i-1
                    matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; //j, n-i-1
                    matrix[j][n-i-1] = temp;
                    System.out.println(Arrays.deepToString(matrix));
                }
            }
        }
    }
}
