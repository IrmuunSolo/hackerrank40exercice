import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        int L = s.length();
        int row = (int) Math.floor(Math.sqrt(L));
        int col = (int) Math.ceil(Math.sqrt(L));
        
        if (row * col < L) {
            row = col;
        }
        
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int index = j * col + i;
                if (index < L) {
                    encrypted.append(s.charAt(index));
                }
            }
            if (i != col - 1) {
                encrypted.append(" ");
            }
        }
        
        return encrypted.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
