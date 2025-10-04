package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long shifts = 0;
    private long startTime;
    private long endTime;

    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addShift() { shifts++; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getShifts() { return shifts; }

    public double getTimeMillis() { return (endTime - startTime) / 1_000_000.0; }

    public void reset() { comparisons = swaps = shifts = startTime = endTime = 0; }

    public void exportCSV(String algorithm, int dataSize, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(String.format("%s;%d;%.3f;%d;%d;%d\n",
                    algorithm, dataSize, getTimeMillis(), comparisons, shifts, swaps));
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public String toString() {
        return String.format("Time: %.3f ms | Comparisons: %d | Shifts: %d | Swaps: %d",
                getTimeMillis(), comparisons, shifts, swaps);
    }
}
