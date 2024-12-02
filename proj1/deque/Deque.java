package deque;

public interface Deque<T> {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    T get(int index);

    void printDeque();

    static <T> boolean equals(Deque<T> a, Deque<T> b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)) {
                return false;
            }
        }
        return true;
    }
}
