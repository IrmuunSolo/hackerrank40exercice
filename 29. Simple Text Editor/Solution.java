import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int Q = Integer.parseInt(br.readLine());
        StringBuilder S = new StringBuilder();
        Stack<String> history = new Stack<>();
        
        for (int i = 0; i < Q; i++) {
            String[] op = br.readLine().split(" ");
            int type = Integer.parseInt(op[0]);
            
            switch (type) {
                case 1: // append
                    history.push(S.toString());
                    S.append(op[1]);
                    break;
                case 2: // delete
                    history.push(S.toString());
                    int k = Integer.parseInt(op[1]);
                    S.delete(S.length() - k, S.length());
                    break;
                case 3: // print
                    int pos = Integer.parseInt(op[1]) - 1;
                    bw.write(S.charAt(pos) + "\n");
                    break;
                case 4: // undo
                    if (!history.isEmpty()) {
                        S = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
