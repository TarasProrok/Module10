package module10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class WordFreqCounter {
    public static Map<String, Integer> sortByValue(Map<String, Integer> hashMap) { //function to sort
        // creating list of entries in HashMap
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(hashMap.entrySet());
        // sorting list
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        // putting data from sorting list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        // creating reader of file
        try (BufferedReader br = new BufferedReader
                (new FileReader("/Users/mac/Desktop/Java/Module10/src/words.txt"))) {
            String[] words;
        // reading line of file
            String line = br.readLine();
            // splitting line on words and putting them in array
            while (line != null) {
                words = line.split(" ");
                // putting array in hashmap
                for (String word : words) {
                    hashMap.merge(word, 1, Integer::sum);
                }
                line = br.readLine();
            }
        }
        Map<String, Integer> hm1 = sortByValue(hashMap);
        // printing hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(en.getKey() +
                    " - " + en.getValue());
        }
    }
}


