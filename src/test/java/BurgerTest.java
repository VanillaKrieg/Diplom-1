import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient ingredientMock;

    @Before
    public void setUp() {
        burger = new Burger();
        bunMock = mock(Bun.class);
        ingredientMock = mock(Ingredient.class);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertSame(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredientMock);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredientMock2 = mock(Ingredient.class);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(0, 1);
        assertSame(ingredientMock, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bunMock.getPrice()).thenReturn(20f);
        when(ingredientMock.getPrice()).thenReturn(10f);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        float expectedPrice = 60f;
        assertEquals(expectedPrice, burger.getPrice(), 0f);
    }

    @Test
    public void testGetReceipt() {
        when(bunMock.getName()).thenReturn("white bun");
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("sausage");
        when(ingredientMock.getPrice()).thenReturn(200f);
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        String expectedReceipt = "(==== white bun ====)\r\n" +
                "= filling sausage =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 200,000000\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}