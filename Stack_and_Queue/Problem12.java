// https://leetcode.com/problems/design-circular-deque/description/?envType=problem-list-v2&envId=queue

public class Problem12 {
    public static void main(String[] args) {

    }
}

class Node {
    int value;
    Node prev;
    Node next;
}

class MyCircularDeque {
    private int size = 0;
    private int max = 0;
    Node head = null;
    Node rear = null;

    public MyCircularDeque(int k) {
        max = k;
    }

    public boolean insertFront(int value) {
        if (size == max) {
            return false;
        } else if (size == 0) {
            Node temp = new Node();
            temp.value = value;
            temp.prev = temp;
            temp.next = temp;

            head = temp;
            rear = temp;
            size++;
            // System.out.println(size);

            return true;
        }

        Node temp = new Node();
        temp.value = value;
        temp.prev = rear;
        temp.next = head;

        rear.next = temp;
        head.prev = temp;

        head = temp;
        size++;
        // System.out.println(size);

        return true;
    }

    public boolean insertLast(int value) {
        if (size == max) {
            return false;
        } else if (size == 0) {
            Node temp = new Node();
            temp.value = value;
            temp.prev = temp;
            temp.next = temp;

            head = temp;
            rear = temp;
            size++;
            // System.out.println(size);
            return true;
        }

        Node temp = new Node();
        temp.value = value;
        temp.prev = rear;
        temp.next = head;

        rear.next = temp;
        head.prev = temp;

        rear = temp;
        size++;
        // System.out.println(size);

        return true;
    }

    public boolean deleteFront() {
        if (head == null) {
            return false;
        } else if (size == 1) {
            head = null;
            rear = null;
            size--;

            return true;
        }

        head.next.prev = rear;
        rear.next = head.next;

        head = head.next;
        size--;
        // System.out.println(size);

        return true;
    }

    public boolean deleteLast() {
        if (rear == null) {
            return false;
        } else if (size == 1) {
            head = null;
            rear = null;
            size--;

            return true;
        }

        rear.prev.next = head;
        head.prev = rear.prev;

        rear = rear.prev;
        size--;
        // System.out.println(size);

        return true;
    }

    public int getFront() {
        if (head == null) {
            return -1;
        }

        return head.value;
    }

    public int getRear() {
        if (rear == null) {
            return -1;
        }

        return rear.value;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        }

        return false;
    }
}