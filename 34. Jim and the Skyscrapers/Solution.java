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
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long solve(List<Integer> arr) {
        Map<Integer, List<Integer>> heightMap = new HashMap<>();
        
        for (int i = 0; i < arr.size(); i++) {
            int h = arr.get(i);
            heightMap.putIfAbsent(h, new ArrayList<>());
            heightMap.get(h).add(i);
        }
        
        long total = 0;
        
        for (List<Integer> indices : heightMap.values()) {
            if (indices.size() < 2) continue;
            
            Stack<Integer> stack = new Stack<>();
            long count = 0;
            
            for (int i = 0; i < indices.size(); i++) {
                int current = indices.get(i);
                
                while (!stack.isEmpty()) {
                    int prev = stack.peek();
                    
                    if (hasHigherInBetween(arr, prev, current)) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                
                count += stack.size();
                stack.push(current);
            }
            
            total += count * 2;
        }
        
        return total;
    }
    
    private static boolean hasHigherInBetween(List<Integer> arr, int a, int b) {
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        int height = arr.get(a);
        
        for (int i = start + 1; i < end; i++) {
            if (arr.get(i) > height) {
                return true;
            }
        }
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
