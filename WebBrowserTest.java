import org.junit.jupiter.api.*;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class WebBrowserTest {
    WebBrowser b;

    @BeforeEach
    void setUp() { b = new WebBrowser(); }

    void openThree() {
        b.addToQueue("a"); b.addToQueue("b"); b.addToQueue("c");
        b.openNextTab(); b.openNextTab(); b.openNextTab();
    }

    @Test
    void testConstructor() {
        assertEquals(0, b.getNumOpenTabs());
        assertThrows(NoSuchElementException.class, () -> b.getCurrentTab());
        assertThrows(NoSuchElementException.class, () -> b.openNextTab());
        assertThrows(EmptyStackException.class, () -> b.reopenClosedTab());
    }

    @Test
    void testAddToQueue() {
        b.addToQueue("a"); b.addToQueue("b");
        assertEquals(0, b.getNumOpenTabs());
        assertEquals("a", b.openNextTab());
        assertEquals("b", b.openNextTab());
        assertThrows(IllegalArgumentException.class, () -> b.addToQueue(null));
    }

    @Test
    void testOpenNextTab() {
        openThree();
        assertEquals(3, b.getNumOpenTabs());
        assertEquals("c", b.getCurrentTab());
        assertThrows(NoSuchElementException.class, () -> b.openNextTab());
    }

    @Test
    void testCloseCurrentTab() {
        openThree();
        b.switchTab(1);
        assertEquals("b", b.closeCurrentTab());
        assertEquals("c", b.getCurrentTab());
        assertEquals("c", b.closeCurrentTab());
        assertEquals("a", b.getCurrentTab());
        assertEquals("a", b.closeCurrentTab());
        assertEquals(0, b.getNumOpenTabs());
        assertThrows(NoSuchElementException.class, () -> b.closeCurrentTab());
    }

    @Test
    void testReopenClosedTab() {
        openThree();
        b.closeCurrentTab();
        b.closeCurrentTab();
        assertEquals("b", b.reopenClosedTab());
        assertEquals("b", b.getCurrentTab());
        assertEquals("c", b.reopenClosedTab());
        assertEquals(3, b.getNumOpenTabs());
        assertThrows(EmptyStackException.class, () -> b.reopenClosedTab());
    }

    @Test
    void testSwitchTab() {
        openThree();
        b.switchTab(0);
        assertEquals("a", b.getCurrentTab());
        b.switchTab(2);
        assertEquals("c", b.getCurrentTab());
        assertThrows(IndexOutOfBoundsException.class, () -> b.switchTab(3));
        assertThrows(IndexOutOfBoundsException.class, () -> b.switchTab(-1));
    }

    @Test
    void testGetCurrentTab() {
        assertThrows(NoSuchElementException.class, () -> b.getCurrentTab());
        b.addToQueue("a");
        b.openNextTab();
        assertEquals("a", b.getCurrentTab());
        b.closeCurrentTab();
        assertThrows(NoSuchElementException.class, () -> b.getCurrentTab());
    }

    @Test
    void testGetNumOpenTabs() {
        assertEquals(0, b.getNumOpenTabs());
        openThree();
        assertEquals(3, b.getNumOpenTabs());
        b.closeCurrentTab();
        assertEquals(2, b.getNumOpenTabs());
    }

    @Test
    void testClear() {
        openThree();
        b.addToQueue("d");
        b.closeCurrentTab();
        b.clear();
        assertEquals(0, b.getNumOpenTabs());
        assertThrows(NoSuchElementException.class, () -> b.getCurrentTab());
        assertThrows(NoSuchElementException.class, () -> b.openNextTab());
        assertThrows(EmptyStackException.class, () -> b.reopenClosedTab());
    }
}