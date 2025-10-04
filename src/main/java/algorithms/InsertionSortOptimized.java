package algorithms;

import metrics.PerformanceTracker;

public class InsertionSortOptimized {
    private static int binarySearch(int[] arr, int key, int left, int right, PerformanceTracker tracker) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            tracker.addComparison();
            if (arr[mid] > key)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        tracker.start();

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            int pos = binarySearch(arr, key, 0, j, tracker);
            while (j >= pos) {
                tracker.addShift();
                arr[j + 1] = arr[j];
                j--;
            }
            tracker.addSwap();
            arr[j + 1] = key;
        }
        tracker.stop();
    }
}
