import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Test Bun", 50f);
    }

    @Test
    public void testConstructor() {
        assertEquals("Test Bun", bun.getName());
        assertEquals(50f, bun.getPrice(), 0f);
    }

    @Test
    public void testGetName() {
        assertEquals("Test Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50f, bun.getPrice(), 0f);
    }

    @Test
    public void testMockedBun() {
        Bun mockedBun = mock(Bun.class);
        when(mockedBun.getName()).thenReturn("Mocked Bun");
        when(mockedBun.getPrice()).thenReturn(25f);
        assertEquals("Mocked Bun", mockedBun.getName());
        assertEquals(25f, mockedBun.getPrice(), 0f);
    }

}