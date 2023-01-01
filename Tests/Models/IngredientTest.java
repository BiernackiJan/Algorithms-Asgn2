package Models;

import Resources.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    private LinkedList<Ingredient> list;

    private Ingredient ingOnBoundary,ingOnBoundary1, ingInvalidData;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();

        ingOnBoundary = new Ingredient("sugar", "sweet", 12, 10);
        ingOnBoundary1 = new Ingredient("milk", "full fat", 15, 20);
        //ingInvalidData = new Ingredient("","",0,0);
    }

    @AfterEach
    void tearDown() {
        ingOnBoundary = ingOnBoundary1 = ingInvalidData = null;
        list = new LinkedList<>();
    }

    @Test
    void getIngName() {
        assertEquals("sugar", ingOnBoundary.getIngName());
    }

    @Test
    void getIngDes() {
        assertEquals("sweet", ingOnBoundary.getIngDes());
    }

    @Test
    void getCalories() {
        assertEquals(12, ingOnBoundary.getCalories());
    }

    @Test
    void getAmount() {
        assertEquals(10, ingOnBoundary.getAmount());
    }

    @Test
    void getKcal() {
        assertEquals(ingOnBoundary.getCalories()/ingOnBoundary.getAmount(), ingOnBoundary.getKcal());
    }

    @Test
    void setIngName() {
        assertEquals("milk", ingOnBoundary1.getIngName());
        ingOnBoundary1.setIngName("apple");
        assertEquals("apple", ingOnBoundary1.getIngName());
    }

    @Test
    void setIngDes() {
        assertEquals("full fat", ingOnBoundary1.getIngDes());
        ingOnBoundary1.setIngDes("skimmed");
        assertEquals("skimmed", ingOnBoundary1.getIngDes());
    }

//    @Test
//    void setCalories() {
//        assertEquals(15, ingOnBoundary1.getCalories());
//        ingOnBoundary1.setCalories(13);
//        assertEquals(13, ingOnBoundary1.getCalories());
//    }

    @Test
    void setAmount() {
        assertEquals(20, ingOnBoundary1.getAmount());
        ingOnBoundary1.setAmount(3);
        assertEquals(3, ingOnBoundary1.getAmount());
    }
}