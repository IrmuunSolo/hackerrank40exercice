import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        
        String[] numberWords = {
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", 
        "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};
        
        String word;
        if(m <= 30){
            switch(m){
                case 0:
                    word = numberWords[h - 1] + " o' clock";
                    break;
                case 1:
                    word = "one minute past " + numberWords[h - 1];
                    break;
                case 15:
                    word = "quarter past " + numberWords[h - 1];
                    break;
                case 30:
                    word = "half past " + numberWords[h - 1];
                    break;
                default:
                    word = numberWords[m - 1] + " minutes past " + numberWords[h - 1];
                    break;
            }
        } else if(m < 60){
            switch(m){
                case 45: 
                    word = "quarter to " + numberWords[h];
                    break;
                case 59:
                    word = "one minute to " + numberWords[h];
                    break;
                default:
                    word = numberWords[60 - m - 1] + " minutes to " + numberWords[h];
                    break;
            }
        } else {
            word = null;
        }

        return word;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
