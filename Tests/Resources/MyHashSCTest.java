package Resources;

import Models.BakedGoods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSCTest {
    private HashTable<BakedGoods> table = new HashTable<>(10);
    private BakedGoods goodOnBoundary = new BakedGoods("Apple-pie","cook for 20 mins","Poland", "www.google.com");
    private BakedGoods goodOnBoundary1 = new BakedGoods("Banana", "Slow bake", "Ireland", "www.gmail.com");
    private BakedGoods goodOnBoundary2 = new BakedGoods("orange","medium","Germany","www.youtube.com");



    @BeforeEach
    void setUp() {
        table.add(goodOnBoundary.hashCode(), 0);
        table = new HashTable<>(3);
    }

    @AfterEach
    void tearDown() {
        goodOnBoundary = goodOnBoundary1 = goodOnBoundary2 = null;
        table = new HashTable<>(3);
    }

    @Test
    void add() {

        table.add(goodOnBoundary1.hashCode(), 1);
        table.add(goodOnBoundary2.hashCode(), 2);
        table.displayHashTable();

    }
    @Test
    void get() {
        table.add(goodOnBoundary1.hashCode(), 1);
        table.add(goodOnBoundary2.hashCode(), 3);


        assertTrue(table.get(1)==table.hashFunction(goodOnBoundary1.hashCode()));
        table.displayHashTable();

    }
}