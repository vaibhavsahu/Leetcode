import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] coins = {384,324,196,481};
        int amount = 285;

        //6063,   5830,   6166,   5841
        //5877,5644,5980,5655//5644,

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] > amount){
                continue;
            }
            if(coins[i] < amount && (coins[i] % amount) != 0){
                return;
            }
        }

        if(coins.length == 1 && (amount % coins[0]) == 0){
            System.out.println(amount / coins[0]);
        }

        if(coins.length == 1 && (amount % coins[0]) != 0){
            System.out.println(-1);
        }

        int [] result = new int[amount+1];

        for (int i = 0; i < coins.length ; i++) {
            if(coins[i] != Integer.MAX_VALUE && i < result.length-1 && coins[i] <= amount) {
                result[coins[i]] = 1;
            }
        }

        for(int i = 1; i < result.length; i++){
            if(result[i] != 1){
                result[i] = 0;
            }
        }

        //List<Integer> list = new ArrayList<>();
        for(int j = 1; j < result.length; j++){
            if(result[j] != 1){
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < coins.length ; i++) {
                    if(coins[i] != Integer.MAX_VALUE && j - coins[i] > 0){
                        int a;
                        if(result[j-coins[i]] >= Integer.MAX_VALUE){
                            a = Integer.MAX_VALUE;
                        } else {
                            a = 1 + result[j - coins[i]];
                        }
                        list.add(a);
                    }
                }
                result[j] = list.stream().min(Integer::compareTo).isPresent() ? list.stream().min(Integer::compareTo).get() : Integer.MAX_VALUE;
            }
        }

        if(result[amount] >= Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        System.out.println(result[amount]);
    }
}
