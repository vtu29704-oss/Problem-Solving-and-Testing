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
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
         int currentSum = arr.get(0);
        int maxSubarray = arr.get(0);

        // Maximum subsequence sum
        int maxSubsequence = 0;
        int maxElement = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {

            int value = arr.get(i);

            // Kadane's algorithm
            if (i > 0) {
                currentSum = Math.max(value, currentSum + value);
                maxSubarray = Math.max(maxSubarray, currentSum);
            }

            // Find largest element
            maxElement = Math.max(maxElement, value);

            // Add positive elements
            if (value > 0) {
                maxSubsequence += value;
            }
        }

        // If all elements are negative
        if (maxSubsequence == 0) {
            maxSubsequence = maxElement;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
