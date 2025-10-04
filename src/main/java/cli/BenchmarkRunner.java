package cli;

import algorithms.InsertionSortBasic;
import algorithms.InsertionSortOptimized;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        String csvFile = "benchmark_results.csv";

        for (int size : sizes) {
            int[] data = generateNearlySortedArray(size, 5);
            PerformanceTracker tracker1 = new PerformanceTracker();
            PerformanceTracker tracker2 = new PerformanceTracker();

            int[] copy1 = Arrays.copyOf(data, data.length);
            int[] copy2 = Arrays.copyOf(data, data.length);

            InsertionSortBasic.sort(copy1, tracker1);
            InsertionSortOptimized.sort(copy2, tracker2);

            tracker1.exportCSV("Basic", size, csvFile);
            tracker2.exportCSV("Optimized", size, csvFile);

            System.out.printf("Size %d → Basic: %s | Optimized: %s%n",
                    size, tracker1, tracker2);
        }
    }

    private static int[] generateNearlySortedArray(int n, int swaps) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Random rnd = new Random();
        for (int i = 0; i < swaps; i++) {
            int a = rnd.nextInt(n);
            int b = rnd.nextInt(n);
            int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
        }
        return arr;
    }
}
