import org.junit.jupiter.api.*;
import java.util.AbstractList;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    AbstractList<String> list;

    @BeforeEach
    void setUp() { list = new DoublyLinkedList(); }

    @Test
    void testConstructor() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertEquals("[(head) -> (tail)]", list.toString());
    }

    @Test
    void testAdd() {
        assertTrue(list.add("a"));
        assertTrue(list.add("b"));
        assertTrue(list.add("c"));
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(2));
        assertEquals(3, list.size());
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void testAddIndex() {
        list.add(0, "b");
        list.add(0, "a");
        list.add(2, "d");
        list.add(2, "c");
        assertEquals("[(head) -> a -> b -> c -> d -> (tail)]", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "x"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, "x"));
        assertThrows(NullPointerException.class, () -> list.add(0, null));
    }

    @Test
    void testClear() {
        list.add("a"); list.add("b");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertEquals("[(head) -> (tail)]", list.toString());
        list.add("z");
        assertEquals("z", list.get(0));
    }

    @Test
    void testContains() {
        list.add("a"); list.add("b");
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertFalse(list.contains("c"));
        assertFalse(new DoublyLinkedList().contains("a"));
    }

    @Test
    void testGet() {
        list.add("a"); list.add("b"); list.add("c"); list.add("d");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("d", list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("a");
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemove() {
        list.add("a"); list.add("b"); list.add("c"); list.add("d");
        assertEquals("b", list.remove(1));
        assertEquals("d", list.remove(2));
        assertEquals("a", list.remove(0));
        assertEquals("[(head) -> c -> (tail)]", list.toString());
        assertEquals(1, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testSet() {
        list.add("a"); list.add("b"); list.add("c");
        assertEquals("a", list.set(0, "x"));
        assertEquals("c", list.set(2, "z"));
        assertEquals("b", list.set(1, "y"));
        assertEquals("[(head) -> x -> y -> z -> (tail)]", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "q"));
        assertThrows(NullPointerException.class, () -> list.set(0, null));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add("a"); list.add(0, "b");
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    void testToString() {
        assertEquals("[(head) -> (tail)]", list.toString());
        list.add("3");
        assertEquals("[(head) -> 3 -> (tail)]", list.toString());
        list.add("4"); list.add("5");
        assertEquals("[(head) -> 3 -> 4 -> 5 -> (tail)]", list.toString());
    }
}