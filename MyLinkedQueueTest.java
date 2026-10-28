import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedQueueTest {
    MyLinkedQueue q;

    @BeforeEach
    void setUp() { q = new MyLinkedQueue(); }

    @Test
    void testConstructor() {
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
        assertEquals("[]", q.toString());
    }

    @Test
    void testSize() {
        q.enqueue("a");
        assertEquals(1, q.size());
        q.enqueue("b");
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(q.isEmpty());
        q.enqueue("a");
        assertFalse(q.isEmpty());
        q.dequeue();
        assertTrue(q.isEmpty());
    }

    @Test
    void testEnqueue() {
        q.enqueue("a"); q.enqueue("b"); q.enqueue("c");
        assertEquals("a", q.peek());
        assertEquals(3, q.size());
        assertEquals("[a -> b -> c]", q.toString());
        assertThrows(IllegalArgumentException.class, () -> q.enqueue(null));
    }

    @Test
    void testPeek() {
        assertNull(q.peek());
        q.enqueue("a"); q.enqueue("b");
        assertEquals("a", q.peek());
        assertEquals("a", q.peek());
        q.dequeue();
        assertEquals("b", q.peek());
    }

    @Test
    void testDequeue() {
        assertNull(q.dequeue());
        q.enqueue("a"); q.enqueue("b"); q.enqueue("c");
        assertEquals("a", q.dequeue());
        assertEquals("b", q.dequeue());
        assertEquals("c", q.dequeue());
        assertNull(q.dequeue());
    }

    @Test
    void testToString() {
        assertEquals("[]", q.toString());
        q.enqueue("3"); q.enqueue("4"); q.enqueue("5");
        assertEquals("[3 -> 4 -> 5]", q.toString());
        assertEquals("[3 -> 4 -> 5]", q.toString());
        assertEquals(3, q.size());
    }
}