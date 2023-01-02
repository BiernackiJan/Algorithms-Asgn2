package Resources;

import Models.BakedGoods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSCTest {
    private LinkedList<BakedGoods> list;

    private BakedGoods goodOnBoundary,goodOnBoundary1, goodOnBoundary2;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();

        goodOnBoundary = new BakedGoods("Apple-pie","cook for 20 mins","Poland", "www.google.com");
        goodOnBoundary1 = new BakedGoods("Banana", "Slow bake", "Ireland", "www.gmail.com");
        goodOnBoundary2 = new BakedGoods("orange","medium","Germany","www.youtube.com");
    }

    @AfterEach
    void tearDown() {
        goodOnBoundary = goodOnBoundary1 = goodOnBoundary2 = null;
        list = new LinkedList<>();
    }

    @Test
    void add() {
        HashTable table = new HashTable(3);
        table.add(goodOnBoundary);
        table.add(goodOnBoundary1);
        table.add(goodOnBoundary2, 3);

        table.displayHashTable();

    }

    @Test
    void testAdd() {
    }

    @Test
    void get() {
        MyHashSC<BakedGoods> table = new MyHashSC<>(3);
        table.add(goodOnBoundary);
        table.add(goodOnBoundary1);
        table.add(goodOnBoundary2, 3);

        assertTrue(table.contains(goodOnBoundary));
        table.displayHashTable();
        //System.out.println(goodOnBoundary);

        //assertEquals(goodOnBoundary, table.get(1));
    }
}