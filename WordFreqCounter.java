package module10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class WordFreqCounter {
    public static Map<String, Integer> sortByValue(Map<String, Integer> hashMap) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(hashMap.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader
                (new FileReader("/Users/mac/Desktop/Java/Module10/src/words.txt"))) {
            String[] words;
            String line = br.readLine();
            while (line != null) {
                words = line.split(" ");
                for (String word : words) {
                    hashMap.merge(word, 1, Integer::sum);
                }
                line = br.readLine();
            }
        }
        Map<String, Integer> hm1 = sortByValue(hashMap);
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(en.getKey() +
                    " - " + en.getValue());
        }
    }
}


