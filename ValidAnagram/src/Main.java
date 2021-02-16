import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cba";

        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(String.valueOf(arr1).equals(String.valueOf(arr2)));
    }
}
