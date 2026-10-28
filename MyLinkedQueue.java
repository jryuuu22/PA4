/*
    Name: Jay Wu
    PID:  A19135498
 */

/**
 * TODO
 *
 * @author Jay Wu
 * @since 10/27/2026
 */

public class MyLinkedQueue {

    /* instance variables, feel free to add if you need */
    private DoublyLinkedList list;
    /**
     * TODO
     */
    public MyLinkedQueue() {
        list = new DoublyLinkedList();
    }

    /**
     * TODO
     */
    public int size() {
        return list.size();
    }

    /**
     * TODO
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * TODO
     */
    public void enqueue(String data) {
        if (data==null) {
            throw new IllegalArgumentException();
        }
        list.add(data);
    }

    /**
     * TODO
     */
    public String peek() {
        return isEmpty() ? null : list.get(0);
    }

    /**
     * TODO
     */
    public String dequeue() {
        return isEmpty() ? null : list.remove(0);
    }

    /**
     * TODO
     */
    @Override
    public String toString() {
        return "[" + String.join(" -> ", list) + "]";
    }
}
