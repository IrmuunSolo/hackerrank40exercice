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
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> answers = new ArrayList<>();
        List<Integer> primes = getPrimes(q);
        Stack<Integer> A = new Stack<>();
        
        for (int i = 0; i < number.size(); i++) {
            A.push(number.get(i));
        }
        
        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);
            Stack<Integer> newA = new Stack<>();
            Stack<Integer> B = new Stack<>();
            
            while (!A.isEmpty()) {
                int plate = A.pop();
                if (plate % prime == 0) {
                    B.push(plate);
                } else {
                    newA.push(plate);
                }
            }
            
            while (!B.isEmpty()) {
                answers.add(B.pop());
            }
            
            A = newA;
        }
        
        while (!A.isEmpty()) {
            answers.add(A.pop());
        }
        
        return answers;
    }
    
    private static List<Integer> getPrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < q) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
