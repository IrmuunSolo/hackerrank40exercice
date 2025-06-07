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
     * Complete the 'countLuck' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY matrix
     *  2. INTEGER k
     */

  public static String countLuck(List<String> matrix, int k) {
    int n = matrix.size();
    int m = matrix.get(0).length();

    char[][] grid = new char[n][m];
    int startX = -1, startY = -1;
    
    for (int i = 0; i < n; i++) {
        grid[i] = matrix.get(i).toCharArray();
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'M') {
                startX = i;
                startY = j;
            }
        }
    }

    boolean[][] visited = new boolean[n][m];
    int result = dfs(grid, visited, startX, startY);

    return result == k ? "Impressed" : "Oops!";
}

private static int dfs(char[][] grid, boolean[][] visited, int x, int y) {
    if (grid[x][y] == '*') return 0;

    visited[x][y] = true;
    int[] dx = {-1, 1, 0, 0};  
    int[] dy = {0, 0, -1, 1};

    List<int[]> nextMoves = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (isValid(grid, visited, nx, ny)) {
            nextMoves.add(new int[]{nx, ny});
        }
    }

    for (int[] move : nextMoves) {
        int waves = dfs(grid, visited, move[0], move[1]);
        if (waves != -1) {
            return nextMoves.size() > 1 ? waves + 1 : waves;
        }
    }

    return -1; // not found
}

private static boolean isValid(char[][] grid, boolean[][] visited, int x, int y) {
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length &&
           !visited[x][y] && (grid[x][y] == '.' || grid[x][y] == '*');
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<String> matrix = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                String result = Result.countLuck(matrix, k);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
