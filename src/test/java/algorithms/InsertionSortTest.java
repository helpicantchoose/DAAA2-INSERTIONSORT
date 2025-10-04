package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {
    @Test
    void testBasicSort() {
        int[] arr = {5, 3, 4, 1};
        int[] expected = {1, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSortBasic.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testOptimizedSort() {
        int[] arr = {2, 1, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSortOptimized.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testDuplicateOptimizedSort() {
        int[] arr = {4, 4, 4, 4, 4};
        int[] expected = {4, 4, 4, 4, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSortBasic.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testDuplicateSort() {
        int[] arr = {4, 4, 4, 4, 4};
        int[] expected = {4, 4, 4, 4, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSortOptimized.sort(arr, tracker);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSortBasic.sort(arr, tracker);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testOptimizedEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSortOptimized.sort(arr, tracker);
        assertArrayEquals(new int[]{}, arr);
    }

}
