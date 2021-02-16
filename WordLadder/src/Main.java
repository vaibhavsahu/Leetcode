import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";

        String [] wordList = {"hot","dog","dot"};

        int count = transformationCount(beginWord, endWord, wordList);
        System.out.println(count);
    }

    private static int transformationCount(String beginWord, String endWord, String[] wordList) {

        List<String> words = Arrays.asList(wordList).stream().collect(Collectors.toList());

        int count = 0;

        if(words.contains(endWord)){
            for(String word : wordList){
                if(distanceFromWord(beginWord, word) == 1){
                    count++;
                    beginWord = word;
                }
            }
        }

        return count;
    }

    private static int distanceFromWord(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int lengthDiff = Math.abs(len1 - len2);

        int count = 0;

        if(word1.equals(word2)){
            return 0;
        }

        if( lengthDiff == 1 || lengthDiff == 0 ){
            if(len1 > len2){
                for(int i = 0; i < len2; i++){
                    if(word2.charAt(i) != word1.charAt(i)){
                        count++;
                    }
                }
                count++;
            } else if(len2 > len1){
                for(int i = 0; i < len1; i++){
                    if(word2.charAt(i) != word1.charAt(i)){
                        count++;
                    }
                }
                count++;
            } else {
                for(int i = 0; i < len1; i++){
                    if(word2.charAt(i) != word1.charAt(i)){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
