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

class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
        int half = n / 2;
        
        for (int i = 0; i < half; i++) {
            arr.get(i).set(1, "-");
        }
        
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(arr.get(i).get(0));
            String s = arr.get(i).get(1);
            buckets.get(x).add(s);
        }
        
        StringBuilder output = new StringBuilder();
        for (List<String> bucket : buckets) {
            for (String s : bucket) {
                output.append(s).append(" ");
            }
        }
        
        System.out.println(output.toString().trim());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
