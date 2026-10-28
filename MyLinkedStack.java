/*
    Name: Jay Wu
    PID:  A19135498
 */

import java.util.EmptyStackException;

/**
 * TODO
 *
 * @author Jay Wu
 * @since 10/27/2026
 */

public class MyLinkedStack {
    private DoublyLinkedList list;
    /**
     * TODO
     */
    public MyLinkedStack() {
        list = newDoublyLinkedList list;
    }

    /**
     * TODO
     */
    public int size() {
        // TODO
        return list.size();
    }

    /**
     * TODO
     */
    public boolean isEmpty() {
        // TODO
        return list.isEmpty();
    }

    /**
     * TODO
     */
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(0);
    }

    /**
     * TODO
     */
    public void push(String element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        list.add(0, element);
    }

    /**
     * TODO
     */
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(0);
    }

    /**
     * TODO
     */
    @Override
    public String toString() {
        return "[" + String.join)" -> ", list) + "]";
    }

    /**
     * TODO
     */
    public void clear() {
        list.clear();
    }
}
