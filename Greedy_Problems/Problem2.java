// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {

    }
}

class Item {
    int value, weight;
    double ratio;

    Item(int v, int w) {
        value = v;
        weight = w;
        ratio = (double) v / w;
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        Item[] item = new Item[n];

        for (int i = 0; i < n; i++) {
            item[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(item, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalVal = 0.0;

        for (Item it : item) {
            if (capacity == 0)
                break;

            if (capacity >= it.weight) {
                totalVal += it.value;
                capacity -= it.weight;
            } else {
                totalVal += it.ratio * capacity;
                capacity = 0;
            }
        }

        // return Math.round(totalVal);
        return Math.round(totalVal * 1e6) / 1e6;

    }
}