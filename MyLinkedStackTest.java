import org.junit.jupiter.api.*;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedStackTest {
    MyLinkedStack s;

    @BeforeEach
    void setUp() { s = new MyLinkedStack(); }

    @Test
    void testConstructor() {
        assertEquals(0, s.size());
        assertTrue(s.isEmpty());
        assertEquals("[]", s.toString());
    }

    @Test
    void testSize() {
        s.push("a");
        assertEquals(1, s.size());
        s.push("b");
        assertEquals(2, s.size());
        s.pop();
        assertEquals(1, s.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(s.isEmpty());
        s.push("a");
        assertFalse(s.isEmpty());
        s.pop();
        assertTrue(s.isEmpty());
    }

    @Test
    void testPeek() {
        assertThrows(EmptyStackException.class, () -> s.peek());
        s.push("a");
        assertEquals("a", s.peek());
        s.push("b");
        assertEquals("b", s.peek());
        assertEquals(2, s.size());
    }

    @Test
    void testPush() {
        s.push("3"); s.push("4"); s.push("5");
        assertEquals("5", s.peek());
        assertEquals(3, s.size());
        assertEquals("[5 -> 4 -> 3]", s.toString());
        assertThrows(IllegalArgumentException.class, () -> s.push(null));
    }

    @Test
    void testPop() {
        assertThrows(EmptyStackException.class, () -> s.pop());
        s.push("a"); s.push("b"); s.push("c");
        assertEquals("c", s.pop());
        assertEquals("b", s.pop());
        assertEquals("a", s.pop());
        assertThrows(EmptyStackException.class, () -> s.pop());
    }

    @Test
    void testToString() {
        assertEquals("[]", s.toString());
        s.push("3");
        assertEquals("[3]", s.toString());
        s.push("4"); s.push("5");
        assertEquals("[5 -> 4 -> 3]", s.toString());
    }

    @Test
    void testClear() {
        s.push("a"); s.push("b");
        s.clear();
        assertTrue(s.isEmpty());
        assertEquals(0, s.size());
        assertEquals("[]", s.toString());
    }
}