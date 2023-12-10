package DSA.Grp;

public class Set<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    public Set() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Add new data to the end of the set
    public void add(T data) {
        if (contains(data)) {
            return;
        }

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public boolean contains(T data) {
        // LOOP THROUGH LIST TO CHECK FOR ELEMENT
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
        if (!contains(data)) {
            System.out.println("ERROR: Set does not contain " + data);
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
    }

    // Size
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void clear() {
        Node<T> current = head;
        while (current != null) {
            remove(current.data);
            current = current.next;
        }
        if (this.isEmpty()) {
            System.out.println("Set clear successful");
        } else {
            System.out.println("Set clear unsuccessful");
        }
    }

    @Override
    public String toString() {
        String[] arr = new String[this.size()];
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            arr[count] = current.data.toString();
            count++;
            current = current.next;
        }

        String result = "";
        for (int i = 0; i < count; i++) {
            result += arr[i] + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> mySet = new Set<Integer>();
        mySet.add(1);
        mySet.add(10);
        mySet.add(5);
        mySet.add(2);
        System.out.println(mySet);
    }
}
