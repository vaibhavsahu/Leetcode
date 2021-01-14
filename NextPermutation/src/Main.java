public class Main {
    public static void main(String[] args) {
        int [] array = {6,4,2,1,5,4,3,0};
        nextPermutation(array);
        System.out.println(array);
    }

    private static void nextPermutation(int[] array) {
        //find the index before which element is less greater than current element
        // and after which sequence is strictly decreasing

        for (int i = array.length-1; i > 0; i--) {
            if(array[i] > array[i+1]){
                continue;
            } else {

            }


        }
    }
}
