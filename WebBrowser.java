/*
 * NAME: TODO
 * PID: TODO
 */

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * TODO
 *
 * @author TODO
 * @since TODO
 */
public class WebBrowser {
    private static final int NO_TAB = -1;

    /* instance variables, feel free to add more if you need */
    private DoublyLinkedList openTabs;
    private MyLinkedQueue waiting;
    private MyLinkedStack closedTabs;
    private int currentIndex;

    /**
     * TODO
     */
    public WebBrowser() {
        openTabs = new DoublyLinkedList();
        waiting = new MyLinkedQueue();
        closedTabs = new MyLinkedStack();
        currentIndex = NO_TAB;
    }

    /**
     * TODO
     */
    public void addToQueue(String website) {
        if (website == null){
            throw new IllegalArgumentException();
        }
        waiting.enqueue(website);
    }

    /**
     * TODO
     */
    public String openNextTab() {
        if (waiting.isEmpty()) {
            throw new NoSuchElementException();
        }
        String website = waiting.dequeue();
        openTabs.add(website);
        currentIndex = openTabs.size() -1;
        return website;
    }

    /**
     * TODO
     */
    public String closeCurrentTab() {
        if (openTabs.isEmpty()) {
            throw new NoSuchElementException();
        }
        String website = openTabs.remove(currentIndex);
        closedTabs.push(website);
        if (currentIndex==openTabs.size()) {
            currentIndex--;
        }
        return website;
    }

    /**
     * TODO
     */
    public String reopenClosedTab() {
        if (closedTabs.isEmpty()) {
            throw new EmptyStackException();
        }
        String website = closedTabs.pop();
        openTabs.add(0, website);
        currentIndex=0;
        return website;
    }

    /**
     * TODO
     */
    public void switchTab(int index) {
        if (index < 0 || index >= openTabs.size()){
            throw new IndexOutOfBoundsException();
        }
        currentIndex = index;
    }

    /**
     * TODO
     */
    public String getCurrentTab() {
        if (openTabs.isEmpty()) {
            throw new NoSuchElementException();
        }
        return openTabs.get(currentIndex);
    }

    /**
     * TODO
     */
    public int getNumOpenTabs() {
        return openTabs.size();
    }

    /**
     * TODO
     */
    public void clear() {
        openTabs.clear();
        waiting = new MyLinkedQueue();
        closedTabs.clear();
        currentIndex = NO_TAB;
    }
}
