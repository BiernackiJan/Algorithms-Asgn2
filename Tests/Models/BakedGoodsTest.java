package Models;

import Resources.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakedGoodsTest {
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
        goodOnBoundary = goodOnBoundary1 = goodInvalidData = null;
        list = new LinkedList<>();
    }

    @Test
    void getGoodsDesc() {
        assertEquals("cook for 20 mins", goodOnBoundary.getGoodsDesc());
        assertEquals("Slow bake", goodOnBoundary1.getGoodsDesc());
    }

    @Test
    void getGoodsName() {
        assertEquals("Apple-pie", goodOnBoundary.getGoodsName());
        assertEquals("Banana", goodOnBoundary1.getGoodsName());
    }

    @Test
    void getOriginCountry() {
        assertEquals("Poland", goodOnBoundary.getOriginCountry());
        assertEquals("Ireland", goodOnBoundary1.getOriginCountry());
    }

    @Test
    void getURL() {
        assertEquals("www.google.com", goodOnBoundary.getURL());
        assertEquals("www.gmail.com", goodOnBoundary1.getURL());
    }

    @Test
    void setGoodsDes() {
        assertEquals("cook for 20 mins", goodOnBoundary.getGoodsDesc());
        goodOnBoundary.setGoodsDes("hello");
        assertEquals("hello", goodOnBoundary.getGoodsDesc());
    }

    @Test
    void setGoodsName() {
        assertEquals("Apple-pie", goodOnBoundary.getGoodsName());
        goodOnBoundary.setGoodsName("Orange");
        assertEquals("Orange" , goodOnBoundary.getGoodsName());
    }

    @Test
    void setOriginCountry() {
        assertEquals("Poland", goodOnBoundary.getOriginCountry());
        goodOnBoundary.setOriginCountry("Germany");
        assertEquals("Germany", goodOnBoundary.getOriginCountry());
    }

    @Test
    void setURL() {
        assertEquals("www.google.com", goodOnBoundary.getURL());
        goodOnBoundary.setURL("NEW");
        assertEquals("NEW", goodOnBoundary.getURL());
    }

//    @Test
//    void checkToString() {
//        assertEquals(goodOnBoundary, goodOnBoundary.toString());
//    }

}