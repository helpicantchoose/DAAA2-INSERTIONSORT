package algorithms;

import metrics.PerformanceTracker;

public class InsertionSortBasic {
    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        tracker.start();

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                tracker.addComparison();
                if (arr[j] > key) {
                    tracker.addShift();
                    arr[j + 1] = arr[j];
                    j--;
                } else break;
            }
            if (arr[j + 1] != key) tracker.addSwap();
            arr[j + 1] = key;
        }
        tracker.stop();
    }
}