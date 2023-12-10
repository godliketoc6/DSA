package DSA.Grp;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

public class HashSet<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_SIZE = 100; // Set your desired max size
    private LinkedList<T>[] table;
    private int capacity;
    private int size;

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
        if (size >= MAX_SIZE) {
            // Handle case where maximum size is reached
            return;
        }

        int index = hashFunction(element);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        LinkedList<T> bucket = table[index];
        if (!bucket.contains(element)) {
            bucket.add(element);
            size++;
        }
    }

    public void remove(T element) {
        int index = hashFunction(element);

        if (table[index] != null) {
            table[index].remove(element);
            size--;
        }
    }

    public boolean contains(T element) {
        int index = hashFunction(element);

        return table[index] != null && table[index].contains(element);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HashSet<Integer> myHashSet = new HashSet<>();

        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(5);

        // Print the elements in the HashSet
        System.out.println("HashSet contains elements:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Element " + i + ": " + myHashSet.contains(i));
        }

        // Print the size of the HashSet
        System.out.println("Size of HashSet: " + myHashSet.size());
    }
}
