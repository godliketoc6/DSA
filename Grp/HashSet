class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

class LinkedList<T> {
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
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
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

public class HashSet<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private LinkedList<T>[] table;
    private int capacity;

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
    }

    private int hashFunction(T element) {
        return Math.abs(element.hashCode()) % capacity;
    }

    public void add(T element) {
        int index = hashFunction(element);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        LinkedList<T> bucket = table[index];
        if (!bucket.contains(element)) {
            bucket.add(element);
        }
    }

    public void remove(T element) {
        int index = hashFunction(element);

        if (table[index] != null) {
            table[index].remove(element);
        }
    }

    public boolean contains(T element) {
        int index = hashFunction(element);

        return table[index] != null && table[index].contains(element);
    }
}
