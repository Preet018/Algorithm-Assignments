// https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-multiplication/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Problem14 {
    public static void main(String[] args) {

    }
}

class TestClass {

    public static List<Long> find_Mulit(List<Integer> arr) {
        long mul = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Long> res = new ArrayList<>(Collections.nCopies(arr.size(), -1L));

        for (int i = 0; i < arr.size(); i++) {
            mul *= arr.get(i);
            pq.add(arr.get(i));

            if (i == 2) {
                res.set(i, mul);
            } else if (i > 2) {
                int temp = pq.poll();
                mul /= temp;
                res.set(i, mul);
            }
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] arrStr = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(arrStr[i]));
        }

        List<Long> res = find_Mulit(arr);
        for (long val : res) {
            System.out.println(val);
        }
    }
}
