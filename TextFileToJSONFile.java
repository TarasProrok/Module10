package module10;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TextFileToJSONFile {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        // creating reader of file
        try (BufferedReader br = new BufferedReader
                (new FileReader("/Users/mac/Desktop/Java/Module10/src/file2.txt"))) {
            String[] words;
            // reading line of file
            br.readLine(); // <-- skipping first line
            String line = br.readLine();
            // splitting line on words and putting them in array
            while (line != null) {
                words = line.split(" ");
                System.out.println(Arrays.toString(words)); // printing array
                for (int i = 0; i < words.length; i++) {
                    System.out.println("i- " + i + " value- " + words[i]); //printing with i and values
                }
                hashMap.put(words[0], words[1]);
                line = br.readLine();
            }
        }
        System.out.println(hashMap);

            User user = new User(hashMap, hashMap);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(user);

            System.out.println(json);
        }
    }
    class User {
        private HashMap name;
        private HashMap age;

        public User(HashMap<String, String> name, HashMap<String, String> age) {
            this.name = name;
            this.age = age;
        }
    }

