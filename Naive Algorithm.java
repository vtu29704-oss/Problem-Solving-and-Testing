import java.util.ArrayList;

public class GFG {

    // Function to find all occurrences of pattern in text
    static ArrayList<Integer> search(String pat, String txt) {

        int m = pat.length();
        int n = txt.length();

        ArrayList<Integer> ans = new ArrayList<>();

        // Check every possible starting position
        for (int i = 0; i <= n - m; i++) {

            int j;

            // Compare pattern with text
            for (j = 0; j < m; j++) {

                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // If all characters matched
            if (j == m) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        ArrayList<Integer> result = search(pat, txt);

        for (int index : result) {
            System.out.print(index + " ");
        }
    }
}
