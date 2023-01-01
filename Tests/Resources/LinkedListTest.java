package Resources;

import Models.BakedGoods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<BakedGoods> list;

    private BakedGoods goodOnBoundary,goodOnBoundary1, goodInvalidData;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();

        goodOnBoundary = new BakedGoods("Apple-pie","cook for 20 mins","Poland", "www.google.com");
        goodOnBoundary1 = new BakedGoods("Banana", "Slow bake", "Ireland", "www.gmail.com");
        goodInvalidData = new BakedGoods("","","","");
    }

    @AfterEach
    void tearDown() {
        goodOnBoundary = goodInvalidData = null;
        list = new LinkedList<>();
    }

    @Test
    void isListEmpty(){
        assertEquals(0, list.numNodes());
        assertTrue(list.isEmpty());
    }

    @Test
    void addToEndOfList(){
        list.add(goodOnBoundary);
        assertEquals(1, list.numNodes());
        assertFalse(list.isEmpty());

    }

    @Test
    void addToStartOfList(){
        list.add(goodOnBoundary);
        assertEquals(1, list.numNodes());
        assertEquals(list.get(0), goodOnBoundary);
        assertFalse(list.isEmpty());

        list.add(0, goodOnBoundary1);
        assertEquals(2, list.numNodes());
        assertEquals(list.get(0), goodOnBoundary1);

    }

    @Test
    void deleteFromList(){
        list.add(goodOnBoundary);
        assertEquals(1, list.numNodes());
        assertFalse(list.isEmpty());

        list.delAll();
        assertEquals(0, list.numNodes());
        assertTrue(list.isEmpty());
    }

    @Test
    void deleteNode(){
        list.add(goodOnBoundary);
        list.add(goodOnBoundary);
        assertEquals(2, list.numNodes());
        assertFalse(list.isEmpty());

        list.deleteNode(1);
        assertEquals(1, list.numNodes());
        assertFalse(list.isEmpty());
    }

    @Test
    void listOneNode(){
        list.add(goodOnBoundary);
        list.add(goodInvalidData);
        assertEquals(2, list.numNodes());

        assertEquals(goodInvalidData.toString(), list.listOne());

    }

    @Test
    void listAllNode(){
        list.add(goodOnBoundary);
        list.add(goodInvalidData);
        assertEquals(2, list.numNodes());

        assertEquals(goodOnBoundary.toString() + goodInvalidData.toString(), list.listAll());
    }

    @Test
    void getNode(){
        list.add(goodOnBoundary);
        list.add(goodOnBoundary1);
        assertEquals(2, list.numNodes());

        assertEquals(list.get(0), goodOnBoundary);

    }

}