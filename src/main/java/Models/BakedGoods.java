package Models;

import Resources.LinkedList;
import Resources.MyHashSC;

public class BakedGoods {
    public LinkedList<Recipe> recipes = new LinkedList<>();
    public MyHashSC<Recipe> recipeHashTable = new MyHashSC<>(10);

    private String goodsName;
    private String goodsDes;
    private String originCountry;
    private String URL;

    public BakedGoods(String goodsName, String goodsDes, String originCountry, String URL) {
        this.goodsName = goodsName;
        this.goodsDes = goodsDes;
        this.originCountry = originCountry;
        this.URL = URL;
    }

    //Getters--------------------------------------------------
    public String getGoodsDesc() {
        return goodsDes;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getURL() {
        return URL;
    }

    //Setters-------------------------------------------------
    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    //Methods--------------------------------------------------

    public String fullString() {
        return  "  " + goodsName + ",  " + goodsDes +
                "  Originated in: " + originCountry + '\n'
                + recipes.listAll();
    }

    public String oneString() {
        return  "  " + goodsName + ",  " + goodsDes +
                "  Originated in: " + originCountry + '\n'
                + recipes.listOne();
    }


    @Override
    public String toString() {
        return  goodsName + ",  " + goodsDes +
                "  Originated in: " + originCountry + '\n' ;
    }
}
