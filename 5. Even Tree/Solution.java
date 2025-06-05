import java.io.*;
import java.util.*;

public class Solution {

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        // Модыг adjacency list хэлбэрээр байгуулах
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < t_edges; i++) {
            int u = t_from.get(i);
            int v = t_to.get(i);
            tree.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            tree.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // Дэд модны хэмжээг хадгалах массив
        int[] subtreeSizes = new int[t_nodes + 1];
        // Аль оройнуудыг үзсэнийг тэмдэглэх массив
        boolean[] visited = new boolean[t_nodes + 1];
        // DFS ашиглан дэд модны хэмжээг тооцоолох
        dfs(1, tree, subtreeSizes, visited);

        // Хасагдах боломжтой ирмэгүүдийг тоолох
        int count = 0;
        for (int i = 2; i <= t_nodes; i++) {
            if (subtreeSizes[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> tree, int[] subtreeSizes, boolean[] visited) {
        visited[node] = true;
        // Оройг тооцоонд оруулах
        subtreeSizes[node] = 1;

        // Бүх хөрш оройнуудыг шалгах
        for (int neighbor : tree.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(neighbor, tree, subtreeSizes, visited);
                // Хөршийн дэд модны хэмжээг нэмэх
                subtreeSizes[node] += subtreeSizes[neighbor];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            tFrom.add(Integer.parseInt(tFromTo[0]));
            tTo.add(Integer.parseInt(tFromTo[1]));
        }

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}