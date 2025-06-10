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
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        
        if (arr.equals(sorted)) {
            System.out.println("yes");
            return;
        }
        
        int n = arr.size();
        int left = -1, right = -1;
        
        // Find the first and last positions where arr differs from sorted
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != sorted.get(i)) {
                left = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr.get(i) != sorted.get(i)) {
                right = i;
                break;
            }
        }
        
        // Check if swapping left and right sorts the array
        List<Integer> temp = new ArrayList<>(arr);
        Collections.swap(temp, left, right);
        if (temp.equals(sorted)) {
            System.out.println("yes");
            System.out.println("swap " + (left + 1) + " " + (right + 1));
            return;
        }
        
        // Check if reversing the segment from left to right sorts the array
        temp = new ArrayList<>(arr);
        List<Integer> sublist = temp.subList(left, right + 1);
        Collections.reverse(sublist);
        if (temp.equals(sorted)) {
            System.out.println("yes");
            System.out.println("reverse " + (left + 1) + " " + (right + 1));
            return;
        }
        
        System.out.println("no");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
