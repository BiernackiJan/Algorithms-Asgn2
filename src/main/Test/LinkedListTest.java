import Resources.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListTest {
    LinkedList<Integer> list = new LinkedList<>();
    @BeforeEach
    void setUp() {

        list.add(1);
        list.add(3);
        list.add(4);
    }

    @AfterEach
    void tearDown() {
        list.delAll();
    }

    @Test
    void addAtIndexHead() {
        assertEquals(1,list.getHead().getData());
        list.addAtIndex(0,0);
        assertEquals(0,list.getHead().getData());
        assertEquals(1,list.get(1));



        assertNull(list.get(5));
        list.addAtIndex(5,5);
        assertEquals(5, list.get(5));
    }

    @Test
    void addAtIndexCentre(){
        assertEquals(3, list.get(1));
        list.addAtIndex(2,2);
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }
}
