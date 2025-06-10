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
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        List<Integer> sortedAsc = new ArrayList<>(arr);
        Collections.sort(sortedAsc);
        
        List<Integer> sortedDesc = new ArrayList<>(sortedAsc);
        Collections.reverse(sortedDesc);
        
        int swapsAsc = countSwaps(new ArrayList<>(arr), sortedAsc);
        int swapsDesc = countSwaps(new ArrayList<>(arr), sortedDesc);
        
        return Math.min(swapsAsc, swapsDesc);
    }
    
    private static int countSwaps(List<Integer> arr, List<Integer> target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            valueToIndex.put(arr.get(i), i);
        }
        
        int swaps = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(target.get(i))) {
                swaps++;
                int correctValue = target.get(i);
                int currentIndex = valueToIndex.get(correctValue);
                
                Collections.swap(arr, i, currentIndex);
                
                valueToIndex.put(arr.get(currentIndex), currentIndex);
                valueToIndex.put(arr.get(i), i);
            }
        }
        return swaps;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
