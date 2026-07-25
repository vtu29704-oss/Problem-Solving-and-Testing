import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        Arrays.sort(arr);

        if (k > 0 && k <= n) {
            System.out.println("Kth smallest element = " + arr[k - 1]);
        } else {
            System.out.println("Invalid value of K");
        }

        sc.close();
    }
}