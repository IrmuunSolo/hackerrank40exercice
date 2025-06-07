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
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) return grid;
        
        if (n % 2 == 0) {
            return fillAll(grid);
        }
        
        List<String> firstDetonation = detonate(grid);
        
        if (n % 4 == 3) {
            return firstDetonation;
        }
        
        return detonate(firstDetonation);
    }
    
    private static List<String> fillAll(List<String> grid) {
        List<String> result = new ArrayList<>();
        String filledRow = "O".repeat(grid.get(0).length());
        for (int i = 0; i < grid.size(); i++) {
            result.add(filledRow);
        }
        return result;
    }
    
    private static List<String> detonate(List<String> grid) {
        int r = grid.size();
        int c = grid.get(0).length();
        char[][] result = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], 'O');
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i-1][j] = '.';
                    if (i < r-1) result[i+1][j] = '.';
                    if (j > 0) result[i][j-1] = '.';
                    if (j < c-1) result[i][j+1] = '.';
                }
            }
        }
        
        List<String> output = new ArrayList<>();
        for (char[] row : result) {
            output.add(new String(row));
        }
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
