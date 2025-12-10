// https://leetcode.com/problems/finding-mk-average/description/?envType=problem-list-v2&envId=queue

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Problem15 {
    public static void main(String[] args) {

    }
}

class MKAverage {

    private TreeMap<Integer, Integer> freqMap;
    private Deque<Integer> window;
    private int windowSize;
    private int trimCount;
    private int sumAll = 0;
    private int elemCount = 0;

    public MKAverage(int m, int k) {
        freqMap = new TreeMap<>();
        window = new LinkedList<>();
        this.windowSize = m;
        this.trimCount = k;
    }

    public void addElement(int value) {
        sumAll += value;
        elemCount++;
        window.add(value);

        if (window.size() > windowSize) {
            int removed = window.removeFirst();
            freqMap.put(removed, freqMap.get(removed) - 1);
            sumAll -= removed;
            if (freqMap.get(removed) == 0)
                freqMap.remove(removed);
        }
        freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
    }

    public int calculateMKAverage() {
        if (elemCount < windowSize)
            return -1;

        int smallest = freqMap.firstKey();
        int largest = freqMap.lastKey();
        int leftTrim = trimCount, rightTrim = trimCount;

        int trimSum = 0;

        while (leftTrim > 0) {
            int take = Math.min(leftTrim, freqMap.get(smallest));
            leftTrim -= take;
            trimSum += smallest * take;
            if (take == freqMap.get(smallest))
                smallest = freqMap.higherKey(smallest);
        }

        while (rightTrim > 0) {
            int take = Math.min(rightTrim, freqMap.get(largest));
            rightTrim -= take;
            trimSum += largest * take;
            if (take == freqMap.get(largest))
                largest = freqMap.lowerKey(largest);
        }

        return (sumAll - trimSum) / (windowSize - 2 * trimCount);
    }
}