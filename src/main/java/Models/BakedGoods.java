package Models;

import Resources.LinkedList;

public class BakedGoods {
    public LinkedList<Recipe> recipes = new LinkedList<>();

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
    public String getGoodsType() {
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
    public void setGoodsType(String goodsType) {
        this.goodsDes = goodsType;
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


    @Override
    public String toString() {
        return  "  " + goodsName + ",  " + goodsDes +
                "  Originated in: " + originCountry + '\n' ;
    }
}
