// https://leetcode.com/problems/employee-importance/?envType=problem-list-v2&envId=breadth-first-search

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem8 {
    public static void main(String[] args) {

    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> inputMap = new HashMap<>();
        // Construct HashMap as getting the employee from id is difficult in a list
        for (Employee e : employees) {
            inputMap.put(e.id, e);
        }
        return helper(inputMap, id);
    }

    private static int helper(Map<Integer, Employee> inputMap, int id) {
        int imp = inputMap.get(id).importance;

        for (int subId : inputMap.get(id).subordinates) {
            imp += helper(inputMap, subId);
        }

        return imp;
    }
}