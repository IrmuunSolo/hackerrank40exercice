import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0; 
}


class Result {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> results = new ArrayList<>();
        TrieNode root = new TrieNode();
        
        for (List<String> query : queries) {
            String operation = query.get(0);
            String word = query.get(1);
            
            if (operation.equals("add")) {
                
                TrieNode current = root;
                for (char c : word.toCharArray()) {
                    current.children.putIfAbsent(c, new TrieNode());
                    current = current.children.get(c);
                    current.count++; 
                }
            } else if (operation.equals("find")) {
                
                TrieNode current = root;
                boolean found = true;
                for (char c : word.toCharArray()) {
                    if (!current.children.containsKey(c)) {
                        found = false;
                        break;
                    }
                    current = current.children.get(c);
                }
                results.add(found ? current.count : 0);
            }
        }
        
        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
