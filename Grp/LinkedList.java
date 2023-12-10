package DSA.Grp;

public class LinkedList<T> {
    private static final int MAX_SIZE = 100;
    private Node<T> head;
    private int size;

    public void add(T data) {
        if (size >= MAX_SIZE) {
            // Handle case where maximum size is reached
            return;
        }

        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

