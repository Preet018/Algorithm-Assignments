// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

public class Problem1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int res = 0;

        // Find the max Departure time
        int maxDep = dep[0];
        for (int i = 1; i < n; i++) {
            maxDep = Math.max(maxDep, dep[i]);
        }
        int[] v = new int[maxDep + 2];

        // Increment the count at the arrival time and decrement
        // at the departure time
        for (int i = 0; i < n; i++) {
            v[arr[i]]++;
            v[dep[i] + 1]--;
        }

        int count = 0;

        // Iterate over the array and keep track of the maximum
        // sum seen so far
        for (int i = 0; i <= maxDep + 1; i++) {
            count += v[i];
            res = Math.max(res, count);
        }

        return res;
    }
}