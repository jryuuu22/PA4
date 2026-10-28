/*
 * NAME: Jay Wu
 * PID: A19135498
 */

import java.util.AbstractList;

/**
 * TODO
 *
 * @author Jay Wu
 * @since A19135498
 */
public class DoublyLinkedList extends AbstractList<String> {

    /* DLL instance variables */
    private int size;
    private Node head;
    private Node tail;

    /**
     * TODO
     */
    protected class Node {

        /* Node instance variables */
        String elem;
        Node next;
        Node prev;

        /**
         * TODO
         */
        private Node(String element) {
            elem = element;
        }
        /**
         * TODO
         */
        private Node(String element, Node nextNode, Node prevNode) {
            next = nextNode;
            elem = element;
            prev = prevNode;
        }

        /**
         * TODO
         */
        public void setElement(String element) {
            elem = element;
        }

        /**
         * TODO
         */
        public String getElement() {
            return elem;
        }

        /**
         * TODO
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * TODO
         */
        public Node getNext() {
            return next;
        }

        /**
         * TODO
         */
        public void setPrev(Node p) {
            prev = p;
        }

        /**
         * TODO
         */
        public Node getPrev() {
            // TODO: complete implementation
            return prev;
        }

        /**
         * TODO
         */
        public void remove() {
            prev.setNext(next);
            next.setPrev(prev);
            next = null;
            prev = null;
        }
    }

    /**
     * TODO
     */
    public DoublyLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        size=0;
    }

    /**
     * TODO
     */
    @Override
    public boolean add(String element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        Node last = tail.getPrev();
        Node newNode = new Node(element, tail, last);
        last.setNext(newNode);
        tail.setPrev(newNode);
        size++;
        return true;
    }

    /**
     * TODO
     */
    @Override
    public void add(int index, String element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node after = (index==size) ? tail: getNth(index);
        Node before = after.getPrev();
        Node newNode = new Node(element, after, before);
        before.setNext(newNode);
        after.setPrev(newNode);
        size++;
    }

    /**
     * TODO
     */
    @Override
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size=0;
    }

    /**
     * TODO
     */
    @Override
    public boolean contains(Object element) {
        Node curr = head.getNext();
        while (curr != tail) {
            if (curr.getElement().equals(element)) {
                return true;
            }
            curr = curr.getNext()
        }
        return false;
    }

    /**
     * TODO
     */
    @Override
    public String get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNth(index).getElement();
    }

    /**
     * TODO
     */
    private Node getNth(int index) {
        Node curr;
        if (index < size/2) {
            curr = head.getNext();
            for (int i =0; i< index; i++){
                curr=curr.getNext();
            }
            else{
                curr=tail.getPrev();
                for (int i = size-1; i>index; i--){
                    curr=curr.getPrev();
                }
            }
        }
        return curr;
    }

    /**
     * TODO
     */
    @Override
    public boolean isEmpty() {
        // TODO: complete implementation
        return size ==0;
    }

    /**
     * TODO
     */
    @Override
    public String remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException();
        }
        Node target = getNth(index);
        target.remove();
        size--;
        return target.getElement();
    }

    /**
     * TODO
     */
    @Override
    public String set(int index, String element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node target = getNth(index);
        String old = target.getElement();
        target.setElement(element);
        return old;
    }

    /**
     * TODO
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * TODO
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[(head) -> ");
        Node curr = head.getNext();
        while (curr != tail) {
            sb.append(cur.getElement()).append(" -> ");
            curr = curr.getNext();
        }
        sb.append("(tail)]");
        return sb.toString();
        }
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * TODO
     */
    public void slice(int start, int end, int step) {
        // TODO: complete implementation
    }

    /**
     * TODO
     */
    public void swapHalves(int n, int start, int end) {
        // TODO: complete implementation
    }

}
