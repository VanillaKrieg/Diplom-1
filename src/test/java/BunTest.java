import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class BunTest {

    @RunWith(Parameterized.class)
    public static class ParameterizedTests {
        private final String name;
        private final float price;

        public ParameterizedTests(String name, float price) {
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters(name = "{index}: Name={0}, Price={1}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    { "Test Bun", 50f }, // normal bun
                    { "", 50f }, // empty name
                    { null, 50f }, // null name
                    { "Very long name that exceeds maximum length", 50f }, // very long name
                    { "~!@#$%^&*()", 50f }, // name with special characters
                    { "Test Bun", -50f }, // negative price
                    { "Test Bun", 0f }, // zero price
                    { "Test Bun", Float.MIN_VALUE }, // minimum positive price
                    { "Test Bun", Float.MAX_VALUE } // maximum positive price
            });
        }

        @Test
        public void testBun() {
            Bun bun = new Bun(name, price);
            assertEquals(name, bun.getName());
            assertEquals(price, bun.getPrice(), 0f);
        }
    }

    public static class MockedTests {
        @Test
        public void testMockedBun() {
            Bun mockedBun = mock(Bun.class);
            when(mockedBun.getName()).thenReturn("Mocked Bun");
            when(mockedBun.getPrice()).thenReturn(25f);
            assertEquals("Mocked Bun", mockedBun.getName());
            assertEquals(25f, mockedBun.getPrice(), 0f);
        }
    }
}