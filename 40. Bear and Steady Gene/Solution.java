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
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */

    public static int steadyGene(String gene) {
        int n = gene.length();
        int target = n / 4;
        int[] count = new int[26]; 
        
        for (char c : gene.toCharArray()) {
            count[c - 'A']++;
        }
        
        if (count['A' - 'A'] == target && count['C' - 'A'] == target && 
            count['G' - 'A'] == target && count['T' - 'A'] == target) {
            return 0;
        }
        
        int left = 0;
        int minLen = n;
        
        for (int right = 0; right < n; right++) {
            char c = gene.charAt(right);
            count[c - 'A']--;
            
            while (left <= right && 
                   count['A' - 'A'] <= target && 
                   count['C' - 'A'] <= target && 
                   count['G' - 'A'] <= target && 
                   count['T' - 'A'] <= target) {
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = gene.charAt(left);
                count[leftChar - 'A']++;
                left++;
            }
        }
        
        return minLen;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = Result.steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
