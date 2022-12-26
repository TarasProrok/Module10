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
        String[] words = new String[0];
        try (BufferedReader br = new BufferedReader
                (new FileReader("/Users/mac/Desktop/Java/Module10/src/file2.txt"))) {
            br.readLine(); // <-- skipping first line
            String line = br.readLine();
            while (line != null) {
                words = line.split(" ");
                hashMap.put(words[0], words[1]);
                line = br.readLine();
            }
        }
        User user = new User(words[0], words[1]);
        ArrayList users = new ArrayList();
        for (int i = 0; i<hashMap.size(); i++){
            users.add(user);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println(json);
    }
}

    class User {
        private String name;
        private String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }

