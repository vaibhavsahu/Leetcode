import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        String [] wordList = {"hot","dot","dog","lot","log","cog"};

        int count = transformationCount(beginWord, endWord, Arrays.asList(wordList));
        System.out.println(count);
    }

    private static int transformationCount(String beginWord, String endWord, List<String> wordList) {

        //number of levels

        if(!wordList.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        int count = 1;

        Set<String> set = new HashSet<>();
        queue.add(beginWord);
        set.add(beginWord);

        while(!queue.isEmpty()){
            String word = queue.remove();

            if(word == endWord){
                return count;
            }

            List<String> oneEditWords = findAllWordsAtDistanceOne(word, wordList, set);

            if(oneEditWords.size() >= 1 && !oneEditWords.contains(endWord)){
                //count = count-oneEditWords.size();
                count++;
            }

            for(String w : oneEditWords){
                if(!set.contains(w)){
                    set.add(w);
                   // count++;
                }
                queue.add(w);
            }
        }

        return count;
    }

    private static List<String> findAllWordsAtDistanceOne(String word, List<String> wordList, Set<String> set) {
        List<String> words = new ArrayList<>();
        for(String w : wordList){
            if(!w.equals(word) && !set.contains(w)){
                int distance = distanceFromWord(word, w);
                if( distance == 1 || distance == 0){
                    words.add(w);
                }
            }
        }
        return words;
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
