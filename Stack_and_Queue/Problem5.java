// https://leetcode.com/problems/online-stock-span/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class Problem5 {
    public static void main(String[] args) {

    }
}

class Pair {
    int price;
    int span;

    public Pair(int value) {
        price = value;
        span = 1;
    }
}

class StockSpanner {
    Stack<Pair> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        Pair pair = new Pair(price);

        while (!stk.isEmpty() && stk.peek().price <= price) {
            pair.span = pair.span + stk.peek().span;
            stk.pop();
        }

        stk.push(pair);

        return pair.span;
    }
}