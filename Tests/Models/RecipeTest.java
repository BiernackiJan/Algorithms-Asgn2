package Models;

import Resources.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    private LinkedList<Recipe> list;

    private Recipe recOnBoundary,recOnBoundary1, recInvalidData;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();

        recOnBoundary = new Recipe("Apple-pie");
        recOnBoundary1 = new Recipe("Cheese Cake");
        //ingInvalidData = new Ingredient("","",0,0);
    }

    @AfterEach
    void tearDown() {
        recOnBoundary = recOnBoundary1 = recInvalidData = null;
        list = new LinkedList<>();
    }

    @Test
    void getName() {
        assertEquals("Apple-pie", recOnBoundary.getName());
    }

    @Test
    void setName() {
        assertEquals("Cheese Cake", recOnBoundary1.getName());
        recOnBoundary1.setName("Banana");
        assertEquals("Banana", recOnBoundary1.getName());
    }

//    @Test
//    void getKcal() {
//    }
//
//    @Test
//    void setKcal() {
//    }
}